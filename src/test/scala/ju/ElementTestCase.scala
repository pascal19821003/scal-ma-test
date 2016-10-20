package ju

import org.scalatest.junit.JUnit3Suite
import shi.Element.elem

/**
  * Created by Pascal on 2016/10/8.
  */
class ElementTestCase extends JUnit3Suite{
  def testUnitformElement(): Unit ={
    val ele = elem('x', 2, 3)
    assert(ele.width === 2)
//    expect(3){
//      ele.height
//    }
//    intercept(classOf[IllegalArgumentException]){
//      elem('x', -2, 3)
//    }

  }
}

import org.scalatest.testng.TestNGSuite
import org.testng.annotations.Test
import shi.Element.elem

class ElementSuite extends TestNGSuite{
  @Test def verifyUniformElement(): Unit ={
    val ele = elem('x', 2,3 )
    assert(ele.width === 2)
//     expect(3){
//       ele.height
//     }

//    intercept(classOf[IllegalArgumentException]){
//      elem('x', -2, 3)
//    }
  }
}
