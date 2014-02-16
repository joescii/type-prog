package com.joescii.typed

sealed trait BoolType {
  type Not <: BoolType
  type Or[That <: BoolType] <: BoolType
}
sealed trait TrueType extends BoolType {
  override type Not = FalseType
  override type Or[That <: BoolType] = TrueType
}
sealed trait FalseType extends BoolType {
  override type Not = TrueType
  override type Or[That <: BoolType] = That
}
