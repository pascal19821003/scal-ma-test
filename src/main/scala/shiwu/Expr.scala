package shiwu

/**
  * Created by Pascal on 2016/10/10.
  */
sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num:Double ) extends Expr
case class UnOp(operator:String , arg: Expr) extends Expr
case class BinOp(operator :String ,left:Expr , right:Expr) extends Expr

