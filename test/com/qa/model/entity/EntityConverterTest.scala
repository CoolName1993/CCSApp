package com.qa.model.entity

import java.sql.Date

import com.mongodb.casbah.Imports._
import com.qa.TestBase

/**
 * @author cboucher
 */
class EntityConverterTest extends TestBase {

  "convertToUser" should "convert raw model into a user object" in {
    val result = EntityConverter.convertToUser(Array(0, "Test", "Test1", "Test2", "Testmail", 0))
    assert(result.idUser.getValue.equals(0))
    assert(result.password.getValue.equals("Test"))
    assert(result.forename.getValue.equals("Test1"))
    assert(result.surname.getValue.equals("Test2"))
    assert(result.email.getValue.equals("Testmail"))
    assert(result.isEmployee.getValue.equals(0))
  }

  "convertToAddress" should "convert raw model into an address object" in {
  val addressLines = Array("17 Test Road","14 Test Road","12 Test Road")
    val result = EntityConverter.convertToAddress(Array(0, addressLines, "Test Town", "Test Sussex", "T35 T12"))
    assert(result.idAddress.getValue.equals(0))
    assert(result.addressLines(0).getValue.equals("17 Test Road"))
    assert(result.addressLines(1).getValue.equals("14 Test Road"))
    assert(result.addressLines(2).getValue.equals("12 Test Road"))
    assert(result.city.getValue.equals("Test Town"))
    assert(result.county.getValue.equals("Test Sussex"))
    assert(result.postcode.getValue.equals("T35 T12"))
  }

  "convertToCustomerOrder" should "convert raw model into a customer order object" in {
    val result = EntityConverter.convertToCustomerOrder(Array(0, new Date(10, 10, 2010), new Date(10, 10, 2010), true, 0, 0, 0, 0))
    assert(result.idCustomerOrder.getValue.equals(0))
    assert(result.datePlaced.getValue.equals(new Date(10, 10, 2010)))
    assert(result.dateShipped.getValue.equals(new Date(10, 10, 2010)))
    assert(result.isPaid.getValue.equals(true))
    assert(result.idAddress.getValue.equals(0))
    assert(result.idCustomerOrderStatus.getValue.equals(0))
    assert(result.idEmployee.getValue.equals(0))
    assert(result.idCustomer.getValue.equals(0))
  }

  "convertToCustomerOrderLine" should "convert raw model into a customer order line object" in {
    val result = EntityConverter.convertToCustomerOrderLine(Array(0, 1, 2))
    assert(result.idItem.getValue.equals(0))
    assert(result.idCustomerOrder.getValue.equals(1))
    assert(result.quantity.getValue.equals(2))
  }

  "convertToLocation" should "convert raw model into a location object" in {
    val result = EntityConverter.convertToLocation(Array(0, 1, 2, 3, 4))
    assert(result.idLocation.getValue.equals(0))
    assert(result.idItem.getValue.equals(1))
    assert(result.row.getValue.equals(2))
    assert(result.col.getValue.equals(3))
    assert(result.quantity.getValue.equals(4))
  }

  "convertToItem" should "convert raw model into an item object" in {
    val item = MongoDBObject.empty
    val attributes = new BasicDBObject
    attributes.put("Keyword", "Gnome")
    item.put("idItem", 0)
    item.put("ItemName", "Test")
    item.put("ImageLocation", "/test")
    item.put("IsPorousware", false)
    item.put("Attributes", attributes)
    val result = EntityConverter.convertToItem(item)
    assert(result.idItem.getValue.equals(0))
    assert(result.itemName.getValue.equals("Test"))
    assert(result.imageLocation.getValue.equals("/test"))
    assert(result.isPorousware.getValue.equals(false))
    assert(result.keyword.equals("Gnome"))
  }
}