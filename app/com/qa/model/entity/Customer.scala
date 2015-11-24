package com.qa.model.entity

import java.util.Date

import com.qa.model.sql.Database
import org.squeryl.KeyedEntity
import org.squeryl.dsl.OneToMany

/**
  * Created by cboucher on 24/11/2015.
  */
case class Customer(id: Int,
                    dateOfBirth: Date,
                    credit: Float,
                    phoneNumber: String,
                    blackStrikes: Int) extends KeyedEntity[Int] {

  lazy val customerOrders: OneToMany[CustomerOrder] =
    Database.customerToCustomerOrder.left(this)
}
