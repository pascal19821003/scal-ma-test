package ba

import java.io.{File, PrintWriter}

/**
  * Created by Pascal on 2016/12/20.
  */
object HanshuCanshu {
  def filesHere = new java.io.File("D:\\home\\rdme\\usr\\local\\daolog").listFiles()

  def fileMatching(query: String, matcher: (String, String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName, query))
      yield file
  }

  def filesEnding(query: String): Array[File] = {
    fileMatching(query, _.endsWith(_))
  }

  def filesContaining(query: String): Array[File] = {
    fileMatching(query, _.contains(_))
  }

  def filesMatching(query: String): Array[File] = {
    fileMatching(query, _.matches(_))
  }

  def containsNeg(nums: List[Int]) = nums.exists((p: Int) => p < 0)

  def plainOldSum(x: Int, y: Int) = x + y

  def curriedSum(x: Int)(y: Int) = x + y

  def withPrintWriter(file: File, op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def withPrintWriter2(file: File)(op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  var asserEnable = true

  def myAssert(predicate: => Boolean) = {
    println("myAssert")
    if (predicate) {
      throw new AssertionError
    } else {
      println("ok")
    }
  }

  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  def optionrename = toInt("foo").map(i => println(i))

  def main(args: Array[String]): Unit = {
    //     println( filesMatching(".*i.*").mkString(","))
    //
    //    println(containsNeg(List(1,2,3,4)))
    //    println(containsNeg(List(1,2,-3,4)))
    //    println(containsNeg(Nil))
    //
    //    println(plainOldSum(1, 2))
    //    println(curriedSum(1)(2))
    //
    //    def first(x:Int) = (y:Int) => x + y
    //    val second = first(1)
    //    println(second(2))
    //
    //    val onePlus = curriedSum(1) _
    //    println(onePlus(2))
    //
    //    withPrintWriter(new File("d:/aa.txt"), writer => writer.println(new java.util.Date))
    //    withPrintWriter2(new File("d:/bb.txt"))(writer=>writer.println("haha"))
    //
    //    myAssert(
    //    {
    //      println("parameters")
    //      5 < 3
    //    } )
    //
    //    val x = toInt("1")
    optionrename
  }
}


object BitOpt {

  class A(val aa: String) {

    override def equals(obj: Any): Boolean = {
      println("----equals----")
      obj match {
        case b: A =>
          aa == b.aa
        case _ =>
          false
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val a = new A("1")
    val b = new A("1")
    println(a.equals(b))
    println(a == b)
    println(a eq b)
    println(a ne b)
    println(!a.eq(b))
  }
}