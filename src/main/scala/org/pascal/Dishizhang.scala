package org.pascal

/**
  * Created by Pascal on 2016/10/1.
  */
object Dishizhang {
  def main(args:Array[String]) :Unit = {
    val ae = new ArrayElement(Array("hello","world"))

    println("width:"+ae.width + " height:"+ ae.height)
  }
}

//object Element{
//  def elem(contents :Array[String]):Element = new ArrayElement(contents)
//}
