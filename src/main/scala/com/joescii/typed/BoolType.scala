package com.joescii.typed

sealed trait BoolType {
  protected type This <: BoolType
  type Not <: BoolType
  type Or[That <: BoolType] <: BoolType
  type And[That <: BoolType] = This#Not#Or[That#Not]#Not
  type Imp[That <: BoolType] = This#Not#Or[That]
}
sealed trait TrueType extends BoolType {
  protected override type This = TrueType
  override type Not = FalseType
  override type Or[That <: BoolType] = TrueType
}
sealed trait FalseType extends BoolType {
  protected override type This = FalseType
  override type Not = TrueType
  override type Or[That <: BoolType] = That
}
