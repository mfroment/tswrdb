name := "tswrdb"

ThisBuild / version  := "0.0.1"

ThisBuild / scalaVersion := "2.10.3"

ThisBuild / scalacOptions ++= Seq("-deprecation", "-feature", "-encoding", "utf8")

val api: Project = (project in file("tswrdb-api"))

val cmdui: Project = (project in file("tswrdb-cmdui"))
  .dependsOn(api)

val tswrdb: Project = (project in file("."))
  .aggregate(api, cmdui)
