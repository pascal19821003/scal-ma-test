package shijiu

import com.sun.glass.ui.Application
import shijiu.libian.Publication

/**
  * Created by Pascal on 2016/10/13.
  */
object ShijiuMain {
  def doesNotCompile(q:Queue[Any]): Unit ={
    println(q)
  }
  def main(args:Array[String]): Unit ={
    println(1);
    val o :Apple =  new Apple("f");
    val p : Queue.QueueImpl[Any]=  Queue("sss","AAA");
    doesNotCompile(p);
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

//    def getTitle(p:Publication):String = p.title
//    Library.printBookList(getTitle)

//    val f1 : Fruit = new Fruit("f1");
//    val f2 : Fruit = new Fruit("f2");
//    val apple :Apple = new Apple("apple");
//    val q  = Queue2(f1,f2);
//    val q2=q.append(apple)
//    println(q2.toString)
//
//    val q3 = Queue2(apple)
//    val q4 = q3.append(f1)
//    println(q4)
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
  val books:Set[libian.Book] =
    Set(
      new libian.Book("Programming in Scala"),
      new libian.Book("Walden")
    )
  def printBookList(info:libian.Book=>AnyRef): Unit ={
    for(book<-books)println(info(book))
  }
}

