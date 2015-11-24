package com.qa.model.entity

import org.squeryl.KeyedEntity

/**
 * Represents a Customer Order Status from the MySQL database.
  * @param id The customer order status ID.
  * @param status The string representation of the status.
 * @author cboucher
 */
case class CustomerOrderStatus(id: Int,
                               status: String) extends KeyedEntity[Int]