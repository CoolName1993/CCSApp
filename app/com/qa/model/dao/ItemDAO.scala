package com.qa.model.dao

import com.qa.model.entity.Item
import play.api.Play.current
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.api.collections.bson.BSONCollection
import reactivemongo.bson._

import scala.collection.mutable.ListBuffer
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

/**
  * Data access object for items in the mongo database.
  * @author cboucher
  */
object ItemDAO extends MongoController with ReactiveMongoComponents {

  lazy val reactiveMongoApi = current.injector.instanceOf[ReactiveMongoApi]

  /*implicit object AttributesBSONReader extends BSONDocumentReader[Attributes] {
    def read(document: BSONDocument): Attributes = {
      Attributes(
        Option(document.getAsTry[BSONString]("Category").get.value),
        Option(document.getAsTry[BSONString]("Keyword").get.value),
        Option(document.getAsTry[BSONString]("Color").get.value)
      )
    }
  }*/

  def viewAll: Array[Item] = {
    val results = db[BSONCollection]("Item").find(BSONDocument()).cursor[BSONDocument].collect[List]()
    val resultAsync = Await.result(results, 60.seconds)
    val itemList = new ListBuffer[Item]
    for (item <- resultAsync) {
      itemList += ItemBSONReader.read(item)
    }
    itemList.toArray
  }

  def findByID(id: Int): Item = {
    val query = BSONDocument(
      "idItem" -> id)
    val result = db[BSONCollection]("Item").find(query).one[Item]
    val resultAsync = Await.result(result, 60.seconds)
    resultAsync.get
  }

  implicit object ItemBSONReader extends BSONDocumentReader[Item] {
    def read(document: BSONDocument): Item = {
      Item(
        document.getAsTry[BSONInteger]("idItem").get.value,
        document.getAsTry[BSONString]("ItemName").get.value,
        document.getAsTry[BSONString]("ImageLocation").get.value,
        document.getAsTry[BSONBoolean]("IsPorousware").get.value
        /*AttributesBSONReader.read(document.getAsTry[BSONDocument]("Attributes").get)*/
      )
    }
  }
}
