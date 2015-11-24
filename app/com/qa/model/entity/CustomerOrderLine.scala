package com.qa.model.entity

import org.squeryl.KeyedEntity

/**
 * Represents a Customer Order Line from the MySQL database.
  * @param id The item ID.
  * @param idCustomerOrder The customer order ID.
  * @param quantity The quantity of the item.
 * @author cboucher
 */
case class CustomerOrderLine(id: Int,
                             idCustomerOrder: Int,
                             quantity: Int) extends KeyedEntity[Int]