package sanshi

import akka.actor.{ActorSystem, TypedActor, TypedProps}
import akka.event.Logging

import scala.concurrent.{Await, Future, Promise}

import scala.concurrent.duration._

/**
  * Created by Pascal on 2016/11/13.
  */
object Example_011 {

  def main(args:Array[String]) ={
    val system = ActorSystem("TypedActorSystem")

    val log = Logging(system, this.getClass)

    val mySquarer:Squarer = TypedActor(system).typedActorOf(TypedProps[SquareImpl](),"mySquarer")

    val otherSquarer :Squarer =
      TypedActor(system).typedActorOf(TypedProps(classOf[Squarer], new SquareImpl("SquarerImpl")), "otherSquarer")

    mySquarer.squareDontCare(10)

    val oSquare = mySquarer.squareNowPlease(10)
    log.info("oSquare=" + oSquare)

    val iSquare = mySquarer.squareNow(10)
    log.info("iSquare="+iSquare)

    val fSquare = mySquarer.square(10)
    val result = Await.ready(fSquare, 5 second)
    log.info("fSquare="+ result)

    system.shutdown()
  }

  trait Squarer{
    def squareDontCare(i:Int) :Unit
    def square(i:Int) :Future[Int]
    def squareNowPlease(i:Int) :Option[Int]
    def squareNow(i:Int) : Int
  }

  class SquareImpl(val name:String) extends Squarer{
    def this() = this("SquarerImpl")

    override def squareDontCare(i: Int): Unit = i*i

    override def square(i: Int): Future[Int] = Promise.successful(i*i).future

    override def squareNowPlease(i: Int): Option[Int] = Some(i * i)

    override def squareNow(i: Int): Int = i*i
  }
}
