package shiliu

import scala.collection.immutable.IndexedSeq

object Main {

  def test7={
    println(List.apply(1,2,3))
    val tuples: List[(Char, Int)] = "abcde".toList zip List(1,3,4)
    println(tuples)
    val unzip: (List[Char], List[Int]) = tuples.unzip
    println(unzip)

    //////////////
    val xss = List(
      List('a', 'b'),List('c'), List('d','e')
    )

    println(List.concat( List('a', 'b'),List('c'), List('d','e')))



  }

  def test6 = {
    val ints: List[Int] = List(1, 2, 3) map (_ + 1)
    ints.foreach(println)

    ////////////////
    val words: List[String] = List("the", "quick", "brown", "fox")
    val lengthL: List[Int] = words.map(_.length)
    println(lengthL)

    ///////////////
    words.map((x) => {
      val v = x.toList.reverse
      v.mkString
    }).foreach(x => println(x))

    ///////////////
    println(words.flatMap(_.toList))

    ////////////
    val map = List.range(1, 5).flatMap(i => {
      println("flatMap:" + i)
      val range: List[Int] = List.range(1, i)
      println(range)
      val map1: List[(Int, Int)] = range.map(j => (i, j))
      println(map1)
      map1
    })
    println(map)

    ////////////
    println(List(1, 2, 3, 4, 5) filter (_ % 2 == 0))
    def f(x: Int): Boolean = {
      x % 2 == 0
    }

    def f2 = (x: Int) => {
      x % 2 == 0
    }
    println(f2(10))
    val vv: List[Int] = List(1, 2, 3, 4, 5).filter(_ % 2 == 0)
    println(vv)

    println(List(1, 2, 3, 4, 5).partition((x) => x % 2 == 0))

    ////////////////
    val value: Any = List(1, 2, 3, 4, 5).find(_ > 3) match {
      case Some(x) => x
      case None => "?"
    }
    println(value)

    /////////////
    println(List(1,2,3,-4,5) takeWhile(_>0))
    println(List(1,2,3,-4,5) dropWhile(_>0))
    println(List(1,2,3,-4,5) span(_>0))

    ////////////////
    def hasZeroRow(m:List[List[Int]]) =
    m exists(_ forall (_==0))


    val diag3 = (1 :: (0 :: (0 :: Nil))) ::
      (0 :: (1 :: (0 :: Nil))) ::
      (0 :: (0 :: (1 :: Nil))) ::
      (0 :: (0 :: (0 :: Nil))) ::Nil

    println(hasZeroRow(diag3))

    ///////////
    def sum(xs:List[Int] ) :Int = (0 /: xs)(_ + _)
    println(sum(List(1,2,3,4)))

    def product(xs:List[Int]):Int = (1 /: xs)(_ * _)
    println(product(List(1,2,3,4)))

    val s: String = (words.head /: words.tail) (_ + " " + _)
    println(s)

    def reverseLeft[T] (xs:List[T]) =
      (List[T]() /: xs){
        (ts,t)=>t::ts
      }

    println(reverseLeft(List(1,3,5,4)))

    println(List(1,3,5,4).sortWith((x,y)=>x<y))
  }

  def test5 = {
    val abcde: List[Char] = List('a', 'b', 'c', 'd', 'e')

    println(abcde.take(2))
    println(abcde.drop(2))
    println(abcde.splitAt(2))

    println(abcde.indices)
    println(abcde.apply(2))
    println(abcde(2))
    println(abcde.drop(2).head)

    println()
    ///////////////////////
    val tuples: IndexedSeq[(Int, Char)] = abcde.indices zip abcde
    tuples.foreach((x) => println(x._1 + "," + x._2))
    println()
    /////////////////
    println(abcde.mkString("[", ",", "]"))

    println()
    /////////////
    val arr = abcde.toArray
    arr.foreach(println)

    println(arr.toString)
    println(arr.toList)

    var arr2 = new Array[Int](10)
    List(1, 2, 3) copyToArray(arr2, 3)
    arr2.foreach(println)

    val chars: Iterator[Char] = abcde.iterator
    println(chars.next())
  }

  def append[T](xs: List[T], ys: List[T]): List[T] =
    xs match {
      case List() => ys
      case x :: xs1 => x :: append(xs1, ys)
    }

  def test4 = {
    val l: List[Int] = List(1, 2, 3) ::: List(4, 5)
    l.foreach(println)
  }

  def test3 = {
    //    val fruit = "apples" :: ("oranges" :: ("pears" ::("xxx":: Nil)))
    //    val a::b::rest = fruit
    //    println(a)
    //    println(b)
    //    println(rest)
    def isort(xs: List[Int]): List[Int] = xs match {
      case List() => {
        println("isort： match List()")
        List()
      }
      case x :: xs1 => {
        println("isort： match x :: xs1 x:" + x)
        insert(x, isort(xs1))
      }

    }

    def insert(x: Int, xs: List[Int]): List[Int] = xs match {
      case List() => {
        println("inser： match List()")
        x :: List()
      }
      case y :: ys => {
        if (x <= y) {
          println("inser： match y :: ys x<=y x:" + x + " y:" + y)
          x :: xs
        }
        else {
          println("inser： match y :: ys x>y x:" + x + " y:" + y)
          y :: insert(x, ys)
        }
      }

    }

    val ort: List[Int] = isort(List(9, 3, 7, 4, 8, 10, -9, 1, 0))
    println(ort)
    ort.foreach(println)

  }

  def isort(xs: List[Int]): List[Int] =
    if (xs.isEmpty) Nil
    else
      insert(xs.head, isort(xs.tail))

  def insert(x: Int, xs: List[Int]): List[Int] =
    if (xs.isEmpty) x :: xs
    else if (x <= xs.head) x :: xs.tail
    else xs.head :: insert(x, xs.tail)


  def test2 {
    val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
    val diag3 = (1 :: (0 :: (0 :: Nil))) ::
      (0 :: (1 :: (0 :: Nil))) ::
      (0 :: (0 :: (1 :: Nil))) :: Nil
    diag3.foreach(l => l.foreach(x => println(x)))

    /////////////////
    println("nums:")
    val empty = Nil
    val nums = 1 :: 2 :: 3 :: Nil
    nums.foreach(println)

    /////////////////
    println("operation:")
    println(fruit.head)
    println(fruit.tail)
    println(fruit.tail.head)
    println(fruit.isEmpty)

    println(Nil.head)
  }

  def main(args: Array[String]): Unit = {
    test7

//    test6
    //    test5
    //    append(List(1,2,3),List(4,5)).foreach(println)
    //    test4
    //    test3
    //    isort(List(9, 3, 7, 4, 8, 10, -10, 1, 0)).foreach(println)
    //    test2
    //    val fruit = List("apples", "oranges", "pears", 'a','b',1,2)
    //    fruit.foreach(println)
    //    val nums = List(1,2,3,4)
    //    val diag3 = List(
    //      List(1,0,0),
    //      List(0,"ss",0),
    //      List(0,0,1)
    //    )
    //    diag3.foreach(x=>{
    //      x.foreach(i=>print(i+" "))
    //      println("\n")
    //    })
    //
    //    val fruits2:List[String] = List("apples", "oranges", "pears")
    //    val diag2:List[List[Int]]=List(
    //      List(1,0,0),
    //      List(0,1,0),
    //      List(0,0,1)
    //    )
    //
    //    val xs:List[String] = List()
    //
    //    println(xs.isEmpty)
  }


}
