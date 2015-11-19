package com.qa.controller

import com.qa.data.entity.{Item, QueryLoader}
import play.api.mvc._

/**
  * @author cboucher
  */
class ItemController extends Controller {

  def viewAll = Action { implicit request =>
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
  }
}
