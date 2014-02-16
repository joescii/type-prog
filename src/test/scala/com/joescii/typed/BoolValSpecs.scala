package com.joescii.typed

import org.scalatest._
import matchers.ShouldMatchers

class BoolValSpecs extends WordSpec with ShouldMatchers {
  "FalseVal" should {
    "equal itself" in { FalseVal should equal (FalseVal) }
    "not equal TrueVal" in { FalseVal should not equal (TrueVal) }
  }

  "TrueVal" should {
    "equal itself" in { TrueVal should equal (TrueVal) }
    "not equal FalseVal" in { TrueVal should not equal (FalseVal) }
  }

  "FalseVal.not" should {
    "not equal FalseVal" in { (FalseVal.not) should not equal (FalseVal) }
    "equal TrueVal" in { (FalseVal.not) should equal (TrueVal) }
  }

  "TrueVal.not" should {
    "not equal TrueVal" in { (TrueVal.not) should not equal (TrueVal) }
    "equal FalseVal" in { (TrueVal.not) should equal (FalseVal) }
  }

  "FalseVal.or" should {
    "equal TrueVal when passed TrueVal" in
      { (FalseVal or TrueVal) should equal (TrueVal) }
    "equal FalseVal when passed FalseVal" in
      { (FalseVal or FalseVal) should equal (FalseVal) }
  }

  "TrueVal.or" should {
    "equal TrueVal" in {
      (TrueVal or FalseVal) should equal (TrueVal)
      (TrueVal or TrueVal) should equal (TrueVal)
    }
  }

  "BoolVal.and" should {
    "satisfy the expected truth table" in {
      (TrueVal and TrueVal) should equal (TrueVal)
      (TrueVal and FalseVal) should equal (FalseVal)
      (FalseVal and TrueVal) should equal (FalseVal)
      (FalseVal and FalseVal) should equal (FalseVal)
    }
  }

  "BoolVal.imp" should {
    "satisfy the expected truth table" in {
      (TrueVal imp TrueVal) should equal (TrueVal)
      (TrueVal imp FalseVal) should equal (FalseVal)
      (FalseVal imp TrueVal) should equal (TrueVal)
      (FalseVal imp FalseVal) should equal (FalseVal)
    }
  }
}
