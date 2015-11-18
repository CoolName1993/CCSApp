package com.qa.data.entity

/**
 * Represents a Location from the MySQL database.
 * @param idLocation_ The location ID.
 * @param idItem_ The item ID.
 * @param row_ The row of the location.
 * @param col_ The column of the location.
 * @param quantity_ The quantity stored in the location.
 * @author cboucher
 */
class Location(idLocation_ : Any, idItem_ : Any, row_ : Any, col_ : Any, quantity_ : Any) extends Entity {
  val tableName = "location"
  val idLocation = new Field("idLocation", idLocation_)
  val idItem = new Field("idItem", idItem_)
  val row = new Field("row", row_)
  val col = new Field("col", col_)
  val quantity = new Field("quantity", quantity_)
}