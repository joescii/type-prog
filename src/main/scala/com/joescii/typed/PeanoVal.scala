package com.joescii.typed

sealed trait PeanoVal {
  def le(that:PeanoVal):BoolVal
}

case object Val0 extends PeanoVal {
  override def le(that:PeanoVal) = TrueVal
}
case class ValN(prev:PeanoVal) extends PeanoVal {
  override def le(that:PeanoVal) = (ValN(that) le prev).not
}