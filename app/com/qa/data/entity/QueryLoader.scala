package com.qa.data.entity

import com.qa.data.mongo.MongoConnector
import com.qa.data.sql.SQLConnector

import scala.collection.mutable.ListBuffer

/**
 * Contains all queries required for the application.
 * @author cboucher
 */
object QueryLoader {

  /**
   *  Searches the database for matching customer orders.
   *  @param selectedCustomerOrder The customer order to search for.
   *  @return An array of results.
   */
  def searchCustomerOrder(selectedCustomerOrder: CustomerOrder): Array[CustomerOrder] = {
    val searchOrder = new CustomerOrder(selectedCustomerOrder.idCustomerOrder.getValue, null, null, null, null, null, null, null)
    val searchValues = Array(selectedCustomerOrder.idCustomerOrder, selectedCustomerOrder.datePlaced, selectedCustomerOrder.dateShipped, selectedCustomerOrder.isPaid, selectedCustomerOrder.idAddress, selectedCustomerOrder.idCustomerOrderStatus, selectedCustomerOrder.idEmployee, selectedCustomerOrder.idCustomer)
    val currentOrders = SQLConnector.read(searchOrder.tableName, searchValues)
    println(currentOrders.length)
    if (currentOrders.length > 0) {
      val output = new Array[CustomerOrder](currentOrders.length)
      def loop(i: Int) {
        if (i < currentOrders.length) {
          output(i) = EntityConvertor.convertToCustomerOrder(currentOrders(i))
          loop(i + 1)
        }
      }
      loop(0)
      output
    } else {
      null
    }
  }

  /**
   *  Searches the database for all lines in the current customer order.
   *  @param selectedCustomerOrder The customer order to search for.
   *  @return An array of results.
   */
  def searchCustomerOrderLine(selectedCustomerOrder: CustomerOrder): Array[CustomerOrderLine] = {
    val searchOrderLine = new CustomerOrderLine(null, selectedCustomerOrder.idCustomerOrder.getValue, null)
    val searchValues = Array(searchOrderLine.idItem, searchOrderLine.idCustomerOrder, searchOrderLine.quantity)
    val currentOrderLines = SQLConnector.read(searchOrderLine.tableName, searchValues)
    if (currentOrderLines.length > 0) {
      val output = new Array[CustomerOrderLine](currentOrderLines.length)
      def loop(i: Int) {
        if (i < currentOrderLines.length) {
          output(i) = EntityConvertor.convertToCustomerOrderLine(currentOrderLines(i))
          loop(i + 1)
        }
      }
      loop(0)
      output
    } else {
      null
    }
  }

  /**
   *  Searches the database for all locations associated with an item.
   *  @param selectedItem The item to search for.
   *  @return An array of results.
   */
  def searchLocation(selectedItem: Item): Array[Location] = {
    val searchLocation = new Location(null, selectedItem.idItem.getValue, null, null, null)
    val searchValues = Array(searchLocation.idLocation, searchLocation.idItem, searchLocation.row, searchLocation.col, searchLocation.quantity)
    val currentLocations = SQLConnector.read(searchLocation.tableName, searchValues)
    if (currentLocations.length > 0) {
      val output = new Array[Location](currentLocations.length)
      def loop(i: Int) {
        if (i < currentLocations.length) {
          output(i) = EntityConvertor.convertToLocation(currentLocations(i))
          loop(i + 1)
        }
      }
      loop(0)
      output
    } else {
      null
    }
  }

  /**
   *  Searches the database for a matching user.
   *  @param selectedUser The user to search for.
   *  @return The results of the search.
   */
  def searchUser(selectedUser: User): User = {
    val searchUser = new User(selectedUser.idUser.getValue.asInstanceOf[Int], selectedUser.password.getValue.asInstanceOf[String], null, null, null, 1)
    val searchValues = Array(searchUser.idUser, searchUser.password, searchUser.forename, searchUser.surname, searchUser.email, searchUser.isEmployee)
    val currentUser = SQLConnector.read(searchUser.tableName, searchValues)
    if (currentUser.length != 0) {
      val output = EntityConvertor.convertToUser(currentUser(0))
      output
    } else {
      null
    }
  }

  /**
   *  Searches the database for a matching item.
   *  @param selectedItem The item to search for.
   *  @return The results of the search.
   */
  def searchItem(selectedItem: Item): Item = {
    val searchValues = Array(selectedItem.idItem)
    val currentItem = MongoConnector.read(selectedItem.tableName, searchValues)
    if (currentItem.length != 0) {
      val output = EntityConvertor.convertToItem(currentItem(0))
      output
    } else {
      null
    }
  }

  /**
    * Gets all items from the item collection in the database.
    * @return The results of the search.
    */
  def listItems(keyword: String): Array[Item] = {
    val items = MongoConnector.readAll(new Item(null, null, null, null, null).tableName)
    val itemArray = new Array[Item](items.length)
    def loop(i: Int): Unit = {
      if (i < items.length) {
        itemArray(i) = EntityConvertor.convertToItem(items(i))
        loop(i + 1)
      }
    }
    loop(0)
    val itemList = new ListBuffer[Item]
    def searchKey(i: Int): Unit = {
      if (i < itemArray.length) {
        if (itemArray(i).keyword != null && itemArray(i).keyword.equals(keyword)) {
          itemList.+=(itemArray(i))
        }
        searchKey(i + 1)
      }
    }
    if (keyword != null) {
      searchKey(0)
      itemList.toArray
    } else {
      itemArray
    }

  }
}