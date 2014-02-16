package com.joescii.typed

sealed trait BoolType {
  type Not <: BoolType
}
sealed trait TrueType extends BoolType {
  override type Not = FalseType
}
sealed trait FalseType extends BoolType {
  override type Not = TrueType
}
