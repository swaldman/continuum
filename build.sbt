organization := "com.mchange"

name := "danburkert-continuum"

version := "0.3.99" // chose this version so we can follow dan burkert into 0.4.x if he updates the project

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.4")

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.4" % "provided"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"


val nexus = "https://oss.sonatype.org/"
val nexusSnapshots = nexus + "content/repositories/snapshots";
val nexusReleases = nexus + "service/local/staging/deploy/maven2";

resolvers += ("releases" at nexusReleases)

resolvers += ("snapshots" at nexusSnapshots)

publishTo <<= version {
  (v: String) => {
    if (v.trim.endsWith("SNAPSHOT"))
      Some("snapshots" at nexusSnapshots )
    else
      Some("releases"  at nexusReleases )
  }
}

pomExtra <<= name {
  (projectName : String ) => (
    <url>https://github.com/danburkert/continuum</url>
    <licenses>
      <license>
        <name>Apache License, Version 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:danburkert/continuum.git</url>
      <connection>scm:git:git@github.com:danburkert/continuum.git</connection>
    </scm>
    <developers>
      <developer>
        <id>danburkert</id>
        <name>Dan Burkert</name>
        <email>dan@danburkert.com</email>
      </developer>
    </developers>
  )
}
