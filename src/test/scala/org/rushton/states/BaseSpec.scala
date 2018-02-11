package org.rushton.states

import org.scalatest.{FreeSpec, Matchers}

abstract class BaseSpec extends FreeSpec with Matchers with Utils {

  val validLetters = Seq("A", "C", "D", "F", "G", "H", "I", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "W")
  val invalidLetters = Seq(('A' to 'Z').map(_.toString) diff validLetters)
  val invalidStates: Seq[String] = Seq("French", "Fries", "Banana", "Republic")


}
