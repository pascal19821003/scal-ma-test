package shi.s

/**
  * Created by Pascal on 2016/11/23.
  */
abstract class Element {
def demo(): Unit ={
  println("Element is implementation invoked")
}
}

class ArrayElement extends  Element{
   final override  def demo():Unit ={
    println("ArrayElement is implementation invoked")
  }
}

object Ab{
  def main(args:Array[String]): Unit ={
    val ae = new ArrayElement
    ae.demo()
  }
}
