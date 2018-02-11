package org.rushton.states


class DataSpec extends BaseSpec {

  "States" - {
    "should have 50 states" in {
      states.size should be(50)
    }
    "should not contain bad data" in {
      invalidStates.map { is =>
        states shouldNot contain(is)
      }
    }
  }

  "First Letters" - {
    "should have valid ones" in {
      validLetters.map { l =>
        firstLetters should contain(l)
      }
    }
    "should not have invalid ones" - {
      invalidLetters.map { l =>
        firstLetters shouldNot contain(l)
      }
    }
  }

}
