package com.qa.model.dao

import com.qa.model.entity.Address
import reactivemongo.bson._

/**
  * Created by cboucher on 24/11/2015.
  */
object AddressDAO {

  implicit object AddressBSONReader extends BSONReader[Address] {
    def read(document: BSONDocument): Address = {
      Address(
        document.getAs[BSONInteger]("idAddress").get.value,
        document.getAs[BSONArray]("AddressLines").get.values.toArray[String],
        document.getAs[BSONString]("City").get.value,
        Option(document.getAs[BSONString]("County").get.value),
        document.getAs[BSONString]("PostCode").get.value
      )
    }
  }

}
