package shier.s

/**
  * Created by Pascal on 2016/11/20.
  */
trait Philosophical {
  def philosophize: Unit ={
    println("I consume memory, therefore I am!")
  }
}

class Animal

trait HasLegs


class Frog extends Animal with  Philosophical with HasLegs {
  override def toString: String = "green"

  override def philosophize: Unit = println("It ain't easy being " + toString + "!")
}

object T{
  def main(args:Array[String]): Unit ={
    val frog:Frog = new Frog
    println(frog)
    frog.philosophize
  }
}
