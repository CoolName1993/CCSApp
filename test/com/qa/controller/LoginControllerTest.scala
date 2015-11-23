package com.qa.controller

import com.qa.TestBase
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}

/**
  * Created by cboucher on 23/11/2015.
  */
class LoginControllerTest extends TestBase {

  "view" should "return a 501 error message" in new WithApplication {
    val result = new LoginController().view(FakeRequest())
    status(result) must equal(NOT_IMPLEMENTED)
  }

  "authenticate" should "return a 501 error message" in new WithApplication {
    val result = new LoginController().authenticate(FakeRequest())
    status(result) must equal(NOT_IMPLEMENTED)
  }
}
