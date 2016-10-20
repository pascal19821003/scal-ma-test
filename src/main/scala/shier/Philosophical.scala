package shier

/**
  * Created by Pascal on 2016/10/8.
  */
trait Philosophical {
  def philosophize(): Unit ={
    println("I consume memory, therefore I am!")
  }
}

class Animal

trait HasLegs

class Frog extends Animal with Philosophical with HasLegs{
  override def toString = "green"

  override def philosophize(): Unit ={
    println("It ain't easy being " + toString +"!")
  }
}

class Point(val x:Int, val y:Int)
trait Rectangular{
  def topLeft :Point
  def bottomRight:Point

  def left = topLeft.x
  def right = bottomRight.x

  def width = right - left
}

class Rectangle (val topLeft:Point, val bottomRight:Point) extends Rectangular{

}

abstract class IntQueue{
  def get():Int
  def put(x:Int)
}

trait Doubling extends IntQueue{
  abstract override def put(x:Int){super.put(x*2)}
}

trait Incrementing extends IntQueue{
  abstract  override def put(x:Int) {super.put(x + 1)}
}

trait Filtering extends IntQueue{
  abstract override def put(x:Int):Unit = {
    if(x>=0) super.put(x)
  }
}

import scala.collection.mutable.ArrayBuffer
class BasicIntQueue extends IntQueue{
  private val buf = new ArrayBuffer[Int]
  def get()  = buf.remove(0)
  def put (x:Int): Unit = {
    buf += x
  }
}

object ShierTest{
  def main(args:Array[String]): Unit ={
//    val frog = new Frog
//    println(frog)
//    frog.philosophize()
    //////////////////////
//    val rect = new Rectangle(new Point(1,1), new Point(3,2))
//    println(rect.left)
//    println(rect.width)

///////////////////
    val queue = new BasicIntQueue  with Filtering with Incrementing

    queue.put(-1)
    queue.put(0)
    queue.put(1)
    println(queue.get())
    println(queue.get())
  }
}
