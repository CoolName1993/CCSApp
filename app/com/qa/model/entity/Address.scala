package com.qa.model.entity

/**
 * Represents an Address from the MongoDB database.
  * @param idAddress The address ID.
  * @param addressLines An array of lines in the address.
  * @param city The city in the address.
  * @param county The county in the address.
  * @param postcode The postcode in the address.
 * @author cboucher
 */
case class Address(idAddress: Int,
                   addressLines: Array[String],
                   city: String,
                   county: Option[String],
                   postcode: String)