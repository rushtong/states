package org.rushton.states

import scala.util.Random

trait Utils extends Data {

  def randomFirstLetter: String = Random.shuffle(firstLetters.toList).head

  def isRealState(input: String): Boolean = {
    states.map(_.toLowerCase.trim).contains(input.toLowerCase.trim)
  }

}
