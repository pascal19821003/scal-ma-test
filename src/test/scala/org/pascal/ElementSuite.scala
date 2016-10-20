package org.pascal

import org.scalatest.{Spec, Suite}
import shi.Element.elem
/**
  * Created by Pascal on 2016/10/8.
  */
class ElementSuite extends Spec{
  def testUniformElement(): Unit ={
    val ele = elem('x', 2, 3)
   // ele.width == 2
    //assert()
    assert(ele.width==23)
  }
}
