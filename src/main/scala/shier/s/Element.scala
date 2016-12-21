package shier.s


/**
  * Created by Pascal on 2016/11/21.
  */
import Element.ele
abstract class Element {
  def contents:Array[String]
  def height:Int = contents.length
  def width :Int = if(height ==0)0 else contents(0).length

  def above(that:Element) :Element ={
    Element.ele(this.contents ++ that.contents)
  }

  def beside(that:Element) : Element = {
     Element.ele(for( (line1, line2) <- this.contents.zip(that.contents)) yield  line1 + line2 )
  }

  def widen(w:Int) : Element={
    if(w<this.width)this
    else{
      val l = (w - this.width)/2
      val r = w - this.width
      val le = ele('*', l, 1)
      val re = ele('*', r, 1)
      le beside this beside re
    }
  }

  def heighten ( h:Int) :Element = {
    if(h<this.height)return this
    else{
      val t = (h - this.height)/2
      val b = h - this.height - t
      val te = ele('*', this.width, t)
      val be = ele('*', this.width, b)
      te above this above be
    }
  }
  override def toString = {
    contents.mkString("\n")
  }
}

object Element{

  private class ArrayElement(val contents:Array[String]) extends Element

  private class LineElement (val s:String) extends Element{
    override val contents:Array[String] = Array(s)
    override  def width = s.length
    override  def height = 1
  }

  private class UniformElement(ch : Char, override  val width : Int, override  val height:Int)
    extends  Element{
    private val line = ch.toString * width

    override def contents: Array[String] ={
      val a = for(i <- 1 to height) yield line
      a.toArray
    }
  }

  def ele(contents:Array[String]):Element ={
    new ArrayElement(contents)
  }

  def ele(ch:Char, width:Int, height:Int) :Element = {
    new UniformElement(ch, width, height)
  }

  def ele(line:String):Element={
    new     LineElement(line)
  }
}

//class ArrayElement(conts : Array[String]) extends Element{
//  val contents : Array[String] = conts;
//}


object TestAbc{
  def main(args:Array[String]): Unit ={
    val ae = Element.ele(Array("hello", "world"))
    println(ae.width)

    val triger = new Triger(true, 11);
    println(triger.age)
    triger.age = 10
    println(triger.age)

    println(triger.dangerous)

    val le = Element.ele("abba");
    println(le.height)
    println(le.width)

    val ue = Element.ele('a', 10, 5);
    ue.contents.foreach(println)

    val a1 = Array(1,3,3);
    val a2 = Array(2,2,2)
    val a3 = a1++a2
    a3.foreach(println)

    val a4: Array[(Int, Int)] = a1.zip(a2)
    a4.foreach(t=>{
      println("("+t._1+" "+t._2+")")
    })

    val aa1 = (Element.ele(Array("hello")) widen 6 ) above Element.ele(Array("world!"))
    println(aa1)

    val aa2 = Element.ele(Array("one","two")) beside( (Element.ele(Array("one") )) heighten 2 )
    println(aa2)
  }
}
class Cat11(
  val dangerous :Boolean = false

           )

class Triger (
override val dangerous:Boolean,
   var age:Int
             )extends Cat11