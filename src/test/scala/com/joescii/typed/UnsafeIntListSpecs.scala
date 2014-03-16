package com.joescii.typed

import org.scalatest._
import matchers.ShouldMatchers

class UnsafeIntListSpecs extends FlatSpec with ShouldMatchers {
  "The UnsafeIntNil" should "equal itself under addition" in {
    val sum = UnsafeIntNil + UnsafeIntNil
    sum should equal (UnsafeIntNil)
  }

  "1 :: UnsafeIntNil + 2 :: UnsafeIntNil" should "equal 3 :: UnsafeIntNil" in {
    val sum = (1 :: UnsafeIntNil) + (2 :: UnsafeIntNil)
    sum should equal (3 :: UnsafeIntNil)
  }

  "1 :: 2 :: UnsafeIntNil + 3 :: 4 :: UnsafeIntNil" should "equal 4 :: 6 :: UnsafeIntNil" in {
    val sum = (1 :: 2 :: UnsafeIntNil) + (3 :: 4 :: UnsafeIntNil)
    sum should equal (4 :: 6 :: UnsafeIntNil)
  }

  "1 :: UnsafeIntNil + UnsafeIntNil" should "throw an exception" in {
    intercept[IllegalArgumentException]((1 :: UnsafeIntNil) + UnsafeIntNil)
  }

  "1 :: 2 :: UnsafeIntNil + UnsafeIntNil" should "throw an exception" in {
    intercept[IllegalArgumentException]((1 :: 2 :: UnsafeIntNil) + UnsafeIntNil)
  }

  "1 :: 2 :: UnsafeIntNil + 3 :: UnsafeIntNil" should "throw an exception" in {
    intercept[IllegalArgumentException]((1 :: 2 :: UnsafeIntNil) + (3 :: UnsafeIntNil))
  }

  "UnsafeIntNil + 3 :: UnsafeIntNil" should "throw an exception" in {
    intercept[IllegalArgumentException]((UnsafeIntNil) + (3 :: UnsafeIntNil))
  }

}
