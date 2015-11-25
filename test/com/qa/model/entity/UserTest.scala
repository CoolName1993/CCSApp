package com.qa.model.entity

import com.qa.TestBase

/**
 * @author cboucher
 */
class UserTest extends TestBase {

  "A user" should "be initialised with the correct values" in {
    val result = new User(0,"Test","Test1","Test2","Testmail",0)
    assert(result.id.equals(0))
    assert(result.password.equals("Test"))
    assert(result.forename.equals("Test1"))
    assert(result.surname.equals("Test2"))
    assert(result.email.equals("Testmail"))
    assert(result.isEmployee.equals(0))
  }
}