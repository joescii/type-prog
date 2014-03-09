package com.joescii.typed

sealed trait PeanoVal {
  def add(that:PeanoVal):PeanoVal
}
case object Val0 extends PeanoVal {
  override def add(that:PeanoVal) = that
}
case class ValN(prev:PeanoVal) extends PeanoVal {
  override def add(that:PeanoVal) = ValN(prev add that)
}