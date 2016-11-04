package ershiyi

/**
  * Created by Pascal on 2016/10/31.
  */
class PreferredPrompt(val preference: String)

class PreferredDrink(val prefernce: String)

object Greeter {
  //  def greet(name:String)(implicit prompt:PreferredPrompt): Unit ={
  //    println("Welcome "+name +". The system is ready.")
  //    print("But while you work, ")
  //    println("why not enjoy a cup of ")
  //    println(prompt.preference)
  //  }
  def main(args: Array[String]): Unit = {
    println(maxList(List(1, 5, 10, 3)))
    println(maxList(List(1.5, 5.2, 10.7, 3.14159)))
    println(maxList(List("one", "two", "three")))
  }

  def maxListImpParm[T](elements: List[T])(implicit orderer: T => Ordered[T]): T = elements match {
    case List() => throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxListImpParm(rest)(orderer)
      if (orderer(x) > maxRest) x
      else maxRest
  }

  def maxList[T<%Ordered[T]](elements:List[T]):T= elements match{
    case List()=> throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxList(rest)
      if(x>maxRest) x
      else
        maxRest
  }

  def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink): Unit = {
    println("Welcome " + name + ". The system is ready.")
    print("But while you work, ")
    println("why not enjoy a cup of " + drink.prefernce + "?")
    println(prompt.preference)
  }


}

object JoesPrefs {
  implicit val prompt = new PreferredPrompt(("yes, master> "))
  implicit val drink = new PreferredDrink("tea")
}

//import JoesPrefs._
