package ershisi

/**
  * Created by Pascal on 2016/11/4.
  */
object Twice {

  def apply(s:String):String = s + s

  def unapply(s:String) : Option[String] = {
    println("Twice unapply " + s)
    val length = s.length/2
    val half = s.substring(0, length)
    println("half "+ half)
    val maybeString: Option[String] = if (half == s.substring(length)) {
      Some(half)
    } else {
      None
    }
    println("maybeString "+ maybeString)
    maybeString

  }

  def userTwiceUpper(s:String)  = s match {
    case Email(Twice(x @ UpperCase()), domain) =>
      "match" + x + " in domain " + domain
    case _ =>
      "no match"
  }

  def main(args : Array[String]): Unit ={
    val upper: String = userTwiceUpper("ABAB@sina.com")
    println(upper)
  }
}

object UpperCase{
  def unapply(s:String) : Boolean = {
    println("UpperCase unapply " + s)
    s.toUpperCase == s
  }
}


