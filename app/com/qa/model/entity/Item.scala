package com.qa.model.entity

/**
  * Represents the attribute object inside the item object.
  * @param category (Optional) The category the item is in.
  * @param keyword (Optional) The related keyword.
  * @param color (Optional) The colour of the item.
  * @author cboucher
  */
case class Attributes(category: Option[String],
                      keyword: Option[String],
                      color: Option[String])

/**
  * Represents an Item from the MongoDB database.
  * @param idItem The item ID.
  * @param itemName The name of the item.
  * @param imageLocation The location of the item's image.
  * @param isPorousware Whether the item has porousware.
  * @param attributes The attributes of the item.
  * @author cboucher
  */
case class Item(idItem: Any,
                itemName: String,
                imageLocation: String,
                isPorousware: Boolean,
                attributes: Attributes)