package shijiu

/**
  * Created by Pascal on 2016/10/22.
  */
class StrangeIntQueue(private val leading : List[Int],
                      private val trailing : List[Int])  extends QueueQ[Int](leading , trailing){


   def append(x:Int):QueueQ[Int]  = {
    print(Math.sqrt(x))
    super.append(x)
  }


}

object StrangeIntQueue{
  def main(args:Array[String]):Unit = {
    val l1 = List(1,2)
    val l2 = List(3,4)
    val queue: StrangeIntQueue = new StrangeIntQueue(l1,l2)
    val q : QueueQ[Any] = queue
    q.append("abc")
    println(q)
  }
}


class QueueQ[+T]
(private val leading : List[T],
 private val trailing : List[T]) {


  private def mirror =
    if (leading.isEmpty)
      new QueueQ(trailing.reverse, Nil)
    else
      this

  def head = mirror.leading.head

  def tail = {
    val q = mirror
    new QueueQ(q.leading.tail, q.trailing)
  }

  def append[U>:T](x: U): QueueQ[U] = {
    new QueueQ(leading, x :: trailing)
  }


  override def toString: String = {
    (leading ::: this.trailing).mkString("[", ",", "]")
  }
}



