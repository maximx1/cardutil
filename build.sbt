name := """cardutil"""

version := "1.0.0"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "2.2.4" % "test",
    "org.mockito" % "mockito-all" % "1.9.5"
)

assemblyJarName in assembly := s"${name.value}-${version.value}.jar"