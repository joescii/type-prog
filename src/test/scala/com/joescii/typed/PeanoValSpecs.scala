package com.joescii.typed

import org.scalatest._
import matchers.ShouldMatchers

class PeanoValSpecs extends WordSpec with ShouldMatchers {
  "Val0" should {
    "be less than or equal to itself" in { (Val0 le Val0 ) should be (TrueVal) }
    "be less than or equal to ValN(Val0)" in { (Val0.le(ValN(Val0))) should be (TrueVal) }
  }

  "Val1 = ValN(Val0)" should {
    "run" in { ValN(Val0) should not be (null) }
    val Val1 = ValN(Val0)
    "not be less than or equal to Val0" in { (Val1 le Val0) should be (FalseVal) }
    "be less than or equal to itself" in { (Val1 le Val1) should be (TrueVal) }
    "be less than or equal to ValN(ValN(Val0))" in { (Val1 le ValN(Val1)) should be (TrueVal) }
  }
}
