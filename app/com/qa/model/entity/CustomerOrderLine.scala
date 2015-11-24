package com.qa.model.entity

import org.squeryl.KeyedEntity
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.dsl.CompositeKey2

/**
 * Represents a Customer Order Line from the MySQL database.
  * @param idItem The item ID.
  * @param idCustomerOrder The customer order ID.
  * @param quantity The quantity of the item.
 * @author cboucher
 */
case class CustomerOrderLine(idItem: Int,
                             idCustomerOrder: Int,
                             quantity: Int) extends KeyedEntity[CompositeKey2[Int, Int]] {
  def id = compositeKey(idItem, idCustomerOrder)
}