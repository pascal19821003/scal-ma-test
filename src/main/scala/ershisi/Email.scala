package ershisi

/**
  * Created by Pascal on 2016/11/4.
  */
object Email {

  def apply(user: String, domain: String) = user + "@" + domain

  def unapply(str: String): Option[(String, String)] = {
    println("Email unapply " + str)
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }

  def main(args: Array[String]): Unit = {
    val email: String = Email("pascal", "sina.com")
//    val unapply1: Option[(String, String)] = Email.unapply(email)
//    println(unapply1)

    email match {
      case Email(t) => {
        println(t)
              }
      case _ => {
        println("None")
       }
    }


    "aaa" match {
      case Email(t) => println(t)
      case _ => println("None")
    }
  }
}

//object ExpandedEMail{
//  def unapplySeq(email:String) :Option[(String, Seq[String])] = {
//    val parts = email split "@"
//    if (parts.length ==2 )
//      Some(parts(0), parts(1).split("\\.").reverse)
//      else
//      None
//
//  }
//}