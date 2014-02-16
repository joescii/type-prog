package com.joescii.typed

sealed trait BoolType {
  type Not <: BoolType
}
sealed trait TrueType extends BoolType {
  type Not = FalseType
}
sealed trait FalseType extends BoolType {
  type Not = TrueType
}
