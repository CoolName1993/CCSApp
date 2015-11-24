package com.qa.model.entity

import org.squeryl.KeyedEntity

/**
 * Represents a Purchase Order Line from the MySQL database.
  * @param id The user ID.
  * @param password The user's password.
  * @param forename The  user's forename.
  * @param surname The user's surname.
  * @param email The user's email.
  * @param isEmployee Whether the user is an employee or not.
 * @author cboucher
 */
case class User(id: Int,
                password: String,
                forename: String,
                surname: String,
                email: String,
                isEmployee: Int) extends KeyedEntity[Int]