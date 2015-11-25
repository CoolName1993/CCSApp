package com.qa.model.entity

import com.qa.TestBase

/**
 * @author cboucher
 */
class CustomerOrderLineTest extends TestBase {
  
  "A CustomerOrderLine" should "be initialised with the correct values" in {
    val result = new CustomerOrderLine(0,1,2)
    assert(result.idItem.equals(0))
    assert(result.idCustomerOrder.equals(1))
    assert(result.quantity.equals(2))
  }
}