package kpccoil.demitasse.main

import kpccoil.demitasse.Question
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafxml.core.{FXMLView, DependenciesByType}

object Demitasse extends JFXApp {
  val root = FXMLView(getClass.getResource("/main-window.fxml"),
    new DependenciesByType(Map()))
  stage = new JFXApp.PrimaryStage {
    title = "Demitasse"
    scene = new Scene(root)
  }
}
