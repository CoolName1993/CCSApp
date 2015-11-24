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
    * @return A query for a orders with the specified employee id.
    */
  def findByEmployeeID(idEmployee: Int): Query[CustomerOrder] = from(customerOrderTable) {
    customerOrder => {
      where(customerOrder.idEmployee === idEmployee).
        select(customerOrder)
    }
  }
}
