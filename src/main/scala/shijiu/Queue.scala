package shijiu

trait Queue[+T] {
  def head:T
  def tail:Queue[T]
  def append[ U >: T](x:U):Queue[U]
//  def append(x:T):Queue[T]
}

object Queue{
  def apply[T](xs:T*) = new QueueImpl[T](xs.toList, Nil)

//  def main(args:Array[String]): Unit ={
//   // println(1)
//    val queue: Queue[Int] = Queue(1,2,3)
//    val append: Queue[Int] = queue.append(4)
//    println(append)
//    println(queue.head)
//    println(queue.tail)
//  }
  /**
    * Created by Pascal on 2016/10/13.
    */
  class QueueImpl[+T](private val leading : List[T], private val trailing : List[T]) extends Queue[T]{
    //  def this() = this(Nil, Nil)
    //
    //  def this(elems:T*) = this(elems.toList, Nil)

    private def mirror =
      if(leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else
        this

    def head = mirror.leading.head

    def tail = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }

    def append[ U >: T](x:U):Queue[U] = {
      new QueueImpl(leading, x::trailing)
    }


    override def toString: String = {
      (leading ::: this.trailing).mkString("[",",","]")
    }

  }

}