package ershi

/**
  * Created by Pascal on 2016/10/24.
  */
trait Abstract {
  type  T
  def tranform(x:T) : T
  val initial:T
  val current:T


}
class Concrete extends Abstract{
  type T=String

  override def tranform(x: String): String = x + x

  override val initial: String = "hi"
  override val current: String = initial
}
