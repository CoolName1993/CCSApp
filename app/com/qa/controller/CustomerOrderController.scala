package com.qa.controller

import com.qa.model.entity.{CustomerOrder, CustomerOrderHelper, QueryLoader}
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

/**
  * Created by cboucher on 19/11/2015.
  */
class CustomerOrderController extends Controller {

  val customerOrderForm = Form[CustomerOrderHelper](
    mapping(
      "idCustomer" -> number(1, Int.MaxValue, false),
      "idAddress" -> number(1, Int.MaxValue, false),
      "idEmployee" -> number(1, Int.MaxValue, false)
    )(CustomerOrderHelper.apply)(CustomerOrderHelper.unapply)
  )

  def save = Action { implicit request =>
    val newCustomerOrderForm = customerOrderForm.bindFromRequest()
    newCustomerOrderForm.fold(
      hasErrors = { form =>
        Redirect(routes.ItemController.viewItem(1)) /*.
          flashing(Flash(form.data) +
            ("error" -> Messages("validation.errors")))*/
      },
      success = { newCustomerOrder =>
        val result = add(newCustomerOrder)
        Redirect(routes.ItemController.viewAll())
        /*val message = Messages("products.new.success", newCustomerOrder.idCustomer)
        Redirect(routes.CustomerOrderController.show(newCustomerOrder.)).
          flashing("success" -> message)*/
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
  }
}
