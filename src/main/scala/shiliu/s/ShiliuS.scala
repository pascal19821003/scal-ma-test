package shiliu.s

import scala.collection.immutable.IndexedSeq

/**
  * Created by Pascal on 2016/11/25.
  */
object ShiliuS {
  def main(args:Array[String]):Unit ={
//    list
//    isSort(List(1,3,0,4,2)).foreach(println)
//    matcher
//    m1
    m2
  }

  def m2={
    val ints: List[Int] = List(1,2,3) map (_+1)
    println(ints)

    val words = List("the", "quick", "brown", "fox")
    val map: List[Int] = words.map( _.length)
    println(map)

    val map1: List[String] = words.map(_.toList.reverse.mkString)
    println(map1.reverse)

    println(    words.map(_.toList))
    println(words.flatMap(_.toList))

    println(List.range(1,5))
    val r =
      List.range(1,5).flatMap(
        i=>List.range(1,i) map(j=>(i,j))
      )

    println(r)

    val r1 = for(i<-List.range(1,5);j<-List.range(1,i)) yield(i,j)
    println(r1)

    var sum = 0
    List.range(1,6).foreach(sum += _)
    println(sum)

    println(List(1,2,3,4,5).filter(_%2==0))
    println(words.filter(x=>x.length==3))

    def p(x:Int)={
      x%2==0
    }
    println(List(1,2,3,4,5).partition(p))

    val find: Option[Int] = List(1,2,3,4,5).find(_%2==0)
    println(find)
    println(find.getOrElse("null"))

    val find1: Option[Int] = List(1,2,3).find(_<0)
    println(find1)
    println(find1.getOrElse("null"))

    val takeWhile: List[Int] = List(1,2,3,-4,5).takeWhile(_>0)
    println(takeWhile)

    val dropWhile: List[String] = words.dropWhile(_ startsWith( "t"))
    println(dropWhile)

    println(List(1,2,3,-4,5).span(_ >0 ))

    def hasZeroRow(m:List[List[Int]]) =
      m.exists(row=>row.exists(_==0))

    def hasExsitsRowOfAllZero(m:List[List[Int]]):Boolean =
      m.exists(row => {row.forall( i =>{ i==0 } )})
    val ll = List(
      List(1,2,3,4),
      List(5,6,7,9,0),
      List(10,11),
      List(0,0)



    )
    println(hasZeroRow(ll))
    println(hasExsitsRowOfAllZero(ll))


    def sumLeft(   l:List[Int]) :Int = {
      (0 /: l)(_+_)
    }
    println(sumLeft(List(1,2,3,4,5)))

    def productLeft(  l: List[Int]) :Int = {
      (1 /: l) (_*_)
    }

    println(productLeft(List(1,2,3,4,5)))

    println((" "  /: words)(_ + " " +_ ))
    println((words.head  /: words.tail)(_ + " " +_ ))

    def flattenLeft[T] (xss:List[List[T]]):List[T] =
      (List[T]() /: xss) (_ ::: _)

    println(flattenLeft(ll))

    def flattenRight[T] (xss:List[List[T]]):List[T] =
      (xss :\ List[T]()) (_ ::: _)
    println(flattenRight(ll))

    def reverseLeft[T] (xs:List[T]) = {
      (List[T]() /: xs ) {
        (ys, y) => y :: ys
      }
    }

    println(reverseLeft(List(1,2,3,4,5)))

    // List(1, -3, 4, 2, 6 ) sort (_ < _)

//    List.make(5, 'a'?)

    val zipped = "abcde".toList.zip(List(1,2,3))
    println(zipped)

    val xss = List(List('a','b'), List('c'),List('d','e'))
    val concat: List[Char] = List.concat(List('a','b'), List('c'))
    println(concat)


  }

  def m1={
//    val ints: List[Int] = List(1,2) ::: List(3,4,5)
//    ints.foreach(print)

    def append(xs:List[Int],ys:List[Int]):List[Int]={
      xs match {
        case List() => ys
        case x::xs1 => {
          println("append:" + x)
          x ::append(xs1, ys)
        }
      }
    }

    val append1: List[Int] = append(List(1,2,3), List(4,5))
    println(append1.length)

    val abcde=List('a','b','c','d','e')
    println(abcde.init)
    println(abcde.last)

    val reverse: List[Char] = abcde.reverse
    println(reverse)

    def rev[T] (xs:List[T]) :List[T] = {
      xs match {
        case List()=>xs
        case x::xs1 =>{
          println("rev:" + x )
          rev(xs1) ::: List(x)
        }
      }
    }

    val rev1: List[Int] = rev(List(1,2,3,4,5))
    rev1.foreach(print)

    val take: List[Char] = abcde.take(2)
    println(take)

    val drop: List[Char] = abcde.drop(2)
    println(drop)

    val at: (List[Char], List[Char]) = abcde.splitAt(2)
    println(at)

    //
    val apply: Char = abcde.apply(2)
    val head: Char = abcde.drop(2).head
    println(apply == head)

    abcde.indices.foreach(println)

    val tuples: IndexedSeq[(Int, Char)] = abcde.indices zip abcde
    tuples.foreach(t =>println(t._1 +" "+ t._2))

    val index: List[(Char, Int)] = abcde.zipWithIndex
    index.foreach(s=>println(s._1+" "+s._2))

    println(abcde.mkString("[",",","]"))

    val buf = new StringBuffer
//    abcde.addString(buf, "(",";",")")

    val toArray: Array[Char] = abcde.toArray
     toArray.foreach(print)
    println

    val toList: List[Char] = toArray.toList
    println(toList)

    val chars: Iterator[Char] = abcde.iterator
    chars.foreach(print)
  }

  def matcher(): Unit ={
    val fruit:List[String] = List("apples","oranges", "pears")
    val a::b::c::Nil = fruit
    println(a)
    println(b)
    println(c)

    val x::y = fruit
    println(x)
    println(y)
  }
  def isSort(xs:List[Int]): List[Int] ={
    if(xs.isEmpty)Nil
    else insert(xs.head, isSort(xs.tail))
  }
  def insert(h:Int, xs:List[Int]):List[Int] ={
      if(xs.isEmpty || h<=xs.head) h::xs
      else{
        xs.head::(h:: xs.tail)
      }
  }
  def list: Unit = {
    //    val fruit:List[String] = List("apples","oranges", "pears")
    //    val nums :List[Int] = List(1,2,3,4)
    //    val diag3 :List[List[Int]] = List(
    //      List(1,0,0),
    //      List(0,1,0),
    //      List(0,0,1)
    //    )
    val fruit: List[String] = "apples" :: ("oranges" :: ("pears" :: Nil))
    val nums: List[Int] = 1 :: (2 :: (3 :: (4 :: Nil)))
    val diag3: List[List[Int]] =
      (1 :: 0 :: 0 :: Nil) ::
        (0 :: 1 :: 0 :: Nil) ::
        (0 :: 0 :: 1 :: Nil) :: Nil

    fruit.foreach(s => println(s))
    nums.foreach(println)
    diag3.foreach(l => {
      l.foreach(print)
      println
    })
  }
}
