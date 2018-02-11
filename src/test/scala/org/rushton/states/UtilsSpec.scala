package org.rushton.states

class UtilsSpec extends BaseSpec {

  "Random First Letter" - {
    "should always have a valid letter" in {
      (1 to 10000).map { count =>
        firstLetters should contain(randomFirstLetter)
      }
    }
  }

  "Is Real State" - {
    "should validate for valid states" in {
      states.map { s =>
        isRealState(s) should be (true)
      }
    }
    "should not validate for invalid states" in {
      invalidStates.map { s =>
        isRealState(s) should be (false)
      }
    }
  }

}
