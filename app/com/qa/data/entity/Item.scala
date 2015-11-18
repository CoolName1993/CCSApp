package com.qa.data.entity


/**
 * Represents an Item from the MongoDB database.
 * @param idItem_ The item ID.
 * @param itemName_ The name of the item.
 * @param imageLocation_ The location of the item's image.
 * @param isPorousware_ Whether the item has porousware.
 * @author cboucher
 */
class Item(idItem_ : Any, itemName_ : String, imageLocation_ : String, isPorousware_ : Any, keyword_ : String) extends Entity {
  val tableName: String = "Item"
  val idItem = new Field("idItem", idItem_)
  val itemName = new Field("ItemName", itemName_)
  val imageLocation = new Field("ImageLocation", imageLocation_)
  val isPorousware = new Field("IsPorousware", isPorousware_)
  val keyword = keyword_
}