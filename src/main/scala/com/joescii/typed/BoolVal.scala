package com.joescii.typed

sealed trait BoolVal

case object TrueVal extends BoolVal
case object FalseVal extends BoolVal
