name := """Veterinaria"""
organization := "com.example"


version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.13.11"

libraryDependencies += guice
libraryDependencies += "javax.persistence" % "javax.persistence-api" % "2.2"
libraryDependencies += javaJdbc


