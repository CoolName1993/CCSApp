package com.qa.controller

import com.qa.TestBase
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}

/**
  * Created by cboucher on 23/11/2015.
  */
class ApplicationTest extends TestBase {

  "index" should "return a 501 error message" in new WithApplication {
    val result = new Application().index(FakeRequest())
    status(result) must equal(NOT_IMPLEMENTED)
  }

}
