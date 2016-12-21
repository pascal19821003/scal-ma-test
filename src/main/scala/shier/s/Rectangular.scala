package shier.s

/**
  * Created by Pascal on 2016/11/20.
  */
class Point(val x:Int, val  y :Int)

trait Rectangular {
  def topLeft :Point
  def bottomRight:Point

  def left = topLeft.x

  def right = bottomRight.x

  def width = right - left
}

abstract  class Component extends Rectangular{

}

class Rectangle (val topLeft :Point , val bottomRight :Point) extends Rectangular{

}

object Tt{
  def main(args:Array[String]): Unit ={
    val rect = new Rectangle(new Point(1,1), new Point(2,3))
    println(rect.left)
    println(rect.right)
    println(rect.width)
  }
}