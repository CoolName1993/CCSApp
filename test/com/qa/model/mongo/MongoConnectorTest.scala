package com.qa.model.mongo

import com.qa.TestBase

/**
 * @author cboucher
 */
class MongoConnectorTest extends TestBase{
   
  "read" should "return the results of a search when given parameters" in {
    val fields = Array(new Field("idItem",1))
    val result = MongoConnector.read("Item", fields)
    assert(result.length > 0)
  }

  "readAll" should "return all contents from a collection" in {
    val itemResult = MongoConnector.readAll("Item")
    val addressResult = MongoConnector.readAll("Address")
    assert(itemResult.length > 0)
    assert(addressResult.length > 0)
  }
}