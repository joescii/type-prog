package com.joescii.typed

sealed trait IntList[Size <: SizeType] {
  def ::(head:Int):IntList[SizeN[Size]] = IntListImpl(head, this)
  def +(that:IntList[Size]):IntList[Size]
  def ++[ThatSize <: SizeType](that:IntList[ThatSize]):IntList[Size#plus[ThatSize]]
  def size:Int
}

case object IntNil extends IntList[Size0] {
  override def +(that:IntList[Size0]) = this
  override val size = 0
  override def ++[ThatSize <: SizeType](that:IntList[ThatSize]) = that
}
private[typed] case class IntListImpl[TailSize <: SizeType](head:Int, tail:IntList[TailSize]) extends IntList[SizeN[TailSize]] { 
  private type Size = SizeN[TailSize] // defined for clarity
  override def +(that:IntList[Size]) = that match {
    case IntListImpl(h, t) => (head + h) :: (tail + t)
  }
  override val size = 1 + tail.size
  override def ++[ThatSize <: SizeType](that:IntList[ThatSize]) = IntListImpl(head, tail++that)
}