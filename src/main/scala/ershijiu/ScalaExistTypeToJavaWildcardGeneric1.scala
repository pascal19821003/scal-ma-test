package ershijiu

import java.util.List

import j.ershijiu.JavaWildcardGeneric

import scala.collection.JavaConversions._
/**
  * Created by Pascal on 2016/11/8.
  */
class ScalaExistTypeToJavaWildcardGeneric1 {
  def printList(list:List[T] forSome {type T}): Unit ={
      list.foreach(println)
  }

  def printList2(list:List[_]): Unit ={
    list.foreach(println)
  }
}

object Main {
  def main(args:Array[String]): Unit ={
    val s = new ScalaExistTypeToJavaWildcardGeneric1
    s.printList(JavaWildcardGeneric.getList)
    s.printList2(JavaWildcardGeneric.getList)
  }
}
