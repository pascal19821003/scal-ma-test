package sanshi

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, PoisonPill, Props}

/**
  * Created by Pascal on 2016/11/13.
  */
object Example_12 {
  def main(args:Array[String ]): Unit ={
    val system = ActorSystem("MyActorSystem")
    val systemLog = system.log

    val firstActor = system.actorOf(Props[FirstActor], name="firstActor")

    systemLog.info("send message to firstActor")
    firstActor!"test"
    firstActor!123
    firstActor!"stop"
  }

  class MyActor extends  Actor with ActorLogging{
    override def receive: Receive = {
      case "test" => log.info("received test")
      case _ => log.info("received unkown message")
    }

    override def postStop(): Unit ={
      log.info("postStop in MyActor")
    }
  }
  class FirstActor extends Actor with ActorLogging{
    var child : ActorRef = context.actorOf(Props[MyActor], name="myActor")

    override def receive: Receive = {
      case "stop" => child!PoisonPill
      case x=>{
        child!x
        log.info("received "+ x)
      }
    }

    override def postStop(): Unit ={
      log.info("postStop in FirstActor")
    }
  }

}




