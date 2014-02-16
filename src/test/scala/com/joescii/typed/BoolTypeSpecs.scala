package com.joescii.typed

import shapeless.test.illTyped

object BoolTypeSpecs {
  implicitly[TrueType =:= TrueType]
  implicitly[FalseType =:= FalseType]
  illTyped("implicitly[TrueType =:= FalseType]")
  illTyped("implicitly[FalseType =:= TrueType]")

  implicitly[TrueType#Not =:= FalseType]
  implicitly[FalseType#Not =:= TrueType]
  illTyped("implicitly[TrueType#Not =:= TrueType]")
  illTyped("implicitly[FalseType#Not =:= FalseType]")
}
