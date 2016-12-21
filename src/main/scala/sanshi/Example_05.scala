package sanshi

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

/**
  * Created by Pascal on 2016/11/11.
  */
object Example_05 {

  def main(args:Array[String]): Unit ={
    val system = ActorSystem("MyActorSystem")
    val systemLog = system.log

    //
    val myactor = system.actorOf(Props[FirstActor], name="firstActor")

    systemLog.info("start to send data to myactor")
    myactor!"test"
    myactor!124
    Thread.sleep(5000)


    system.shutdown()

  }
  class FirstActor extends  Actor with ActorLogging{
    var child:ActorRef = _

    override def preStart(): Unit = {
      log.info("preStart() in FirstAcotr")

      child = context.actorOf(Props[MyActor],name="myChild")
    }
    override def receive: Receive = {
      case x => child ! x; log.info("received "+ x)
    }

    override def postStop(): Unit ={
      log.info("postStop in FirstActor")
    }
  }

  class MyActor extends Actor with ActorLogging{
      self ! "message rom self reference"
//    override def preStart(): Unit ={
//      log.info("preStart() in MyActor")
//    }
    override def receive: Receive = {
      case "test" => log.info("received test");sender()!"message from myActor"
      case "message rom self reference" => log.info("message rom self reference")
      case _ => log.info("received unknown message")
    }

//    override def postStop(): Unit ={
//      log.info("postStop in MyActor")
//    }
  }
}
