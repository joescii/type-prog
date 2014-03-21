package com.joescii.typed

import shapeless.test.illTyped

object SizeTypeSpecs {
  type Type1 = SizeN[Size0]
  type Type2 = SizeN[Type1]
  type Type3 = SizeN[Type2]

  implicitly[Size0 =:= Size0]
  illTyped("implicitly[Type0 =:= Type1]")

  implicitly[Size0#plus[Type1] =:= Type1]
  implicitly[Type1#plus[Type1] =:= Type2]
  implicitly[Type1#plus[Type2] =:= Type3]
}
