package shijiu.duixiangsiyoushuju



/**
  * Created by Pascal on 2016/10/22.
  */
class Queue[+T]   (private [this]  var leading :List[T],
                         private [this] var trailing:List[T]) {
  private def mirror()=
    if(leading.isEmpty){
      while(!trailing.isEmpty){
        leading = trailing.head::leading
        trailing = trailing.tail
      }
    }

  def head : T ={
    mirror()
    leading.head
  }

  def tail :Queue[T] = {
    mirror()
    new Queue(leading.tail, trailing)
  }

  def append[U>:T] (x:U) = new Queue[U](leading, x::trailing)

  override def toString:String= {
    val list: List[Any] = leading:::trailing.reverse
    val strings: List[String] = for(l<-list) yield String.valueOf(l)
    strings.mkString(",")
  }
}

object TestM{
  def main(args:Array[String]):Unit = {
    val l1 = List(1,2,3)
    val l2 = List(4,5)
    val q : Queue[Int] = new Queue[Int](l1,l2.reverse);
    println(q.head)
    println(q.tail)

    println(q.append(10))
  }
}
