name := "modern-web-template"

val conf = com.typesafe.config.ConfigFactory.parseFile(new File("conf/application.conf")).resolve()

version := conf.getString("application.version")

scalaVersion := "2.11.6"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

pipelineStages in Assets := Seq()

pipelineStages := Seq(uglify, digest, gzip)

DigestKeys.algorithms += "sha1"

UglifyKeys.uglifyOps := { js =>
  Seq((js.sortBy(_._2), "concat.min.js"))
}

MochaKeys.requires ++= Seq("lib/phantomjs/lib/phantomjs.js", "lib/angularjs/angular-mocks.js", "lib/angularjs/angular.js")


resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Webjars Bintray" at "https://dl.bintray.com/webjars/maven/"

libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "4.0",
  "javax.inject" % "javax.inject" % "1",
  "org.reactivemongo" %% "play2-reactivemongo" % "0.10.5.0.akka23",
  "org.webjars" % "bootstrap" % "3.3.4",
  "org.webjars" % "angularjs" % "1.3.15",
  "org.webjars" % "angular-ui-bootstrap" % "0.13.0",
  "org.webjars.npm" % "phantomjs" % "1.9.17",
  "org.mockito" % "mockito-core" % "1.10.19" % "test")
