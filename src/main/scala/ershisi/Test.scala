package ershisi

/**
  * Created by Pascal on 2016/11/4.
  */
object Test {
  def main(args:Array[String]):Unit = {
//    val x = Test(5);
//
//    x match{
//      case Test(num) => println(x + " is bigger two times than " + num)
//      case _ => println("i cannot calculate")
//    }

    val ints: List[Int] = List(1,2,3)
    ints match {
      case List(1, x, y) => {
        println("found it")
        println(x + " "+ y)
      }
      case _ => println("not found")
    }

    ints match {
      case List(x,_*) => println(x)
      case _ =>
    }

  }

  def apply(x:Int) = x*2

  def unapply(z:Int) :Option[Int] = {
    if(z%2==0) Some(z/2)
    else None
  }

}
