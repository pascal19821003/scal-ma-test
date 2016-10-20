package shijiu

import com.sun.glass.ui.Application

/**
  * Created by Pascal on 2016/10/13.
  */
object ShijiuMain {
  def doesNotCompile(q:Queue[AnyRef]): Unit ={
    println(q)
  }
  def main(args:Array[String]): Unit ={
    println(1);
//    val queue: Queue[Int] = Queue(1,2,3)
//    val append: Queue[Int] = queue.append(4)
//    println(append)
//    println(queue.head)
//    println(queue.tail)


//    val queue: Queue[Int] = Queue(1,2,3)
//    val q1 = queue.append(5.0)
//    val q2 = q1.append("str")
//
//    println(queue)
//    println(q1)
//    println(q2)

//    val c1 = new Cell[String]("abc")
//    val c2 :Cell[AnyRef] = c1
    //c2.set(1)

    def getTitle(p:Publication):String = p.title
    Library.printBookList(getTitle)
  }


}

class Cell[+T] (init :T) {
  private[this] var current = init
  def get = current
 // def set(x:T) {current = x}
}

class Publication(val title:String)
class Book(title:String ) extends  Publication(title)

object Library{
  val books:Set[Book] =
    Set(
      new Book("Programming in Scala"),
      new Book("Walden")
    )
  def printBookList(info:Book=>AnyRef): Unit ={
    for(book<-books)println(info(book))
  }
}

