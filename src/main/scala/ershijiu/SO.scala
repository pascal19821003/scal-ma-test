package ershijiu

import java.util

import scala.collection.JavaConversions._
/**
  * Created by Pascal on 2016/11/5.
  */
class SO {
  def d:java.util.List[Any] = {
    val a: List[Any] = List(1,"aa")
    val javaIterable: util.List[Any] = seqAsJavaList(a)
    javaIterable
  }
}
