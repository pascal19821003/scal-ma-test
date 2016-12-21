package shiwu.si

/**
  * Created by Pascal on 2016/12/21.
  */
abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UpOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object Tess {
  def simplifyTop(expr: Expr) = expr match {
    case UpOp("-", UpOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _ => expr
  }

  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "true"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }

  def generalSize(x: Any): Int = x match {
    case s: String => s.length
    case m: Map[String, String] => m.size
    case _ => 1
  }

  def isIntIntMap(x:Any) :Boolean = x match {
    case m: Map[Int, Int] => true
    case _ => false
  }

  def simplifyAdd(e:Expr)  = e match {
    case BinOp("+", x , y ) if( x == y ) => BinOp("*", x, Number(2))
    case _ => e
  }


  def main(args: Array[String]): Unit = {
    //    val v = Var("x")
    //    val op = BinOp("+", Number(1), v)
    //    println(v.name)
    //    println(op.left)
    //    println(op)

    val top: Expr = simplifyTop(UpOp("-", UpOp("-", Var("sss"))))
    println(top)

    top match {
      case BinOp(_, _, _) => println(top + "  is a binary operation")
      case Var(x) => println(top + "is Var, the value is " + x)
      case _ => println("It's something else")
    }

    //
    println(describe(true))
    println(describe("hello"))

    val expr: Any = "aa"
    var res = expr match {
      case 0 => "zero"
      case somethingElse => "not zero: " + somethingElse
    }
    println("res: " + res)

    var binOpExpr: Expr = BinOp("+", Number(11), Number(0))
    val ress = binOpExpr match {
      case BinOp("-", e, Number(0)) => e
      case _ => None
    }
    println(ress == None)

    val rs = List(1, 1, 2) match {
      case List(0, _*) => true
      case _ =>
    }
    println(rs)

    println(generalSize("aaAa"))
    println(generalSize(Map("a" -> "a1", "b" -> "b1", "c" -> "c1")))
    println(generalSize(111))

    println(isIntIntMap(Map(1->2, 0->1)))
    println(isIntIntMap(Map(1->"22", 0->"11" )))

    val expr1:Any = UpOp("abs", UpOp("abs", Number(-10)))
    val rr = expr1 match {
      case UpOp("abs", e @ UpOp("abs", _)) => e
      case _ =>
    }
    println(rr)

    //
    println(simplifyAdd(BinOp("+", Number(10), Number(2))) )

    //
    val capitals = Map("France" -> "Paris" ,  "Japan" -> "Tokyo")
    println(capitals.get("France"))
    val maybeString: Option[String] = capitals.get("France")
    def show(x:Option[String]) :String = x match {
      case Some(s) => s
      case None => "?"
    }
    println(show(maybeString))

    //
    val myTuple = (123, "abc")
    val (number, string) = myTuple
    println(number + " " + string )

    val exp = BinOp("*", Number(5), Number(10))
    val BinOp(op, left ,right ) = exp
    println(op)
    println(left)
    println(right)

    val withDefault: Option[Int] => Int ={
      case Some(x) => x
      case None => 0
    }
    println(withDefault(Some(10)))

    //
    for((country, city) <- capitals ){
      println("The capital of " + country + " is " + city)
    }

    //
    val results = List(Some("apple"), None, Some("orange"))
    for(Some(v) <- results) println(v)
    results.foreach((x:Option[String]) => {
        var  r = x match {
          case Some(v) => v
          case _ =>
        }
        println(r)
    })
  }
}