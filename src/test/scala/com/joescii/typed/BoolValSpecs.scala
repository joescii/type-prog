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
}
