package com.qa.model.dao

import com.qa.model.entity.CustomerOrderLine
import com.qa.model.sql.Database._
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Query

/**
  * Created by cboucher on 24/11/2015.
  */
object CustomerOrderLineDAO {
  /**
    * Finds all customer order lines in the database
    * @return A query for all customer order lines
    */
  def findAll: Query[CustomerOrderLine] = from(customerOrderLineTable) {
    customerOrderLine => select(customerOrderLine)
  }

  /**
    * Finds all customer order lines with a specific order id.
    * @param idCustomerOrder The customer order to search for.
    * @return A query for all order lines of the specific order.
    */
  def findByOrderID(idCustomerOrder: Int): Query[CustomerOrderLine] = from(customerOrderLineTable) {
    customerOrderLine => {
      where(customerOrderLine.idCustomerOrder === idCustomerOrder).
        select(customerOrderLine)
    }
  }
}
