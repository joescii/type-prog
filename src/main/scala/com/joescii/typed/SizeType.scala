package com.joescii.typed

sealed trait SizeType {
  type add[That <: SizeType] <: SizeType
}
sealed trait Size0 extends SizeType {
  override type add[That <: SizeType] = That
}
sealed trait SizeN[Prev <: SizeType] extends SizeType {
  override type add[That <: SizeType] = SizeN[Prev#add[That]]
}