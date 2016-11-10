package ershijiu

/**
  * Created by Pascal on 2016/11/8.
  */
import java.util.ArrayList;
//引入下面这条语句后便可以调用scala集合中的方法，如foreach,map等
import scala.collection.JavaConversions._
/**
  * Created by 摇摆少年梦 on 2015/8/16.
  */
object RevokeJavaCollections{
  def getList={
    val list=new ArrayList[String]()
    list.add("a1")
    list.add("a2")
    list
  }
  def main(args: Array[String]) {
    val list=getList
    //现在可以调用scala集合中的foreach等方法了
    list.foreach(println)
    val list2=list.map(x=>x*2)
    println(list2)
  }
}