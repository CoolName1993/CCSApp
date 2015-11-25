import org.squeryl.adapters.MySQLAdapter
import org.squeryl.internals.DatabaseAdapter
import org.squeryl.{Session, SessionFactory}
import play.api.db.DB
import play.api.{Application, GlobalSettings}

/**
  * Called at application start to configure Squeryl
  * @author cboucher
  */
object Global extends GlobalSettings {
  override def onStart(app: Application): Unit = {
    implicit val implicitApp = app
    SessionFactory.concreteFactory = Some(() =>
      Session.create(DB.getConnection(), new MySQLAdapter))
  }

  override def onStop(app: Application): Unit = {
  }

  def getSession(adapter: DatabaseAdapter, app: Application) = Session.create(DB.getConnection()(app), adapter)
}
