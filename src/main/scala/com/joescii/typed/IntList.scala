package com.joescii.typed

sealed trait IntList[Size <: PeanoType] { self =>
  def ::(head:Int):IntList[TypeN[Size]] = IntListImpl(head, self)
  def +(other:IntList[Size]):IntList[Size]
}

case object IntNil extends IntList[Type0] { self =>
  override def +(other:IntList[Type0]) = self
}
private[typed] case class IntListImpl[SizeTail <: PeanoType](head:Int, tail:IntList[SizeTail]) extends IntList[TypeN[SizeTail]] { self =>
  private type Size = TypeN[SizeTail]
  override def +(other:IntList[Size]) = other match {
    case IntListImpl(h, t) => (head + h) :: (tail + t)
  }
}
