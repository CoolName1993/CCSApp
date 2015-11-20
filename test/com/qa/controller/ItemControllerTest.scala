package com.qa.controller

import com.qa.TestBase
import com.qa.model.entity.Item
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}

/**
  * Created by cboucher on 19/11/2015.
  */
class ItemControllerTest extends TestBase {

  "viewAll" should "return the viewItems page and display all items" in new WithApplication {
    val result = new ItemController().viewAll(FakeRequest())
    status(result) must equal(OK)
    contentType(result) must be(Some("text/html"))
    val itemArray = com.qa.model.entity.QueryLoader.listItems

    def loop(i: Int): Unit = {
      if (i < itemArray.length) {
        contentAsString(result) must include(itemArray(i).itemName.getValue.toString)
        loop(i + 1)
      }
    }

    loop(0)
  }

  "viewItem" should "return the information of an item with the specified item id" in new WithApplication {
    val result = new ItemController().viewItem(1)(FakeRequest())
    status(result) must equal(OK)
    contentType(result) must be(Some("text/html"))
    val item = com.qa.model.entity.QueryLoader.searchItem(new Item(1, null, null, null, null))
    contentAsString(result) must include(item.idItem.getValue.toString)
    contentAsString(result) must include(item.itemName.getValue.toString)
    contentAsString(result) must include(item.imageLocation.getValue.toString)
    contentAsString(result) must include(item.isPorousware.getValue.toString)
    contentAsString(result) must include(item.keyword.toString)
  }

  "viewAllByKeyword" should "return all items with the specified keyword" in new WithApplication() {
    val result = new ItemController().viewAllByKeyword("Gnome")(FakeRequest())
    status(result) must equal(OK)
    contentType(result) must be(Some("text/html"))
    val itemArray = com.qa.model.entity.QueryLoader.searchItemByKeyword("Gnome")
    contentAsString(result) must include(itemArray(0).idItem.getValue.toString)
  }
}
