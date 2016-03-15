lazy val root = (project in file(".")).settings(
  name := "demitasse",
  version := "0.1.0",
  libraryDependencies ++= List(
    "org.scala-lang.modules" %% "scala-java8-compat" % "0.7.0",
    "org.apache.poi" % "poi" % "3.14",
    "org.apache.poi" % "poi-ooxml" % "3.14",
    //"dom4j" % "dom4j" % "1.6.1",
    "org.scalafx" %% "scalafx" % "8.0.60-R9",
    "org.scalafx" %% "scalafxml-core-sfx8" % "0.2.2"
  ),
  scalacOptions ++= List("-Ybackend:GenBCode", "-Ydelambdafy:method", "-target:jvm-1.8"),
  scalaVersion := "2.11.8"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
