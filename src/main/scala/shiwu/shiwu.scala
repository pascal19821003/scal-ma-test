package shiwu

/**
  * Created by Pascal on 2016/10/10.
  */
object shiwu {
  def show(x: Option[String])=x match {
    case Some(s) => s
    case None => "?"
  }
  def describe(e:Expr) :String = e match{
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }

  def simplifyBad(expr:Expr) :Expr = expr match{
    case UnOp("-", UnOp("-", e)) => e
    case UnOp(op, e) => UnOp(op, simplifyBad(e))
  }
  def   simplifyAll(expr:Expr) :Expr = expr match{
    case UnOp("-", UnOp("-", e)) => simplifyAll(e)
    case BinOp("+", e, Number(0)) => simplifyAll(e)
    case BinOp("*", e, Number(1)) => simplifyAll(e)
    case UnOp(op, e) => UnOp(op, simplifyAll(e))
    case BinOp(op, l, r) =>BinOp(op, simplifyAll(l), simplifyAll(r))
    case _ => expr
  }

  def main(args:Array[String]): Unit ={
//    println(1)
//
//    val s = "baabb"
//    val r = s match{
//      case s:String if s(0) == 'a' => {
//        println("matched")
//        s
//      }
//      case _ => "eeee"
//    }
//    println(r)

//    val describe1: String = describe(Var("a"))
//    println(describe1)
//
//    val capitals = Map("France" -> "Paris" , "Japan" -> "Tokyo")
//    val r = capitals get "France"
//    println(show(r))
//    val r2 = capitals get "North Pole"
//    println(show(r2))

    val myTuple = (123, "abc")
    val (number, string) = myTuple

    println(number)
    println(string)

    val exp = new BinOp("*", Number(5), Number(1))
    val BinOp(op, left , right ) = exp
    println(op)
    println(left)
    println(right)



  }
  def simplifyAdd(e:Expr) = e match{
    case BinOp("+", x, y) if x==y =>BinOp("*", x, Number(2))
    case _ => e
  }
}
