package com.joescii.typed

import org.scalatest._
import matchers.ShouldMatchers

class PeanoValSpecs extends FlatSpec with ShouldMatchers {
  val Val1 = ValN(Val0)
  val Val2 = ValN(Val1)

  "0 + 0" should "equal 0" in { Val0 add Val0 should equal (Val0) }
  "0 + 1" should "equal 1" in { Val0 add Val1 should equal (Val1) }
  "1 + 0" should "equal 1" in { Val1 add Val0 should equal (Val1) }
  "1 + 1" should "equal 2" in { Val1 add Val1 should equal (Val2) }
}
