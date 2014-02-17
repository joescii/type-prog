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

  implicitly[TrueType#Or[TrueType] =:= TrueType]
  implicitly[TrueType#Or[FalseType] =:= TrueType]
  implicitly[FalseType#Or[TrueType] =:= TrueType]
  implicitly[FalseType#Or[FalseType] =:= FalseType]

  implicitly[TrueType#And[TrueType] =:= TrueType]
  implicitly[TrueType#And[FalseType] =:= FalseType]
  implicitly[FalseType#And[TrueType] =:= FalseType]
  implicitly[FalseType#And[FalseType] =:= FalseType]

  implicitly[TrueType#Imp[TrueType] =:= TrueType]
  implicitly[TrueType#Imp[FalseType] =:= FalseType]
  implicitly[FalseType#Imp[TrueType] =:= TrueType]
  implicitly[FalseType#Imp[FalseType] =:= TrueType]
}
