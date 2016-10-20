package com.yy.oop

/**
  * Created by Pascal on 2016/10/7.
  */
class Person1 {
  var name:String = _
  var age:Int = 26

  def this(name:String) {
    this
    this.name = name
  }

  def info(): Unit ={
    println(this.name + " : "+ this.age)
  }
}

object ConstructorTest{
  def main(args:Array[String]) ={
    println("Person1:使用默认的无参主构造器");
    val p1 = new Person1()
    p1.name = "yy"
    p1.info()
    println("Person1:使用辅助构造器");
    var p12 = new Person1("yyxx")
    p12.info()
  }
}
