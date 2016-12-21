package sanshi

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

/**
  * Created by Pascal on 2016/11/13.
  */
object Example_10 {

  def main(args:Array[String]): Unit ={
    val system = ActorSystem("MyActorSys")
    val firstActor = system.actorOf(Props[FirstActor], name="firstActor")

    system.log.info("start send to firstactor")
    firstActor!"test"
    firstActor!123
    system.shutdown()
  }
  class MyActor extends  Actor with ActorLogging {
    override def receive: Receive = {
      case "test" => log.info("received test")
      case _ => log.info("received unknown message")
    }
    override def postStop(): Unit ={
      log.info("postStop in MyActor")
    }
  }

  class   FirstActor extends Actor with ActorLogging{
    var child:ActorRef = context.actorOf(Props[MyActor],name="myActor")

    override def receive: Receive = {
      case x=> child!x ; log.info("received "+ x)
    }

    override def postStop(): Unit = {
      log.info("postStop in FirstActor")
    }

  }
}
