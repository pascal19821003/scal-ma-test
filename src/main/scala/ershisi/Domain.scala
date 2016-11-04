package ershisi

/**
  * Created by Pascal on 2016/11/4.
  */
object Domain {
  def apply(parts: String*): String =
    parts.reverse.mkString(".")

  def unapplySeq(whole: String): Option[Seq[String]] = {
    println("Domain unapply: " + whole)
    val split: Array[String] = whole.split("\\.")
    Some(split.reverse)
  }


  def main(args: Array[String]): Unit = {
    "aa@mail.sina.com" match {
      case Email("aa", Domain("com", _*)) => {
        //println(x)
        //println(y)
        println("match")
        true
      }
      case _ => {
        println("no match")
        false
      }
    }
  }
}
