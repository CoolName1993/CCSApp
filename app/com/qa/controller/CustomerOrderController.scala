package com.qa.controller

import com.qa.model.dao.CustomerOrderDAO
import com.qa.model.entity.CustomerOrder
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

/**
  * The controller for all actions on the webapp related to a customer order.
  * Created by cboucher on 19/11/2015.
  */
class CustomerOrderController extends Controller {

  // A form object to bind html fields to a data object from the model.
  val customerOrderForm = Form[CustomerOrder](
    mapping(
      "idCustomer" -> number(1, Int.MaxValue, false),
      "idAddress" -> number(1, Int.MaxValue, false),
      "idEmployee" -> number(1, Int.MaxValue, false)
    )((idCustomer, idAddress, idEmployee) => CustomerOrder(0, null, null, false, idAddress, 1, idEmployee, idCustomer))
    ((customerOrder: CustomerOrder) => Some((customerOrder.idCustomer, customerOrder.idAddress, customerOrder.idEmployee)))
  ) // DONE Update this when model is changed

  // A form object to bind html fields to a data object from the model.
  val customerOrderLineForm = Form // TODO Implement this
  // order id field
  // item id field
  // quantity field

  /**
    * View all orders. (Can filter by customer id, employee id)
    * @param idCustomer (Optional) The customer id of the order
    * @param idEmployee (Optional) The employee id of the order
    * @return A HTML page showing all orders that match the filter criteria (if applicable)
    */
  def viewAll(idCustomer: Option[Int], idEmployee: Option[Int]) = Action { implicit request =>
    NotImplemented // TODO Implement this
  }

  /**
    * Allows the user to add a new customer order.
    * @return The HTML page with the customer order form.
    */
  def addOrderView = Action { implicit request =>
    Ok(com.qa.view.logic.html.addCustomerOrder(customerOrderForm))
    NotImplemented // TODO Implement this
  }

  /**
    * Creates a new customer order using the data from the HTML form.
    * @return The HTML page for the newly created customer order or an error message.
    */
  def addOrder = Action { implicit request =>
    // val currentCustomerOrder = customerOrderForm.bindFromRequest
    //NotImplemented DONE Implement this
    val newCustomerOrderForm = customerOrderForm.bindFromRequest
    newCustomerOrderForm.fold(
      hasErrors = { form =>
        Redirect(routes.ItemController.viewByItemID(1)) /*.flashing(Flash(form.data) + ("error" -> Messages("validation.errors")))*/
      },
      success = { newCustomerOrder =>
        val result = CustomerOrderDAO.insert(newCustomerOrder)
        Redirect(routes.ItemController.viewAll(None, None, None, None))
        /*val message = Messages("products.new.success", newCustomerOrder.idCustomer)
        Redirect(routes.CustomerOrderController.viewByOrderID(result.id)).flashing("success" -> message)*/
      }
    )
  }

  /**
    * Searches for the order with the selected order id
    * @param idOrder The order id to search for.
    * @return The HTML page for the customer order or an error page
    */
  def viewByOrderID(idOrder: Int) = Action { implicit request =>
    NotImplemented // TODO Implement this
  }

  /**
    * Allows the user to edit a customer order
    * @param idOrder The order id of the selected order.
    * @return The HTML page of the order with editable fields or an error page.
    */
  def editByOrderID(idOrder: Int) = Action { implicit request =>
    NotImplemented // TODO Implement this
  }

  /**
    * Adds an order line to the order using data from the HTML form.
    * @param idOrder The order id of the selected order.
    * @return The HTML page of the order showing the new order line or an error page.
    */
  def updateOrder(idOrder: Int) = Action { implicit request =>
    // val currentOrderLine = customerOrderLineForm.bindFromRequest
    NotImplemented // TODO Implement this
  }

  // ~~~VVV THE ARCHIVES VVV~~~

  // Useful to look at until new features are implemented
  /*def save = Action { implicit request =>
    val newCustomerOrderForm = customerOrderForm.bindFromRequest()
    newCustomerOrderForm.fold(
      hasErrors = { form =>
        Redirect(routes.ItemController.viewItem(1)) .
          flashing(Flash(form.data) +
            ("error" -> Messages("validation.errors")))
      },
      success = { newCustomerOrder =>
        val result = add(newCustomerOrder)
        Redirect(routes.ItemController.viewAll())
        val message = Messages("products.new.success", newCustomerOrder.idCustomer)
        Redirect(routes.CustomerOrderController.show(newCustomerOrder.)).
          flashing("success" -> message)
      }
    )
  }

  def add(customerOrderHelper: CustomerOrderHelper): CustomerOrder = {
    val currentDate = java.time.LocalDate.now()
    val year = currentDate.getYear
    val month = currentDate.getMonthValue
    val day = currentDate.getDayOfMonth
    val datePlaced = year + "-" + month + "-" + day
    QueryLoader.addCustomerOrderToSQL(new CustomerOrder(null, "DATE_FORMAT('" + datePlaced + "','%Y-%m-%d')", null, false, customerOrderHelper.idAddress, 1, customerOrderHelper.idEmployee, customerOrderHelper.idCustomer))
    val results = QueryLoader.searchCustomerOrder(new CustomerOrder(null, datePlaced, null, false, customerOrderHelper.idAddress, 1, customerOrderHelper.idEmployee, customerOrderHelper.idCustomer))
    results.last
  }

  def addPage = Action { implicit request =>
    Ok(com.qa.view.logic.html.addCustomerOrder(customerOrderForm))
  }*/
}
