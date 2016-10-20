package org.pascal

/**
  * Created by Pascal on 2016/9/21.
  */
object Disanzhang {
  def main(args:Array[String]):Unit={
    println(1)

    //
    val greetStrings:Array[String] = new Array[String](3)

    greetStrings(0) = "hello"
    greetStrings(1) = ","
    greetStrings(2) = "world!\n"

    for(i<-0 to 2){
      println(greetStrings(i))
    }

    for(i <- 0.to(2))
      println("i:" + i)

    val numNames=Array("zero", "one", "two")
    numNames.foreach(println)

    //
    val oneTwo = List(1,2)
    val threeFour = List(3,4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println(    oneTwo.hashCode())
    println(    threeFour.hashCode())
    println(    oneTwoThreeFour.hashCode())

    println(oneTwoThreeFour)

    println(oneTwo)
    println(threeFour)

    //
    val twoThree = List(2,3)
    val oneTwoThree = 1::twoThree
    println(oneTwoThree)

    val one23 = 1::2::3::Nil
    println(one23)
  }
}
