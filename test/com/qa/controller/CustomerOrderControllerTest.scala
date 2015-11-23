package com.qa.controller

import com.qa.TestBase
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}

/**
  * Created by cboucher on 23/11/2015.
  */
class CustomerOrderControllerTest extends TestBase {

  "viewAll" should "return a 501 error message" in new WithApplication {
    val result = new CustomerOrderController().viewAll(None, None)(FakeRequest())
    status(result) must equal(NOT_IMPLEMENTED)
  }

  "addOrderView" should "return a 501 error message" in new WithApplication {
    val result = new CustomerOrderController().addOrderView(FakeRequest())
    status(result) must equal(NOT_IMPLEMENTED)
  }

  "addOrder" should "return a 501 error message" in new WithApplication {
    val result = new CustomerOrderController().addOrder(FakeRequest())
    status(result) must equal(NOT_IMPLEMENTED)
  }

  "viewOrderByID" should "return a 501 error message" in new WithApplication {
    val result = new CustomerOrderController().viewByOrderID(1)(FakeRequest())
    status(result) must equal(NOT_IMPLEMENTED)
  }

  "editByOrderID" should "return a 501 error message" in new WithApplication {
    val result = new CustomerOrderController().editByOrderID(1)(FakeRequest())
    status(result) must equal(NOT_IMPLEMENTED)
  }

  "updateOrder" should "return a 501 error message" in new WithApplication {
    val result = new CustomerOrderController().updateOrder(1)(FakeRequest())
    status(result) must equal(NOT_IMPLEMENTED)
  }
}
