package sanshi

import akka.actor.{Actor, ActorSystem, Props}
import akka.actor.Actor.Receive
import akka.event.Logging

/**
  * Created by Pascal on 2016/11/13.
  */
object Example12 {

  def main(args:Array[String]): Unit ={
    val system = ActorSystem("ActorSystem")
    val exampleActor = system.actorOf(Props[ExampleActor], name="exampleActor")
    exampleActor!Run("Running")
//    exampleActor!Start("Starting")
    system.shutdown()
  }

  case class Start(var msg:String)
  case class Run(var msg:String)
  case class Stop(var msg:String)

  class ExampleActor extends Actor{
    val other = context.actorOf(Props[OtherActor], "OtherActor")
    val log = Logging(context.system, this)

    override def receive: Receive = {
      case Start(msg ) => other! msg
      case Run(msg) => other.tell(msg, sender)
    }
  }
  class OtherActor extends Actor {
    val log = Logging(context.system, this)
    override def receive: Receive = {
      case s:String=> log.info("received message:\n"+s)
      case _ => log.info("received unknown message")
    }
  }
}
