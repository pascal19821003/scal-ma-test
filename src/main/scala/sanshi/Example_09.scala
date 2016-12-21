package sanshi

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

/**
  * Created by Pascal on 2016/11/13.
  */
object Example_09 {

  def main(args:Array[String]): Unit ={
    val system = ActorSystem("MyActorSystem")
    val systemLog = system.log

    val firstActor = system.actorOf(Props[FirstActor], name="firstActor")

    val firstActorPath = system.child("firstActor").child("myActor")
    systemLog.info("firstActorPath-->{}" , firstActorPath)

    val myActor1 = system.actorSelection(firstActorPath)
    val myActor2 = system.actorSelection("/user/firstActor/myActor")
    val myActor3 = system.actorSelection("user/firstActor/myActor")

    systemLog.info("start send data to myactor")

    myActor2!"test"

    Thread.sleep(2000)
    system.shutdown()
  }

  class MyActor extends  Actor with ActorLogging{
    override def receive: Receive = {
      case "test" => log.info("received test")
      case _ => log.info("received unknown message")
    }
  }

  class FirstActor extends Actor with ActorLogging{
    var child:ActorRef = _

    override def preStart(): Unit ={
      log.info("preStart() in FirstActor")
      child = context.actorOf(Props[MyActor], name="myActor")
    }
    override def receive: Receive = {
      case x => child !x; log.info("received "+x )
    }
  }


}
