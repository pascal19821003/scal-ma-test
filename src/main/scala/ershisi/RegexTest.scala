package ershisi

import scala.util.matching.Regex

/**
  * Created by Pascal on 2016/11/4.
  */
object RegexTest {
  def main(args:Array[String]): Unit ={
   val Decimal: Regex = """(-)?(\d+)(\.\d+)?""".r
    val input = "for -1.0 to 99 by 3"
    for(s<-Decimal.findAllIn(input)){
      println(s)
    }

    val Decimal(a,b,c) = "-1.23"
    println(a + "  "+ b +"  "+ c)

  }
}
