package sanshi

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

/**
  * Created by Pascal on 2016/11/13.
  */
object Example_07 {

  def main(args:Array[String]): Unit ={
    val system =ActorSystem("MyActorSystem")
    val systemLog = system.log

    val myactor = system.actorOf(Props[FirstActor], name="firstActor")
    val myActorPath = system.child("firstActor")
    val myActor1 = system.actorSelection(myActorPath)
    println("myactor:" + myactor)
    println("myActor1:" + myActor1)
    systemLog.info("start send message to myactor")
    myactor!"test"
    //myActor1!123
    Thread.sleep(5000)
    system.shutdown()
  }
  class FirstActor extends Actor with ActorLogging{
    var child : ActorRef = _

    override def preStart()={
      log.info("preStart in FirstActor")
      child = context.actorOf(Props[MyActor],name="myActor")
    }
    override def receive: Receive = {
      case x=> child ! x;log.info("received "+x)
    }
  }

  class MyActor extends Actor with ActorLogging {
    var parentActorRef:ActorRef = _
    override def preStart() :Unit = {
      parentActorRef = context.parent
    }
    override def receive: Receive = {

      case "test" => log.info("received test"); parentActorRef!"message from ParentActorRef"
      case _ => log.info("received unknown message")
    }
  }
}
