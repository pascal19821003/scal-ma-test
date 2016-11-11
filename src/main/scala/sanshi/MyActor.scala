package sanshi

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import akka.actor.Actor.Receive
import akka.event.Logging

/**
  * Created by Pascal on 2016/11/9.
  */
class MyActor  extends Actor with ActorLogging {
  //val log = Logging(context.system, this)

  override def receive: Receive = {
    case "test" => log.info("received test")
    case _ =>log.info("received unknown message")
  }

}

object Example_01 {
  def main(args:Array[String]): Unit ={
    val system = ActorSystem("myactorsystem")
    val systemLog = system.log
    val myactor = system.actorOf(Props[MyActor], name="myactor");

    systemLog.info("begin to send message to myactor")
    myactor!"test"
    myactor!123
    system.shutdown()
  }
}
