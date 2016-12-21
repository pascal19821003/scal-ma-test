package sanshi

import akka.actor.{ActorSystem, TypedActor, TypedProps}
import akka.actor.TypedActor.{PostStop, PreStart}
import akka.event.Logging

import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.duration._
/**
  * Created by Pascal on 2016/11/13.
  */
object Example_13 {
  def main(args:Array[String]): Unit ={
    val system = ActorSystem("TypedActorSystem")
    val log = Logging(system, this.getClass)

    val mySquare:Squarer =
      TypedActor(system).typedActorOf(TypedProps[SquareImpl](), "mySquarer")

    val otherSquare :Squarer =
      TypedActor(system).typedActorOf(TypedProps(classOf[Squarer],
        new SquareImpl("SquarerImpl")), "otherSquarer")

    val fSquare = mySquare.square(10)
    val result = Await.result(fSquare, 5 second)
    log.info("fSquare="+result)

    TypedActor(system).poisonPill(otherSquare)

    TypedActor(system).stop(mySquare)
  }

  trait Squarer{
    //fire-and-forget消息
    def squareDontCare(i:Int) :Unit
    //非阻塞send-request-reply消息
    def square(i:Int) :Future[Int]
    //阻塞send-request-reply消息
    def squareNowPlease(i :Int) :Option[Int]
    //阻塞send-request-reply消息
    def squareNow(i:Int) :Int
  }
   class SquareImpl(val name:String ) extends  Squarer with PostStop
  with PreStart{

     import TypedActor.context
     val log = Logging(context.system, TypedActor.self.getClass)
     def this() = this("SquarerImpl")

     //fire-and-forget消息
     override def squareDontCare(i: Int): Unit = i*i

     //非阻塞send-request-reply消息
     override def square(i: Int): Future[Int] = Promise.successful(i*i).future

     //阻塞send-request-reply消息
     override def squareNowPlease(i: Int): Option[Int] = Some(i*i)

     //阻塞send-request-reply消息
     override def squareNow(i: Int): Int = i*i

     override def postStop(): Unit = {
       log.info("TypedActor Stopped")
     }

     override def preStart(): Unit = {
       log.info("TypedActor started")
     }
   }
}
