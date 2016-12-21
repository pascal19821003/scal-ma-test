package sanshi

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorLogging, ActorSystem, Props}

/**
  * Created by Pascal on 2016/11/11.
  */
object Example_06 {

  def main(args:Array[String]): Unit ={
    val system = ActorSystem("MyActorSystem")
    val systemLog = system.log
    val myactor = system.actorOf(Props[FirstActor], name="firstActor")

    systemLog.info("start send message...")
    myactor!"test"
    myactor!123
    Thread.sleep(5000)
    system.shutdown()
  }

  class FirstActor extends Actor with ActorLogging{
    override def receive: Receive = {
      case "test" => log.info("received test")
    }

    override def unhandled(message: Any): Unit = {
      log.info("unhandled message is {}", message)
    }
  }
}
