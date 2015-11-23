package com.qa.controller

import play.api.data.Form
import play.api.mvc._

/**
  * The controller for the login section of the webapp.
  * @author cboucher
  */
class LoginController extends Controller {

  // A form object to bind html fields to a data object from the model.
  val loginForm = Form // TODO Implement this
  // username field
  // password field

  /**
    * Loads the login page
    * @return The login HTML page with the login form attached.
    */
  def view = Action { implicit request =>
    NotImplemented // TODO Implement this
  }

  /**
    * Authenticates the information entered into the form with user data.
    * @return Either the dashboard or an error message.
    */
  def authenticate = Action { implicit request =>
    // val currentUser = loginForm.bindFromRequest()
    NotImplemented // TODO Implement this
  }
}
