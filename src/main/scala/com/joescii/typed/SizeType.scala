package com.joescii.typed

sealed trait SizeType {
  type plus[That <: SizeType] <: SizeType
}
sealed trait Size0 extends SizeType {
  override type plus[That <: SizeType] = That
}
sealed trait SizeN[Prev <: SizeType] extends SizeType {
  override type plus[That <: SizeType] = SizeN[Prev#plus[That]]
}