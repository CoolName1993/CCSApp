package com.qa.model.sql

import com.qa.model.entity._
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Schema

/**
  * Created by cboucher on 24/11/2015.
  */

object Database extends Schema {
  val customerTable = table[Customer]("customer")
  val customerOrderTable = table[CustomerOrder]("customerorder")
  val customerOrderLineTable = table[CustomerOrderLine]("customerorderline")
  val customerOrderStatusTable = table[CustomerOrderStatus]("customerorderstatus")
  val locationTable = table[Location]("location")
  val userTable = table[User]("user")

  on(customerTable)(c => declare(
    c.id is autoIncremented
  ))

  on(customerOrderTable)(c => declare(
    c.id is autoIncremented
  ))

  on(customerOrderLineTable)(c => declare(
    c.id is autoIncremented
  ))

  on(customerOrderStatusTable)(c => declare(
    c.id is autoIncremented
  ))

  on(locationTable)(l => declare(
    l.id is autoIncremented
  ))

  on(userTable)(u => declare(
  ))
}