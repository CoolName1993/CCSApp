package com.qa.model.dao

import com.qa.model.entity.{Attributes, Item}
import reactivemongo.bson._

/**
  * Data access object for items in the mongo database.
  * @author cboucher
  */
object ItemDAO {

  implicit object AttributesBSONReader extends BSONDocumentReader[Attributes] {
    def read(document: BSONDocument): Attributes = {
      Attributes(
        Option(document.getAs[BSONString]("Category").get.value),
        Option(document.getAs[BSONString]("Keyword").get.value),
        Option(document.getAs[BSONString]("Color").get.value)
      )
    }
  }

  implicit object ItemBSONReader extends BSONDocumentReader[Item] {
    def read(document: BSONDocument): Item = {
      Item(
        document.getAs[BSONInteger]("idItem").get.value,
        document.getAs[BSONString]("ItemName").get.value,
        document.getAs[BSONString]("ImageLocation").get.value,
        document.getAs[BSONBoolean]("IsPorousware").get.value,
        AttributesBSONReader.read(document.getAs[BSONDocument]("Attributes").get)
      )
    }
  }

}
