package com.joescii.typed

sealed trait IntList[Size <: SizeType] {
  def ::(head:Int):IntList[SizeN[Size]] = IntListImpl(head, this)
  def +(other:IntList[Size]):IntList[Size]
  def ++[OtherSize <: SizeType](other:IntList[OtherSize]):IntList[Size#plus[OtherSize]]
  def size:Int
}

case object IntNil extends IntList[Size0] {
  override def +(other:IntList[Size0]) = this
  override val size = 0
  override def ++[OtherSize <: SizeType](other:IntList[OtherSize]) = other
}
private[typed] case class IntListImpl[SizeTail <: SizeType](head:Int, tail:IntList[SizeTail]) extends IntList[SizeN[SizeTail]] { 
  private type Size = SizeN[SizeTail] // defined for clarity
  override def +(other:IntList[Size]) = other match {
    case IntListImpl(h, t) => (head + h) :: (tail + t)
  }
  override val size = 1 + tail.size
  override def ++[OtherSize <: SizeType](other:IntList[OtherSize]) = IntListImpl(head, tail++other)
}