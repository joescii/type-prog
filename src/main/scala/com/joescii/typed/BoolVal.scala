package com.joescii.typed

sealed trait BoolVal { self =>
  def not:BoolVal
  def or(that:BoolVal):BoolVal
  def and(that:BoolVal) =
    (self.not or that.not).not
  def imp(that:BoolVal) =
    self.not or that
}

case object TrueVal extends BoolVal {
  override val not = FalseVal
  override def or(that:BoolVal) = TrueVal
}
case object FalseVal extends BoolVal {
  override val not = TrueVal
  override def or(that:BoolVal) = that
}
