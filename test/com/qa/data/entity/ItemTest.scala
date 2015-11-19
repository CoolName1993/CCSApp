package com.qa.data.entity

import com.mongodb.BasicDBObject
import com.qa.TestBase

/**
 * @author cboucher
 */
class ItemTest extends TestBase {
   
  "An Item" should "be initialised with the correct values" in {
    val attributes = new BasicDBObject
    val result = new Item(0, "Test", "/test", false, "Gnome")
    assert(result.idItem.getValue.equals(0))
    assert(result.itemName.getValue.equals("Test"))
    assert(result.imageLocation.getValue.equals("/test"))
    assert(result.isPorousware.getValue.equals(false))
    assert(result.keyword.equals("Gnome"))
  }
}