package sanshi

import akka.actor.{Actor, ActorSystem, Props}
import akka.actor.Actor.Receive
import akka.event.Logging
import akka.util.Timeout
import akka.pattern.ask
import akka.pattern.pipe

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by Pascal on 2016/11/13.
  *
  * 代码中定义了3种类型的消息，
  * 分别是个人基础信息case class BasicInfo(id:Int,val name:String, age:Int)、
  * 个人兴趣信息case class InterestInfo(id:Int,val interest:String)
  * 以及完整个人信息case class Person(basicInfo: BasicInfo,interestInfo: InterestInfo)，
  * 然后为这3种类型的消息定义了相应的Actor即BasicInfoActor、InterestInfoActor和PersonActor，
  * 在CombineActor分别创建相应Actor的实例，
  * receive方法中使用ask向BasicInfoActor、InterestInfoActor发送Send-And-Receive-Future模型消息，
  * BasicInfoActor、InterestInfoActor中的receive方法接收到发送来的Int类型消息并分别使用!向CombineActor发送BasicInfo、InterestInfo消息，
  * 将结果保存在Future[Person]中，然后通过代码pipe(combineResult).to(personActor)将结果发送给PersonActor。
  */
object Example13 {

  case class BasicInfo(id:Int, val name:String, age:Int)
  case class InterestInfo(id:Int, val interest:String)
  case class Person(basicInfo:BasicInfo, interestInfo: InterestInfo)

  class BasicInfoActor extends  Actor {
    val log = Logging(context.system, this)

    override def receive: Receive = {
      case id:Int => log.info("id"+id) ; sender!new BasicInfo(id, "John", 19)
      case _ => log.info("received unknown message")
    }
  }
  class InterestInfoActor extends Actor {
    val log = Logging(context.system,this)

    override def receive: Receive = {
      case id :Int => log.info("id" + id) ; sender!new InterestInfo(id, "football")
      case _ => log.info("received unknown message")
    }
  }
  class PersonActor extends  Actor{
    val log = Logging(context.system, this)

    override def receive: Receive = {
      case person:Person => log.info("Person=" + person)
      case _ => log.info("received unknown message")
    }
  }
  class CombineActor extends Actor{
    implicit  val timeout = Timeout (5 seconds)
    val basicInfoActor = context.actorOf(Props[BasicInfoActor], name="BasicInfoActor")
    val interestInfoActor = context.actorOf(Props[InterestInfoActor], name="InterestInfoActor")
    val personActor = context.actorOf(Props[PersonActor], name="PersonActor")

    override def receive: Receive = {
      case id:Int =>
        {
//          val basicInfo: Future[BasicInfo] = ask(basicInfoActor, id).mapTo[BasicInfo]
//          val interestInfo: Future[InterestInfo] = ask (interestInfoActor, id).mapTo[InterestInfo]
//          val eventualPerson: Future[Person] = for(b <- basicInfo;i <- interestInfo) yield Person(b, i)
          val combineResult : Future[Person]=
            for{
              basicInfo <- ask(basicInfoActor, id).mapTo[BasicInfo]
              interestInfo <- ask (interestInfoActor, id).mapTo[InterestInfo]
            } yield Person(basicInfo, interestInfo)

          pipe(combineResult).to(personActor)
        }

    }
  }

  def main(args:Array[String]): Unit ={
    val _system= ActorSystem("Send-Receive-Future")
    val combineActor=_system.actorOf(Props[CombineActor], name="CombineActor")
    combineActor ! 12345
    Thread.sleep(3000)
    _system.shutdown()
  }
}
