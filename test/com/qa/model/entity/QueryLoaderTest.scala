package com.qa.model.entity

import com.qa.TestBase

/**
 * @author cboucher
 */
class QueryLoaderTest extends TestBase {
  
  "searchCustomerOrder" should "return the results of a search into an array of customer orders" in {
    val results = QueryLoader.searchCustomerOrder(new CustomerOrder(1,null,null,null,null,null,null,null))
    assert(results.length > 0)
  }
  
  "searchCustomerOrderLine" should "return the results of a search into an array of customer order lines" in {
    val results = QueryLoader.searchCustomerOrderLine(new CustomerOrder(1,null,null,null,null,null,null,null))
    assert(results.length > 0)
  }
  
  
  "searchLocation" should "return the results of a search into an array of locations" in {
    val results = QueryLoader.searchLocation(new Item(1, null, null, null, null))
    assert(results.length > 0)
  }
  
  "searchUser" should "return the results of a search into a user object" in {
    val result = QueryLoader.searchUser(new User(1,"5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8",null,null,null,1))
    assert(result.idUser.getValue.equals(1))
    assert(result.password.getValue.equals("5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8"))
  }
  
  "searchItem" should "return the results of a search into an item object" in {
    val result = QueryLoader.searchItem(new Item(1, null, null, null, null))
    assert(result.idItem.getValue.equals(1))
  }

  "listItems" should "return an array of items when requested" in {
    val result = QueryLoader.listItems
    assert(result.length > 1)
  }

  "searchItemByKeyword" should "return all items with the specified keyword" in {
    val result = QueryLoader.searchItemByKeyword("Gnome")
    assert(result.length > 1)
  }

  "addCustomerOrderToSQL" should "write a new customer order to the database" in {
    QueryLoader.addCustomerOrderToSQL(new CustomerOrder(null, "DATE_FORMAT('2015-11-20','%Y-%m-%d')", null, false, 1, 1, 1, 24))
    val result = QueryLoader.searchCustomerOrder(new CustomerOrder(null, "2015-11-20", null, false, 1, 1, 1, 24))
    assert(result != null)
    assert(result.length > 0)
  }
}