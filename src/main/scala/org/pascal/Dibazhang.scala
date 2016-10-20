package org.pascal

/**
  * Created by Pascal on 2016/9/27.
  */
object Dibazhang {
  def main(args:Array[String]): Unit ={
//    val width =args(0).toInt;
//    for(arg<-args.drop(1)){
//      println("handle file:" + arg);
//      LongLines.processFile(arg, width);
//    }

//    val increase = (x:Int)=>x + 1
//    println(increase(1))

    val someNumbers = List(-11, -10, -5, 0, 5, 10)
//    someNumbers.foreach((x:Int)=>println(x))
//    someNumbers.filter(_ > 0).foreach( println _ )

    def sum(a:Int, b:Int, c:Int)  = a + b + c

//    val a = sum _
//    println(a(1,2,3))
//    println(a.apply(1,2,3))

//    val b = sum(1,  _ : Int , 3)
//    println(b(2))

//    var more = 1
    //    val addMore = (x:Int) => x+more
    //    println(addMore(10))
    //
    //    more = 2
    //    println(addMore(10))

    def makeIncrease(more:Int) = (x:Int) => x+more
    val inc1 = makeIncrease(1)
    val inc9999= makeIncrease(9999)

    println(inc1(10))
    println(inc9999(10))
  }

}
