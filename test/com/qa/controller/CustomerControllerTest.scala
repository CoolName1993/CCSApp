package com.qa.controller

import com.qa.TestBase
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}

/**
  * Created by cboucher on 23/11/2015.
  */
class CustomerControllerTest extends TestBase {

  "viewAll" should "return a 501 error message" in new WithApplication {
    val result = new CustomerController().viewAll(FakeRequest())
    status(result) must equal(NOT_IMPLEMENTED)
  }

  "viewByCustomerID" should "return a 501 error message" in new WithApplication {
    val result = new CustomerController().viewByCustomerID(1)(FakeRequest())
    status(result) must equal(NOT_IMPLEMENTED)
  }
}
