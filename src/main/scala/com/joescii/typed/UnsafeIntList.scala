package com.joescii.typed

sealed trait UnsafeIntList { self =>
  def ::(head:Int):UnsafeIntList = UnsafeIntListImpl(head, self)
  def +(other:UnsafeIntList):UnsafeIntList
  def size:Int 
}

case object UnsafeIntNil extends UnsafeIntList { self =>
  override def +(other:UnsafeIntList) = {
    require(other == UnsafeIntNil, "argument 'other' must be the UnsafeIntNil object")
    self
  }
  override val size = 0
}

private [typed] case class UnsafeIntListImpl(head:Int, tail:UnsafeIntList) extends UnsafeIntList {
  override def +(other:UnsafeIntList) = {
    require(other.size == size, "argument 'other' must have the same size as this UnsafeIntList")
    other match {
      case UnsafeIntListImpl(h, t) => (head + h) :: (tail + t)
    }
  }
  override val size = 1 + tail.size 
}