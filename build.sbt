name := """Veterinaria"""
organization := "com.example"


version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.13.11"

libraryDependencies += guice
libraryDependencies += "org.webjars" % "bootstrap" % "5.0.0"
libraryDependencies += "org.webjars" % "jquery" % "3.6.0"

libraryDependencies += "javax.persistence" % "javax.persistence-api" % "2.2"
libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.42.0.0"
libraryDependencies += javaJdbc



