package com.qa.model.entity

import java.time.LocalDate

import com.qa.model.sql.Database
import org.squeryl.KeyedEntity
import org.squeryl.dsl.{ManyToOne, OneToMany}

/**
 * Represents a Customer Order from the MySQL database.
  * @param id The customer order ID.
  * @param datePlaced The date the customer order was placed.
  * @param dateShipped The date the customer order was shipped.
  * @param isPaid Whether the order has been paid or not.
  * @param idAddress The address ID.
  * @param idCustomerOrderStatus The customer order status ID.
  * @param idEmployee The employee ID.
  * @param idCustomer The customer ID.
 * @author cboucher
 */
case class CustomerOrder(id: Int,
                         datePlaced: LocalDate,
                         dateShipped: LocalDate,
                         isPaid: Boolean,
                         idAddress: Int,
                         idCustomerOrderStatus: Int,
                         idEmployee: Int,
                         idCustomer: Int) extends KeyedEntity[Int] {

  lazy val customerOrderLines: OneToMany[CustomerOrderLine] =
    Database.customerOrderToCustomerOrderLine.left(this)

  lazy val customer: ManyToOne[Customer] =
    Database.customerToCustomerOrder.right(this)
}