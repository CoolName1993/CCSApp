package com.qa.data.entity

/**
 * Represents a Purchase Order Line from the MySQL database.
 * @param idUser_ The user ID.
 * @param password_ The user's password.
 * @param forename_ The  user's forename.
 * @param surname_ The user's surname.
 * @param email_ The user's email.
 * @param isEmployee_ Whether the user is an employee or not.
 * @author cboucher
 */
class User(idUser_ : Int, password_ : String, forename_ : String, surname_ : String, email_ : String, isEmployee_ : Int) extends Entity {
  val tableName = "user"
  val idUser = new Field("idUser", idUser_)
  val password = new Field("password", password_)
  val forename = new Field("forename", forename_)
  val surname = new Field("surname", surname_)
  val email = new Field("email", email_)
  val isEmployee = new Field("isEmployee", isEmployee_)
}