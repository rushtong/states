package org.rushton.states

import java.io.{ByteArrayOutputStream, StringReader}

class ApplicationSpec extends BaseSpec {

  "Application" - {

    "should succeed with a valid choice" in {
      val app = Application
      val firstLetter = app.firstLetterChoice
      val state = states.find(_.startsWith(firstLetter)).head
      val out = new ByteArrayOutputStream()
      val error = new ByteArrayOutputStream()
      val input = new StringReader(state)
      Console.withOut(out) {
        Console.withIn(input) {
          Console.withErr(error) {
            Application.main(Array.empty[String])
          }
        }
      }
      convertOutput(out) should include ("Congratulations")
      convertOutput(error) shouldBe empty
    }

    "should fail with a non-state choice" in {
      val app = Application
      val state = "*DJ*DKLSJKDUUDDFKLJLSDD"
      val out = new ByteArrayOutputStream()
      val error = new ByteArrayOutputStream()
      val input = new StringReader(state)
      Console.withOut(out) {
        Console.withIn(input) {
          Console.withErr(error) {
            Application.main(Array.empty[String])
          }
        }
      }
      convertOutput(out) shouldNot include ("Congratulations")
      convertOutput(out) should include ("Sorry")
      convertOutput(error) shouldBe empty
    }

    "should fail with an incorrect state choice" in {
      val app = Application
      val firstLetter = app.firstLetterChoice
      val state = states.find(!_.startsWith(firstLetter)).head
      val out = new ByteArrayOutputStream()
      val error = new ByteArrayOutputStream()
      val input = new StringReader(state)
      Console.withOut(out) {
        Console.withIn(input) {
          Console.withErr(error) {
            Application.main(Array.empty[String])
          }
        }
      }
      convertOutput(out) shouldNot include ("Congratulations")
      convertOutput(out) should include ("Sorry")
      convertOutput(error) shouldBe empty
    }

  }

  private def convertOutput(boas: ByteArrayOutputStream): String = {
    boas.toByteArray.map(_.toChar).mkString
  }

}
