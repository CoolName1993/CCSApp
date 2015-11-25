package com.qa.model.entity

import com.qa.TestBase

/**
 * @author cboucher
 */
class LocationTest extends TestBase {
  
  "A Location" should "be initialised with the correct values" in {
    val result = new Location(0,1,2,3,4)
    assert(result.id.equals(0))
    assert(result.idItem.equals(1))
    assert(result.row.equals(2))
    assert(result.col.equals(3))
    assert(result.quantity.equals(4))
  }
}