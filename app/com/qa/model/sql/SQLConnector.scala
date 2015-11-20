package com.qa.model.sql

import java.sql.{Connection, ResultSet, ResultSetMetaData, Types}
import javax.sql.DataSource

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import com.qa.model.entity.Field

/**
  * Connects to the MySQL database and performs CRU operations. <br/>
  * Does not require initialisation.
  * @author cboucher
  */
object SQLConnector {

  // The connection to the database
  var connection: Connection = _

  /**
    * Creates a new entity in the selected table.
    * @param tableName The name of the table to insert into.
    * @param columns The names of the columns in the table.
    */
  def create(tableName: String, columns: Array[Field]): Unit = {

    /**
      * Creates the column section of the query
      */
    def createColumnString: String = {
      var output = ""
      def addString(i: Int): Unit = {
        if (i < columns.length) {
          if (i == 0) {
            output = columns(i).getFieldName
          } else {
            output = output + ", " + columns(i).getFieldName
          }
          addString(i + 1)
        }
      }
      addString(0)
      output
    }

    /**
      * Creates the value section of the query
      */
    def createValueString: String = {
      var output = ""
      def addString(i: Int): Unit = {
        if (i < columns.length) {
          if (i == 0) {
            output = "" + columns(i).getValue
          } else {
            output = output + ", " + columns(i).getValue
          }
          addString(i + 1)
        }
      }
      addString(0)
      output
    }

    // Attempt to perform query
    try {
      connect()

      // Configure to be updatable
      val statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)

      // Prepare the statement
      val preparedStatement = connection.prepareStatement("INSERT INTO " + tableName + " (" + createColumnString + ") VALUES (" + createValueString + ")")

      println(preparedStatement)

      // Execute the insert
      preparedStatement.executeUpdate

    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      disconnect()
    }
  }

  /**
    * Searches a table in the database for matching entities.
    * @param tableName The name of the table to read from.
    * @param columns The names of the columns to be queried in the table.
    * @return The results of the search.
    */
  def read(tableName: String, columns: Array[Field]): Array[Array[Any]] = {
    def createColumnValuePairs: String = {
      var output = ""
      def createPairs(i: Int) {
        if (i < columns.length) {
          if (columns(i).getValue != null) {
            output = output + " AND " + columns(i).getFieldName + "='" + columns(i).getValue + "'"
          }
          createPairs(i + 1)
        }
      }
      def findFirst(j: Int) {
        if (j < columns.length) {
          if (columns(j).getValue == null) {
            findFirst(j + 1)
          }
          else {
            output = " WHERE " + columns(j).getFieldName + "='" + columns(j).getValue + "'"
            createPairs(j + 1)
          }
        }
      }
      findFirst(0)
      output
    }
    try {
      connect()

      // Configure to be read only and allow movement both up and down
      val statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)

      // Execute the query
      println("SELECT * FROM " + tableName + createColumnValuePairs)
      val resultSet = statement.executeQuery("SELECT * FROM " + tableName + createColumnValuePairs)

      // Get result length
      var rowCount: Int = 0
      if (resultSet.last) {
        rowCount = resultSet.getRow
        resultSet.beforeFirst()
      }

      // Create the output as a 2D array of any type
      val outputArray: Array[Array[Any]] = Array ofDim[Any](rowCount, columns.length)

      // Iterate over the result set
      def storeObjectRow(x: Int) {
        def storeObjectColumn(y: Int) {
          if (y < columns.length) {
            val rsMetaData: ResultSetMetaData = resultSet.getMetaData
            val resultType = rsMetaData.getColumnType(y + 1)
            resultType match {
              case Types.INTEGER => outputArray(x)(y) = resultSet.getInt(columns(y).getFieldName)
              case Types.DATE => outputArray(x)(y) = resultSet.getDate(columns(y).getFieldName)
              case Types.CHAR => outputArray(x)(y) = resultSet.getString(columns(y).getFieldName)
              case Types.VARCHAR => outputArray(x)(y) = resultSet.getString(columns(y).getFieldName)
              case Types.TINYINT => outputArray(x)(y) = resultSet.getInt(columns(y).getFieldName)
              case _ => outputArray(x)(y) = null
            }
            storeObjectColumn(y + 1)
          }
        }
        if (resultSet.next) {
          storeObjectColumn(0)
          storeObjectRow(x + 1)
        }
      }

      // Run the above code and return the output array
      storeObjectRow(0)
      disconnect()
      outputArray
    } catch {
      case e: Exception =>
        e.printStackTrace()
        disconnect()
        null
    }
  }

  /**
    * Updates an entity in the selected table.
    * @param tableName The name of the table to update.
    * @param columns The names of the columns in the table.
    * @param primaryKeyColumns The names of each primary key column in the table.
    */
  def update(tableName: String, columns: Array[Field], primaryKeyColumns: Array[Field]): Unit = {
    def createColumnUpdate: String = {
      var output = ""
      def createPairs(i: Int) {
        if (i < columns.length) {
          if (i == 0) {
            output = columns(i).getFieldName + "='" + columns(i).getValue + "'"
          } else {
            output = output + ", " + columns(i).getFieldName + "='" + columns(i).getValue + "'"
          }
          createPairs(i + 1)
        }
      }
      createPairs(0)
      output
    }
    def createPrimaryKeyString: String = {
      var output = ""
      def createKeyPair(i: Int) {
        if (i < primaryKeyColumns.length) {
          if (i == 0) {
            output = primaryKeyColumns(i).getFieldName + "='" + primaryKeyColumns(i).getValue + "'"
          } else {
            output = output + " AND " + primaryKeyColumns(i).getFieldName + "='" + primaryKeyColumns(i).getValue + "'"
          }
          createKeyPair(i + 1)
        }
      }
      createKeyPair(0)
      output
    }
    try {
      connect()
      // Configure to be updatable
      val statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)

      // Prepare the statement
      val preparedStatement = connection.prepareStatement("UPDATE " + tableName + " SET " + createColumnUpdate + " WHERE " + createPrimaryKeyString)

      // Execute the update
      preparedStatement.executeUpdate
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      disconnect()
    }
  }

  /**
    * Establishes the connection to the database.
    */
  def connect(): Unit = {
    try {
      connection = dataSource.getConnection
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }

  /**
    * Configures the information required to connect to the database.
    */
  def dataSource: DataSource = {
    val dataSource = new MysqlDataSource
    dataSource.setDatabaseName("nbgardensdata")
    dataSource.setUser("root")
    dataSource.setPassword("password")
    dataSource.setServerName("localhost")
    dataSource
  }

  /**
    * Closes the connection to the database.
    */
  def disconnect(): Unit = {
    try {
      connection.close()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}