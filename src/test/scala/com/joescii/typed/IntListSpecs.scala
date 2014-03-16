package com.joescii.typed

import org.scalatest._
import matchers.ShouldMatchers
import shapeless.test.illTyped

class IntListSpecs extends FlatSpec with ShouldMatchers {
  illTyped("val nil:IntNil = 1 :: IntNil")
  illTyped("(1 :: IntNil) + IntNil")
  illTyped("(1 :: 2 :: IntNil) + IntNil")
  illTyped("(1 :: 2 :: IntNil) + (3 :: IntNil)")
  illTyped("IntNil + (3 :: IntNil)")

  "The IntNil" should "equal itself under addition" in {
    val sum = IntNil + IntNil
    sum should equal (IntNil)
  }

  "1 :: IntNil + 2 :: IntNil" should "equal 3 :: IntNil" in {
    val sum = (1 :: IntNil) + (2 :: IntNil)
    sum should equal (3 :: IntNil)
  }

  "1 :: 2 :: IntNil + 3 :: 4 :: IntNil" should "equal 4 :: 6 :: IntNil" in {
    val sum = (1 :: 2 :: IntNil) + (3 :: 4 :: IntNil)
    sum should equal (4 :: 6 :: IntNil)
  }
}
