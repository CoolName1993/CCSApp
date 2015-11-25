package com.qa.model.entity

import com.qa.TestBase

/**
 * @author cboucher
 */
class AddressTest extends TestBase {
  
  "An Address" should "be initialised with the correct values" in {
    val addressLines = Array("17 Test Road","14 Test Road","12 Test Road")
    val result = new Address(0, addressLines, "Test Town", Option("Test Sussex"), "T35 T12")
    assert(result.idAddress.equals(0))
    assert(result.addressLines(0).equals("17 Test Road"))
    assert(result.addressLines(1).equals("14 Test Road"))
    assert(result.addressLines(2).equals("12 Test Road"))
    assert(result.city.equals("Test Town"))
    assert(result.county.value.equals("Test Sussex"))
    assert(result.postcode.equals("T35 T12"))
  }
}