name := """CCSApp"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

// ScalaTest
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

// MongoDB
libraryDependencies += "org.mongodb" % "casbah-core_2.11" % "3.0.0"
libraryDependencies += "org.mongodb" % "casbah-commons_2.11" % "3.0.0"
libraryDependencies += "org.mongodb" % "mongo-java-driver" % "3.1.0"
libraryDependencies += "org.mongodb" % "casbah-query_2.11" % "3.0.0"
libraryDependencies += "org.mongodb" % "casbah-gridfs_2.11" % "3.0.0"
libraryDependencies += "org.mongodb" % "bson" % "3.1.1"
libraryDependencies += "org.mongodb" % "casbah_2.11" % "3.0.0" % "compile"

// SQL
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.37"
// SQUERYL
libraryDependencies += "org.squeryl" % "squeryl_2.11" % "0.9.5-7"

fork in run := true

fork in run := true

fork in run := true

fork in run := true