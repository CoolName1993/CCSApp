package com.qa.controller

import play.api.mvc._

/**
  * The controller for all actions on the webapp related to a customer order.
  * @author cboucher
  */
object ItemController extends Controller {

  /**
    * View all items (Can filter by item id, name, keyword, category).
    * @param itemid (Optional) The id to filter by.
    * @param name (Optional) The name to filter by.
    * @param keyword (Optional) The keyword to filter by.
    * @param category (Optional) The category to filter by.
    * @return The HTML page showing all items that match the criteria (if applicable).
    */
  def viewAll(itemid: Option[Int], name: Option[String], keyword: Option[String], category: Option[String]) = Action { implicit request =>
    NotImplemented // TODO Implement this
  }

  /**
    * View the selected item.
    * @param itemid The item id of the selected item
    * @return The HTML page of the selected item or an error page.
    */
  def viewByItemID(itemid: Int) = Action { implicit request =>
    NotImplemented // TODO Implement this
  }

  /**
    * Adds the selected item to the current order.
    * @param itemid The item id of the selected item.
    * @return The HTML page of related items filtered by keyword or an error message.
    */
  def addToOrder(itemid: Int) = Action { implicit request =>
    NotImplemented // TODO Implement this
  }

  // ~~~VVV THE ARCHIVES VVV~~~

  // Refer to this while creating new functions.

  /*def viewAll = Action { implicit request =>
    val items = QueryLoader.listItems
    Ok(com.qa.view.logic.html.viewItems(items))
  }

  def viewItem(id: Int) = Action { implicit request =>
    val item = QueryLoader.searchItem(new Item(id, null, null, null, null))
    Ok(com.qa.view.logic.html.viewItem(item))
  }

  def viewAllByKeyword(key: String) = Action { implicit request =>
    val items = QueryLoader.searchItemByKeyword(key)
    Ok(com.qa.view.logic.html.viewItems(items))
  }*/
}
