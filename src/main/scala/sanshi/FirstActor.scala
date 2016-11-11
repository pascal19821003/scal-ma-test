package sanshi

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorLogging, ActorSystem, Props}

/**
  * Created by Pascal on 2016/11/10.
  */
class FirstActor extends Actor with ActorLogging{
  val child =  context.actorOf(Props[MyActor], name="myChild");

  override def receive: Receive = {
    case x=> child ! x ;log.info("received " + x)
  }
}

object Example_04{
  def main(args:Array[String]): Unit ={
    var system = ActorSystem("myActorSystem")
    val systemLog = system.log

    val myactor = system.actorOf(Props[FirstActor], name="firstActor")

    systemLog.info("准备向myactor发送消息")

    myactor!"test"
    myactor!123

    Thread.sleep(5000)

    system.shutdown()
  }
}
