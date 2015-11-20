package com.qa.model.sql

import com.qa.TestBase
import com.qa.model.entity.Field

/**
 * @author cboucher
 */
class SQLConnectorTest extends TestBase {

  "read" should "search the database for matching entities" in {
    val columns = Array(new Field("idItem", null), new Field("idCustomerOrder", 1), new Field("quantity", null))
    val results = SQLConnector.read("customerorderline", columns)
    assert(results.length > 0)
  }
}