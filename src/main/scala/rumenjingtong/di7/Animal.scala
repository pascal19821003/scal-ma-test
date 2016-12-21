package rumenjingtong.di7

/**
  * Created by Pascal on 2016/11/18.
  */
abstract class Animal {
  var height:Int
  def eat:Unit
}


class Person(var height:Int)  extends Animal{
  def eat:Unit={
    println("eat by mouth")
  }
}

object Person extends App{
  new Person(10).eat
}


