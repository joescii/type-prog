package com.joescii.typed

sealed trait IntList[Size <: SizeType] { self =>
  def ::(head:Int):IntList[SizeN[Size]] = IntListImpl(head, self)
  def +(other:IntList[Size]):IntList[Size]
  def size:Int
}

case object IntNil extends IntList[Size0] { self =>
  override def +(other:IntList[Size0]) = self
  override val size = 0
}
private[typed] case class IntListImpl[SizeTail <: SizeType](head:Int, tail:IntList[SizeTail]) extends IntList[SizeN[SizeTail]] { self =>
  private type Size = SizeN[SizeTail]
  override def +(other:IntList[Size]) = other match {
    case IntListImpl(h, t) => (head + h) :: (tail + t)
  }
  override val size = 1 + tail.size
}