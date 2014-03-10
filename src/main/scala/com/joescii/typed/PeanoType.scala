package com.joescii.typed

sealed trait PeanoType {
  type add[That <: PeanoType] <: PeanoType
}
sealed trait Type0 extends PeanoType {
  override type add[That <: PeanoType] = That
}
sealed trait TypeN[Prev <: PeanoType] extends PeanoType {
  override type add[That <: PeanoType] = TypeN[Prev#add[That]]
}