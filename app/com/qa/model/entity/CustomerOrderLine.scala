package com.qa.model.entity

/**
 * Represents a Customer Order Line from the MySQL database.
 * @param idItem_ The item ID.
 * @param idCustomerOrder_ The customer order ID.
 * @param quantity_ The quantity of the item.
 * @author cboucher
 */
class CustomerOrderLine(idItem_ : Any, idCustomerOrder_ : Any, quantity_ : Any) extends Entity {
  val tableName = "customerorderline"
  val idItem = new Field("idItem", idItem_)
  val idCustomerOrder = new Field("idCustomerOrder", idCustomerOrder_)
  val quantity = new Field("quantity", quantity_)
}