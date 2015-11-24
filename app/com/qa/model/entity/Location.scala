package com.qa.model.entity

import org.squeryl.KeyedEntity

/**
 * Represents a Location from the MySQL database.
  * @param id The location ID.
  * @param idItem The item ID.
  * @param row The row of the location.
  * @param col The column of the location.
  * @param quantity The quantity stored in the location.
 * @author cboucher
 */
case class Location(id: Int, idItem: Int,
                    row: Int,
                    col: Int,
                    quantity: Int) extends KeyedEntity[Int]