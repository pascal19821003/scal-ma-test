package shiqi.s

/**
  * Created by Pascal on 2016/11/27.
  */
object Testshiq {
def main(args:Array[String]): Unit ={
  //iterator
  val l:List[Int] = List(1,2,3,4,5)
  val ints: Iterator[Int] = l.iterator
  while(ints.hasNext){
    println(ints.next())
  }

  //seq->list
  val colors = List("red", "blue", "green")
  println(colors.head)
  println(colors.tail)

  //seq->array
  val fiveInts:Array[Int] = new Array(5)
  println(fiveInts.mkString(","))
  val fiveToOne = Array(5,4,3,2,1)
  fiveInts(0) = fiveToOne(4)
  println(fiveInts.mkString(","))

  //seq->listbuffer
  import scala.collection.mutable.ListBuffer
  val buf = new ListBuffer[Int]
  buf += 1
  buf += 2
  println(buf)
  val toList: List[Int] = buf.toList
  println("toList:"+toList)

  //seq-> ArrayBuffer
  import scala.collection.mutable.ArrayBuffer
  var bufArr = new ArrayBuffer[Int]
  bufArr += 12
  bufArr += 15
  println(bufArr)
  println(bufArr.length)
  println(bufArr(0))

  //seq -> queue
//  import scala.collection.immutable.Queue
//  val empty = Queue.empty[Int]
//  val has1 = empty.enqueue(1)
//  val has123 = has1.enqueue(List(2,3))
//  val dequeue: (Int, Queue[Int]) = has123.dequeue
//  val _1: Int = dequeue._1
//  val _2: Queue[Int] = dequeue._2
//  println(_1)
//  println(_2)

  import scala.collection.mutable.Queue
  var queue :Queue[String] = Queue.empty[String ]
  queue += "a"
  queue ++= List("b", "c")
  println(queue)
  println(queue.dequeue)
  println(queue)

  //seq->Stack
  import scala.collection.mutable.Stack
  val stack:Stack[Int] = new Stack[Int]
  stack.push(1)
  stack.push(2)
  stack.push(3)
  println(stack)
  println(stack.pop())
  println(stack)

  //seq->RichString
  def hasUpperCase(s:String) = s.exists(_.isUpper)
  println(hasUpperCase("Robert Frost"))
  println(hasUpperCase("e e cummings"))
}
}
