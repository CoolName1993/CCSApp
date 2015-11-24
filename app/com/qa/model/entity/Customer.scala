package com.qa.model.entity

import java.util.Date

import org.squeryl.KeyedEntity

/**
  * Created by cboucher on 24/11/2015.
  */
case class Customer(id: Int,
                    dateOfBirth: Date,
                    credit: Float,
                    phoneNumber: String,
                    blackStrikes: Int) extends KeyedEntity[Int]
