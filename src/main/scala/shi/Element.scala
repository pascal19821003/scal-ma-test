package shi

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Pascal on 2016/10/8.
  */


abstract class Element {
  def contents: Array[String]

  def width : Int = if(height == 0) 0 else contents(0).length

  def height : Int = contents.length
  import Element.elem
  def above (that :Element ) :Element =   {
    val this1 = this widen that.width
    val that1 = that widen  this.width
    elem(this1.contents ++ that1.contents)
  }

  def beside(that :Element ) :Element =   {
    val this1 = this heighten that.height
    val that1 = that heighten  this.height
    elem(
      for((line1, line2)<-this1.contents zip that1.contents) yield line1+line2
    )
  }

  def widen(w:Int) :Element =
    if(w<=width) this
  else{
      val left = elem(' ', (w-width)/2, height)
      var right = elem(' ', w-width-left.width, height)
      left beside this beside right
    }

  def heighten (h:Int) :Element = if(h<=height ) this
  else {
    val top = elem(' ', width, (h-height) / 2)
    val bot = elem(' ', width, h -height - top.height)

    top above this above bot
  }

  override def toString  = contents mkString "\n"
}



object Element {
  def elem (conents :Array[String]) :Element = new ArrayElement(conents)
  def elem (chr : Char , width:Int, height:Int) :Element = new UniformElement(chr,width,height)
  def elem(line:String) :Element = new LineElement(line)

  private class ArrayElement(val contents:Array[String]) extends Element{
    //def contents:Array[String] = conts
  }

  private class LineElement(s:String) extends Element{
    val contents = Array(s)
    override def width  = s.length
    override def height = 1
  }

  private class UniformElement(ch:Char, override val width:Int, override val height:Int) extends
    Element {
    private val line = ch.toString * width
    def contents  = {
      val a = for(i<-1 to height) yield  line
      val arr = new Array[String](a.length)
      a.copyToArray(arr)
      arr
    }
  }
}
//object main{
//  def main(args:Array[String]): Unit ={
//    //val ae = new ArrayElement(Array("hello", "world"))
//    //println(ae.width)
//    val ue:Element = new elem("aaa" )
//    ue.contents
//  }
//}
