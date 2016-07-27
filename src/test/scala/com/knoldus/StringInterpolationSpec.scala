package com.knoldus

import org.scalatest.{Matchers, FlatSpec}
import StringInterpolation.WriteScore

class StringInterpolationSpec extends FlatSpec with Matchers {

  "StringInterpolation" should "run for 1 st case" in {

    val name: String = "Sahil"
    val views: Long = 564487
    val actual: String = write"Total view of $name on ${java.time.LocalDate.now} are = \t $views "
    val expected: String = "File written successfully"
    actual should ===(expected)
  }

  "StringInterpolation" should "run for 2 nd case" in {

    val name = "LIHAS"
    val age = 24
    val salary = 12345.6789
    val actual: String = write"$name is $age years old\nand earns ₹ $salary"
    val expected: String = "File written successfully"
    actual should ===(expected)
  }

}
