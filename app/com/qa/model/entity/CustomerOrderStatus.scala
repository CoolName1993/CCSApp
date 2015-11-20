package com.qa.model.entity

/**
 * Represents a Customer Order Status from the MySQL database.
 * @param idCustomerOrderStatus_ The customer order status ID.
 * @param status_ The string representation of the status.
 * @author cboucher
 */
class CustomerOrderStatus(idCustomerOrderStatus_ : Any, status_ : String) extends Entity {
  val tableName = "customerorderstatus"
  val idCustomerOrderStatus = new Field("idCustomerOrderStatus", idCustomerOrderStatus_)
  val status = new Field("status", status_)
}