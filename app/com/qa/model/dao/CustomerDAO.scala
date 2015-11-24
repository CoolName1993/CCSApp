package com.qa.model.dao

import com.qa.model.entity.Customer
import com.qa.model.sql.Database._
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Query

/**
  * @author cboucher
  */
object CustomerDAO {

  /**
    * Finds all customers in the database
    * @return A query for all customers
    */
  def findAll: Query[Customer] = from(customerTable) {
    customer => select(customer)
  }

  /**
    * Finds all customers with the specified id.
    * @param id The id to search for.
    * @return A query for a specific customer.
    */
  def findByID(id: Int): Query[Customer] = from(customerTable) {
    customer => {
      where(customer.id === id).
        select(customer)
    }
  }
}
