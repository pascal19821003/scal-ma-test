package shiwu.er.san

/**
  * Created by Pascal on 2016/12/5.
  */
object SealTest {
  def main(args:Array[String]): Unit =
  {
    val e : Exprs= Numbers(9)
    println(describe(e))

    val ee = BinOps("+", Vars("a"), Vars("bb"))
   // println(describe(ee))

    println("end")

    optionTest

    mushi

    foreee
  }



  def mushi:Unit ={
    val myTuple = (123, "abc")
    val (number, string ) = myTuple
    println(number)
    println(string)

    val exp = new BinOps("*", Numbers(5), Numbers(1))
    val BinOps(op, left , right) = exp
    println(op)
    println(left)
    println(right)
  }

  def foreee: Unit ={
    val results  = List(Some("apple"), None, Some("orange"))
    for(Some(fruit) <- results ) println(fruit)
  }

  def describe(e:Exprs):String = (e  : @unchecked) match{
    case Numbers(_) => "a number"
    case Vars(_) => "a variable"
   // case _ => throw new RuntimeException("runtime error")

      //


  }



  def optionTest: Unit ={
    val capitals = Map("France"->"Paris", "Japan" -> "Tokyo")
    println(capitals)
    println(capitals.get("France"))
//    val s: String = capitals.get("France").get
//    println(s)
//    val s1: String = capitals.get("France1").getOrElse("no")
//    println(s1)
    val maybeString: Option[String] = capitals.get("France22")

    val res: String = maybeString match {
      case Some(s) => s
      case None => "none"
    }
    println(res)
  }
}

sealed  abstract  class Exprs
case class Vars(name:String) extends  Exprs
case class Numbers(num:Double) extends Exprs
case class UpOps(Operator :String, arg:Exprs) extends Exprs
case class BinOps(operator:String, left:Exprs, right:Exprs) extends  Exprs
