package shiwu.er

/**
  * Created by Pascal on 2016/12/3.
  */
abstract class Expr
case class Var(name:String) extends  Expr
case class Number(num:Double) extends Expr
case class UpOp(Operator :String, arg:Expr) extends Expr
case class BinOp(operator:String, left:Expr, right:Expr) extends  Expr

object Testss{
  def main(args:Array[String]): Unit ={
    val v = Var("x")
    val op = BinOp("+", Number(1), v)
    println(v.name)
    println(op.left)
    println(op)
    println(op.right == Var("x"))

    val top: Expr = simplyTop(UpOp("-", UpOp("-", Var("x"))))
    println(top)

    //
    val expr = BinOp("+", Number(1), Number(2))
    tongpei(expr)
    val exprE = Var("xx")
    tongpei(exprE)

    //
    val x =5
    println(changliang(x))
    println(changliang(true))
    println(changliang(List()))
    println(changliang("aa"))

    //
    println(biangliang(0))
    println(biangliang(2))

    //
    println(changliang2(Math.PI))
    println(changliang2(2))

    //
    val expr1:BinOp = BinOp("+", Number(20), Number(1))
    println(gouzaoqi(expr1))

    //
    println(xulie(List(1,2,3)))
    println(xulie(List(1,2,3,4)))

    //
    println(xulie2(List(0,1,2,3,4,5)))
    println(xulie2(List(1,1,2,3,4,5)))

    //
    println(yuanzu(("a ", 2, "-tuple")))

    //
    println(generalSize("abc"))
    println( generalSize(Map(1->'a', 2->'b', 3->'c')))
    println(  generalSize(Math.PI))

    //
    println(leixingcaichu(Map(1->11, 2->22)))
    println(leixingcaichu(Map("a"->"aa")))

    //
    println(leixingcachu2(Array("a", "b","c")))
    println(leixingcachu2(Array(1, 2, 3)))

    //
    val ee = UpOp("abs", UpOp("abs", Number(3)))
    println(bianliangbangding(ee))

    val exprr = BinOp("+", Number(3), Number(3))
    println(simplifyAdd(exprr))
  }

  def simplifyBad(expr:Expr) :Expr = expr match {
    case UpOp(op, e) => UpOp(op, simplifyBad(e))
    case UpOp("-", UpOp("-", e) ) => e
  }

  def simplifyAll(expr:Expr) :Expr = expr match {
    case UpOp("-", UpOp("-", e)) => simplifyAll(e)
    case BinOp("+", e, Number(0)) => simplifyAll(e)
    case BinOp("*", e, Number(1)) => simplifyAll(e)
    case UpOp(op, e) => UpOp(op, simplifyAll(e))
    case BinOp(op, l, r ) => BinOp(op, simplifyAll(l), simplifyAll(r))
    case _ => expr
  }

  def simplifyAdd(e:Expr):Expr = e match {
    case BinOp("+", x, y) if x == y => BinOp("*", x , Number(2))
    case _ => e
  }

  def bianliangbangding(expr:Any) :Any=expr match{
    case UpOp("abs", e @ UpOp("abs", _)) => e
    case _ =>
  }

  def leixingcachu2(x:Any) = x match{
    case a: Array[String] => "yes"
    case _ => "no"
  }
  def leixingcaichu(x:Any) =x match{
    case m:Map[Int, Int] => true
    case _ => false
  }
  def generalSize(x:Any):Int  = x match {
    case s: String => s.length
    case m: Map[_, _ ] => m.size
    case _ => 1
  }

  def yuanzu (expr:Any): Any =expr match{
    case (a,b,c) =>  ("matched " + a + b +c)
    case _ =>
  }
  def xulie2(x:Any):Any = x match{
    case List(0,_*)=> "start with 0."
    case _ =>
  }
  def xulie(x:Any):Any = x match{
    case List(_,_,_)=> "found it"
    case _ =>
  }
  def gouzaoqi(expr:Expr):String = expr match {
    case BinOp("+", e, Number(0)) => "a deep match"
    case _ => "Not a BinOp"
  }

  def changliang2(expr:Any):String ={
    val Pi = Math.PI
    val s: String = expr match {
      case Pi => "strang match? pi=" + Pi
      case _ => "ok"
    }
    s
  }
  def biangliang(expr:Any) :String=expr match {
    case 0=>"zero"
    case somethingElse => "not zero: " + expr
  }
  def changliang(x:Any): String = {
    val res: String = x match {
      case 5 => "five"
      case true => "truth"
      case "hello" => "hi!"
      case Nil => "the empty list"
      case _ => "someting else"
    }
    res
  }
  def tongpei(expr:Expr): Unit = {
    val Unit1: Unit = expr match {
      case BinOp(op, left, right) => println(expr + "is a binary operation"); println(op); println(left); println(right)
      case _ => ()
    }
    println("ｒｅｓｕｌｔ：" +Unit1)
  }
  def simplyTop(expr:Expr):Expr = {
    expr match {
      case UpOp("-", UpOp("-", e)) => e
      case BinOp("+", e, Number(0)) => e
      case BinOp("*" , e, Number(1)) => e
      case _ => expr
    }
  }
}

