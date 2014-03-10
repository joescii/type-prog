package com.joescii.typed

import shapeless.test.illTyped

object PeanoTypeSpecs {
  type Type1 = TypeN[Type0]
  type Type2 = TypeN[Type1]
  type Type3 = TypeN[Type2]

  implicitly[Type0 =:= Type0]
  illTyped("implicitly[Type0 =:= Type1]")

  implicitly[Type0#add[Type1] =:= Type1]
  implicitly[Type1#add[Type1] =:= Type2]
  implicitly[Type1#add[Type2] =:= Type3]
}
