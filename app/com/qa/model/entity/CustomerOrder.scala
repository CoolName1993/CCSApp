package com.qa.model.entity

/**
 * Represents a Customer Order from the MySQL database.
 * @param idCustomerOrder_ The customer order ID.
 * @param datePlaced_ The date the customer order was placed.
 * @param dateShipped_ The date the customer order was shipped.
 * @param isPaid_ Whether the order has been paid or not.
 * @param idAddress_ The address ID.
 * @param idCustomerOrderStatus_ The customer order status ID.
 * @param idEmployee_ The employee ID.
 * @param idCustomer_ The customer ID.
 * @author cboucher
 */
class CustomerOrder(idCustomerOrder_ : Any, datePlaced_ : Any, dateShipped_ : Any, isPaid_ : Any, idAddress_ : Any, idCustomerOrderStatus_ : Any, idEmployee_ : Any, idCustomer_ : Any) extends Entity {
  val tableName = "customerorder"
  val idCustomerOrder = new Field("idCustomerOrder", idCustomerOrder_)
  val datePlaced = new Field("datePlaced", datePlaced_)
  val dateShipped = new Field("dateShipped", dateShipped_)
  val isPaid = new Field("isPaid", isPaid_)
  val idAddress = new Field("idAddress", idAddress_)
  val idCustomerOrderStatus = new Field("idCustomerOrderStatus", idCustomerOrderStatus_)
  val idEmployee = new Field("idEmployee", idEmployee_)
  val idCustomer = new Field("idCustomer", idCustomer_)
}