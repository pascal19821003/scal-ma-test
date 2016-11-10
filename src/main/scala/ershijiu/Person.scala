package ershijiu

import java.util.Comparator

/**
  * Created by Pascal on 2016/11/8.
  */
case class Person(val name:String, val age:Integer)

class PersonComparator extends Comparator[Person]{
  override def compare(o1: Person, o2: Person): Int = if(o1.age> o2.age ) 1 else -1
}

object ScalaUserJavaComparator {
  def main(args:Array[String]): Unit ={
    val p1 = new Person("a1",1);
    val p2 = new Person("a2",2);
    val comparator = new PersonComparator
    val compare: Int = comparator.compare(p1, p2)
    println(compare)
  }
}
