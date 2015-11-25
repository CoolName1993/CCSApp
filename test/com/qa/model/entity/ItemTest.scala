package com.qa.model.entity

import com.qa.TestBase

/**
 * @author cboucher
 */
class ItemTest extends TestBase {
   
  "An Item" should "be initialised with the correct values" in {
    val result = new Item(0, "Test", "/test", false, new Attributes(Option("Gnome"), Option("Scary"), Option("Blue")))
    assert(result.idItem.equals(0))
    assert(result.itemName.equals("Test"))
    assert(result.imageLocation.equals("/test"))
    assert(result.isPorousware.equals(false))
    assert(result.attributes.category.value.equals("Gnome"))
    assert(result.attributes.keyword.value.equals("Scary"))
    assert(result.attributes.color.value.equals("Blue"))
  }
}