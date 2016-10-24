package shijiu

/**
  * Created by Pascal on 2016/10/22.
  */
class TestArrayOfScala {
  def main(args:Array[String]):Unit ={
    val a1: Array[String] = Array("abc")
     val a2: Array[Object] = a1.asInstanceOf[Array[Object]]
  }
}
