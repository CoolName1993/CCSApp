package com.qa.model.entity

import java.time.LocalDate

import com.qa.TestBase

/**
 * @author cboucher
 */
class CustomerOrderTest extends TestBase {

  "A CustomerOrder" should "be initialised with the correct values" in {
    val result = new CustomerOrder(0, LocalDate.of(2010, 10, 9), LocalDate.of(2010, 10, 9), true, 0, 0, 0, 0)
    assert(result.id.equals(0))
    assert(result.datePlaced.equals(LocalDate.of(2010, 10, 9)))
    assert(result.dateShipped.equals(LocalDate.of(2010, 10, 9)))
    assert(result.isPaid.equals(true))
    assert(result.idAddress.equals(0))
    assert(result.idCustomerOrderStatus.equals(0))
    assert(result.idEmployee.equals(0))
    assert(result.idCustomer.equals(0))
  }
}