package org.pascal

/**
  * Created by Pascal on 2016/9/17.
  */
object HelloWorld {
  def main(args: Array[String]): Unit = {
//    println("hello world");

    val msg = "hello, world!";
    println(msg);

    val msg2 : java.lang.String = "Hello, world2!";
    println(msg2);

    //msg = "xx";
    var greeting1 = "你好！";

    greeting1 = "Leave me alone , world!";

    println(greeting1);

    println(max(5,6))
    println("max2:" + max(0,1))

    greeting

    testWhile()

    //
    args.foreach(arg=>println(arg))
    //
    println("============");
    args.foreach((arg:String) => println(arg ))

    //
    for(arg<-args){
      println("for loop:"+arg)
    }
  }

  def testWhile(): Unit ={
    var i = 0;
    while(i<10){
      println(i);
      i += 1;
    }
  }
  def max(x : Int, y : Int ):Int = {
    if(x>y)x
    else y
  }

  def max2(x:Int, y:Int)=if(x>y)x else y;

  def greeting = println("你好")
}
