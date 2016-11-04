package ershisan

/**
  * Created by Pascal on 2016/10/31.
  */
case class Person(name:String, isMale:Boolean, children:Person*)

case class Book(title:String, authors:String*)


object Test{
  def main(args:Array[String]): Unit ={



    val lara =   Person("Lara", false)
    val bob =Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)

    //
    val map: List[(String, String)] = persons.filter( p=> !p.isMale).flatMap(p=>(p.children map(c=>(p.name, c.name))))
    map.foreach(p=>println(p._1 + " "+ p._2))

    val tuples: List[(String, String)] = for(p<-persons; if !p.isMale; c <- p.children ) yield  (p.name, c.name)
    tuples.foreach(t=>println(t._1 +" " + t._2))


    //
    val strings: List[String] = for {
      p <- persons
      n = p.name
      if (n.startsWith("Bo"))
    } yield n
    strings.foreach(println(_))

    //
    val tuples1: List[(Int, String)] = for (x <- List(1, 2); y <- List("one", "two"))
      yield (x, y)
    tuples1.foreach(p =>{
      println(p._1 + " " + p._2)
    })

    /////////////////
   val books = List(
      Book("b1","au1")
      ,
      Book("b2", "au2", "au3")
      ,
      Book("b3", "au5")
      ,
      Book("b4", "au1", "au4")
    )

    val strings1: List[String] = for(b <- books; a <- b.authors; if a.startsWith("au3"))yield b.title
    strings1.foreach(println)

    val strings2: List[String] = for (b1 <- books; b2 <- books if b1 != b2;
                                      a1 <- b1.authors; a2 <- b2.authors if a1 == a2
    ) yield a1
    //strings2.foreach(println(_))

    val duplicates: List[String] = removeDuplicates(strings2)
    duplicates.foreach(println)

  }

  def removeDuplicates[A](xs:List[A]):List[A]={
    if (xs .isEmpty) xs
    else
      xs.head :: removeDuplicates(
        xs.tail filter (x => x != xs.head)
      )
  }


}
