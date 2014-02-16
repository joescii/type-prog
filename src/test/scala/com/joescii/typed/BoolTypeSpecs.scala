package com.joescii.typed

object BoolTypeSpecs {
  implicitly[TrueType =:= TrueType]
  implicitly[FalseType =:= FalseType]
}
