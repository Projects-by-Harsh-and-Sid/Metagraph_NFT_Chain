# build.sbt
```scala
import Dependencies._

ThisBuild / organization := "com.my.nft"
ThisBuild / scalaVersion := "2.13.10"
ThisBuild / evictionErrorLevel := Level.Warn

resolvers += Resolver.githubPackages("abankowski", "http-request-signer")

// Runtime configuration
Runtime / javaOptions ++= Seq(
  "-XX:+UseG1GC",
  "-XX:MaxGCPauseMillis=100",
  "-XX:+UseStringDeduplication",
  "-Dconfig.override_with_env_vars=true"
)

val sharedSettings = Seq(
  scalacOptions ++= Seq("-Xsource:3"),
  assembly / assemblyMergeStrategy := {
    case "logback.xml" => MergeStrategy.first
    case x if x.contains("io.netty.versions.properties") => MergeStrategy.discard
    case PathList("scala", xs @ _*) => MergeStrategy.first
    case x =>
      val oldStrategy = (assembly / assemblyMergeStrategy).value
      oldStrategy(x)
  },
  // Set current version here
  version := "0.1.0-SNAPSHOT"
)

lazy val root = (project in file("."))
  .aggregate(shared, l0, l1, dataL1)
  .settings(
    name := "nft-metagraph"
  )

lazy val runner = (project in file("modules/runner"))
  .settings(sharedSettings)
  .settings(
    name := "runner",
    libraryDependencies ++= Seq(
      CompilerPlugin.kindProjector,
      CompilerPlugin.betterMonadicFor,
      CompilerPlugin.semanticDB,
      Libraries.tessellationNodeShared,
      Libraries.requests
    )
  )
  .dependsOn(l0, l1, dataL1)

lazy val shared = (project in file("modules/shared"))
  .settings(sharedSettings)
  .settings(
    name := "shared",
    libraryDependencies ++= Seq(
      CompilerPlugin.kindProjector,
      CompilerPlugin.betterMonadicFor,
      CompilerPlugin.semanticDB,
      Libraries.tessellationNodeShared
    )
  )

lazy val l0 = (project in file("modules/l0"))
  .settings(sharedSettings)
  .settings(
    name := "l0",
    libraryDependencies ++= Seq(
      CompilerPlugin.kindProjector,
      CompilerPlugin.betterMonadicFor,
      CompilerPlugin.semanticDB,
      Libraries.tessellationCurrencyL0,
      Libraries.requests
    )
  )
  .dependsOn(shared)

lazy val l1 = (project in file("modules/l1"))
  .settings(sharedSettings)
  .settings(
    name := "l1",
    libraryDependencies ++= Seq(
      CompilerPlugin.kindProjector,
      CompilerPlugin.betterMonadicFor,
      CompilerPlugin.semanticDB,
      Libraries.tessellationCurrencyL1
    )
  )
  .dependsOn(shared)

lazy val dataL1 = (project in file("modules/data_l1"))
  .settings(sharedSettings)
  .settings(
    name := "data_l1",
    libraryDependencies ++= Seq(
      CompilerPlugin.kindProjector,
      CompilerPlugin.betterMonadicFor,
      CompilerPlugin.semanticDB,
      Libraries.tessellationCurrencyL1
    )
  )
  .dependsOn(shared)

// Scalafix
ThisBuild / scalafixDependencies += Libraries.organizeImports
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision