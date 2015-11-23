package com.qa.controller

import play.api.mvc._

/**
  * The controller for all actions on the webapp related to a customer.
  * @author cboucher
  */
object CustomerController extends Controller {

  /**
    * Shows all customers.
    * @return The HTML page with all customers displayed.
    */
  def viewAll = Action { implicit request =>
    NotImplemented // TODO Implement this
  }

  /**
    * Shows the details of the selected customer.
    * @param customerid The customer id of the selected customer.
    * @return The HTML page showing information on the selected customer or an error page.
    */
  def viewByCustomerID(customerid: Int) = Action { implicit request =>
    NotImplemented // TODO Implement this
  }
}
