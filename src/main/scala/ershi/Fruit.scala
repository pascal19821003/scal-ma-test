package ershi

/**
  * Created by Pascal on 2016/10/24.
  */
abstract class Fruit {
  val v:String
  def m:String
}

abstract class Apple extends Fruit{
  val v:String
  val m:String
}

//abstract class BadApple extends Fruit {
//  def v:String
//  def m:String
//}
