package com.qa.model.dao

import com.qa.model.entity.CustomerOrder
import com.qa.model.sql.Database._
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Query

/**
  * Created by cboucher on 24/11/2015.
  */
object CustomerOrderDAO {

  /**
    * Finds all customer orders in the database
    * @return A query for all customer orders
    */
  def findAll: Query[CustomerOrder] = from(customerOrderTable) {
    customerOrder => select(customerOrder)
  }

  /**
    * Finds all customer orders with a specific order id.
    * @param id The id of the customer orde to search for.
    * @return A query for a specific order.
    */
  def findByOrderID(id: Int): Query[CustomerOrder] = from(customerOrderTable) {
    customerOrder => {
      where(customerOrder.id === id).
        select(customerOrder)
    }
  }

  /**
    * Finds all customer orders with a specific customer id.
    * @param idCustomer The id of the customer.
    * @return A query for a orders with the specified customer id.
    */
  def findByCustomerID(idCustomer: Int): Query[CustomerOrder] = from(customerOrderTable) {
    customerOrder => {
      where(customerOrder.idCustomer === idCustomer).
        select(customerOrder)
    }
  }

  /**
    * Finds all customer orders with a specific employee id.
    * @param idEmployee The id of the employee.
    * @return A query for all orders with the specified employee id.
    */
  def findByEmployeeID(idEmployee: Int): Query[CustomerOrder] = from(customerOrderTable) {
    customerOrder => {
      where(customerOrder.idEmployee === idEmployee).
        select(customerOrder)
    }
  }

  /**
    * Updates a customer order in the table
    * @param customerOrder The customer order to update
    */
  def update(customerOrder: CustomerOrder) {
    inTransaction {
      customerOrderTable.update(customerOrder)
    }
  }

  /**
    * Inserts a customer order into the table
    * @param customerOrder The customer order to insert.
    * @return The inserted customer order.
    */
  def insert(customerOrder: CustomerOrder): CustomerOrder = inTransaction {
    customerOrderTable.insert(customerOrder)
  }

  /**
    * Gets all related customer order lines.
    * @param customerOrder The customer order to query.
    * @return A list of customer order lines.
    */
  def getCustomerOrderLines(customerOrder: CustomerOrder) = inTransaction {
    customerOrder.customerOrderLines.toList
  }
}
