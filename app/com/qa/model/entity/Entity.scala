package com.qa.model.entity

/**
 * Abstract class used to define a single entity in a database. <br/>
 * tableName specifies the name of the table/collection the entity belongs to.
 * 
 * @author cboucher
 */
trait Entity {
  val tableName: String
}