package com.joescii.typed

sealed trait PeanoVal {
  def +(that:PeanoVal):PeanoVal
}
case object Val0 extends PeanoVal {
  override def +(that:PeanoVal) = that
}
case class ValN(prev:PeanoVal) extends PeanoVal {
  override def +(that:PeanoVal) = ValN(prev + that)
}