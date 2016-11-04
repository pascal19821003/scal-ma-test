package ershi

/**
  * Created by Pascal on 2016/10/24.
  */
trait RationalTrait {
  val numerArg :Int
  val denomArg : Int
  require(denomArg!=0)

  private val g = gcd(numerArg, denomArg)

  val numer = numerArg/g
  val denom = denomArg/g

  private def gcd(a:Int, b:Int) :Int =
    if(b==0)a else gcd(b, a%b)

  override def toString = numer + "/"+ denom


}

object twoThirds extends  {
  val numerArg = 2
  val denomArg = 3
}with RationalTrait

object Demo{
  lazy val x = {println("initializing x"); "done"}
}


trait LazyRationalTrait{
  val numerArg:Int
  val denomArg :Int
  lazy val numer = numerArg /g
  lazy val denom = denomArg/g

  private lazy val g ={
    require(denomArg!=0)
    gcd(numerArg,denomArg )
  }

  private def gcd (a:Int, b:Int) :Int ={
    if(b==0) a else gcd(b, a%b)
  }
  override def toString = numer +"/"+denom



}
object Test{
  def main(args:Array[String]): Unit ={
    val x = 3
    val v =  new  {
      val numerArg = 1 * x
      val denomArg = 2 * x
    } with RationalTrait

    println(v.denomArg)
    println(v.numerArg)

    println(twoThirds.numerArg)
    println(twoThirds.denomArg)

    println(Demo)
    println(Demo.x)
    println(Demo.x)

    val rationalTrait = new LazyRationalTrait {
      override val denomArg: Int = 2* x
      override val numerArg: Int = 1 * x
    }
    println(rationalTrait.denom)
    println(rationalTrait)
  }
}

