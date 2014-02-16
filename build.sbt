name := "type-prog"

organization := "com.joescii"

version := "1.0-SNAPSHOT"

scalaVersion := "2.9.1"

crossScalaVersions := Seq("2.9.1", "2.9.1-1", "2.9.2", "2.9.3", "2.10.3")

resolvers ++= Seq(
  "sonatype-snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "sonatype-releases"  at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= {
  Seq(
//    "org.scalatest"  %% "scalatest"   % "1.9.1"  % "test",
//    "org.scalacheck" %% "scalacheck"  % "1.10.1" % "test"
  )
}

scalacOptions <<= scalaVersion map { v: String =>
  val opts = "-deprecation" :: "-unchecked" :: Nil
  if (v.startsWith("2.9.")) opts 
  else opts ++ ("-feature" :: "-language:postfixOps" :: "-language:implicitConversions" :: Nil)
}

