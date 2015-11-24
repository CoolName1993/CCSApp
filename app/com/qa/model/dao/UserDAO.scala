package com.qa.model.dao

import com.qa.model.entity.User
import com.qa.model.sql.Database._
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Query

/**
  * Created by cboucher on 24/11/2015.
  */
object UserDAO {

  /**
    * Finds all locations in the database
    * @return A query for all locations
    */
  def findAll: Query[User] = from(userTable) {
    user => select(user)
  }

  /**
    * Finds all locations in the database with the specified item id.
    * @param id The user id to search for.
    * @param password The password to search for.
    * @return A query for a user with matching id and password who is also an employee.
    */
  def findByIDAndPassword(id: Int, password: String): Query[User] = from(userTable) {
    user => {
      where(user.id === id and user.password === password and user.isEmployee === 1).
        select(user)
    }
  }
}
