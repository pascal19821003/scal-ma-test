package org.pascal

import java.io.{File, PrintWriter}

/**
  * Created by Pascal on 2016/9/29.
  */
object Dijiuzhang {
  def main(args : Array[String]):Unit={
    println("hello,world!");

    FileMatcher.fileEnding2("xml").foreach(f => println(f.getName))

    println(containsNeg(List(0,-1,-2)))

    println(containsOdd(List(2,4,1)))

    println(curriedSum(1)(2))

    val second = first(100);
    println(second(200))

    val onPlus = curriedSum(1000)_
    println(onPlus(2000))

    println(twice(_+1, 5))

    withPrintWriter(new File("aa.txt"), writer=>writer.println(new java.util.Date()))
    withPrintWriter2{new File("aa2.txt")}{writer=>writer.println(new java.util.Date())}

    println{"hello, world!"}

    println(myAssert(5/0==33))

  }

  def containsNeg(nums: List[Int])  = nums.exists( _ < 0 )

  def containsOdd(nums: List[Int]) = nums.exists(_%2==1)

  def curriedSum(x:Int)(y:Int)  = x + y

  def first (x:Int ) = (y:Int) => x + y

  def twice(op:Double =>Double, x:Double) = op(op(x))

  def withPrintWriter(file:File, op:PrintWriter => Unit ) ={
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally {
      writer.close()
    }
  }

  def withPrintWriter2(file:File)(op:PrintWriter=>Unit){
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close()
    }
  }

  def myAssert(predicate: => Boolean ) =
   {
     println("myAssert")
     if(!predicate){
       throw new AssertionError
     }

   }

}
