package com.joescii.typed

sealed trait BoolVal {
  def not:BoolVal
  def or(that:BoolVal):BoolVal
  def and(that:BoolVal) =
    (this.not or that.not).not
  def imp(that:BoolVal) =
    this.not or that
}

case object TrueVal extends BoolVal {
  override val not = FalseVal
  override def or(that:BoolVal) = TrueVal
}
case object FalseVal extends BoolVal {
  override val not = TrueVal
  override def or(that:BoolVal) =
    if(TrueVal == that) TrueVal else FalseVal
}
