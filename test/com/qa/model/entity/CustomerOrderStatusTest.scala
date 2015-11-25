package com.qa.model.entity

import com.qa.TestBase

/**
 * @author cboucher
 */
class CustomerOrderStatusTest extends TestBase {
  
  "A CustomerOrderStatus" should "be initialised with the correct values" in {
    val result = new CustomerOrderStatus(0,"Test")
    assert(result.id.equals(0))
    assert(result.status.equals("Test"))
  }
}