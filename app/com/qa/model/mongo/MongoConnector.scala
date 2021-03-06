package com.qa.model.mongo

import com.mongodb.casbah.Imports._
import com.qa.model.entity.Field

/**
 * Connects to the MongoDB database and performs R operations. <br/>
 * Does not require initialisation.
 * @author cboucher
 */
object MongoConnector {

  // String to specify URL to MongoDB
  val mongoURL = "localhost"

  // The name of the MongoDB database
  val databaseName = "nbgardensdata"

  // The connection to the database
  var connection: MongoConnection = _

  /**
    * Searches a collection in the database for matching entities.
    * @param collectionName The name of the collection to access
    * @param fields An array of fields used as search parameters
    */
  def read(collectionName: String, fields: Array[Field]): Array[MongoDBObject] = {
    def createMongoObject: MongoDBObject = {
      val output = MongoDBObject.empty
      def addField(i: Int) {
        if (i < fields.length) {
          output.put(fields(i).getFieldName, fields(i).getValue)
          addField(i + 1)
        }
      }
      addField(0)
      output
    }
    try {
      connect()
      val collection = connection(databaseName)(collectionName)
      val searchItem = createMongoObject
      val cursor = collection.find(searchItem)
      val outputArray = new Array[MongoDBObject](cursor.size)
      def fillArray(i: Int) {
        if (cursor.hasNext && i <= outputArray.length) {
          outputArray(i) = cursor.next
          fillArray(i + 1)
        }
      }
      fillArray(0)
      disconnect()
      outputArray
    } catch {
      case e: Exception =>
        e.printStackTrace()
        disconnect()
        null

    }
  }

  def readAll(collectionName: String): Array[MongoDBObject] = {
    try {
      connect()
      val collection = connection(databaseName)(collectionName)
      val cursor = collection.find(MongoDBObject.empty)
      val outputArray = new Array[MongoDBObject](cursor.size)
      def fillArray(i: Int) {
        if (cursor.hasNext && i <= outputArray.length) {
          outputArray(i) = cursor.next
          fillArray(i + 1)
        }
      }
      fillArray(0)
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
    * Establishes the connection to the database.
    * @return Whether or not the connection was successful.
    */
  def connect(): Unit = {
    try {
      connection = MongoConnection(mongoURL, 27017)
    } catch {
      case e: Exception =>
        e.printStackTrace()

    }
  }

  /**
    * Closes the connection to the database.
    */
  def disconnect(): Unit = {
    connection.close
  }
}