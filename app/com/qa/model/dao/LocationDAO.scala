package com.qa.model.dao

import com.qa.model.entity.Location
import com.qa.model.sql.Database._
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Query

/**
  * Created by cboucher on 24/11/2015.
  */
object LocationDAO {
  /**
    * Finds all locations in the database
    * @return A query for all locations
    */
  def findAll: Query[Location] = from(locationTable) {
    location => select(location)
  }

  /**
    * Finds all locations in the database with the specified item id.
    * @param idItem The item to search for.
    * @return A query for all locations with the specified item id.
    */
  def findByItemID(idItem: Int): Query[Location] = from(locationTable) {
    location => {
      where(location.idItem === idItem).
        select(location)
    }
  }
}
