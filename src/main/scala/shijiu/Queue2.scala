package shijiu

trait Queue2[+T] {
  def head:T
  def tail:Queue2[T]
  def append[ U >: T](x:U):Queue2[U]
}

object Queue2{
  def apply[T](xs:T*) = new Queue2Impl[T](xs.toList, Nil)

  /**
    * Created by Pascal on 2016/10/13.
    */
  class Queue2Impl[+T](private[this] var leading : List[T], private[this] var trailing : List[T]) extends Queue2[T] {

    private def mirror =
      if (leading.isEmpty)
        while (!trailing.isEmpty) {
          leading = trailing.head :: leading
          trailing = trailing.tail
        }



    def head : T =  {
      mirror
      leading.head
    }

    def tail: Queue2[T] = {
      mirror
      new Queue2Impl(leading.tail, trailing)
    }

    def append[ U >: T](x:U):Queue2[U] = {
      new Queue2Impl(leading, x::trailing)
    }

    override def toString: String = {
      (leading ::: this.trailing).mkString("[",",","]")
    }

  }

}