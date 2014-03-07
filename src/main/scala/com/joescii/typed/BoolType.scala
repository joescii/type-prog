package com.joescii.typed

sealed trait BoolType { self =>
  type Not <: BoolType
  type Or[That <: BoolType] <: BoolType
  type And[That <: BoolType] = self.type#Not#Or[That#Not]#Not
  type Imp[That <: BoolType] = self.type#Not#Or[That]
}
sealed trait TrueType extends BoolType {
  override type Not = FalseType
  override type Or[That <: BoolType] = TrueType
}
sealed trait FalseType extends BoolType {
  override type Not = TrueType
  override type Or[That <: BoolType] = That
}
