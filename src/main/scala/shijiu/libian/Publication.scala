package shijiu.libian

/**
  * Created by Pascal on 2016/10/22.
  */
class Publication(val title: String)

class Book(title: String) extends Publication(title)

object Library {
  val books: Set[Book] = Set(
    new Book("scala"), new Book("java")
  )

  def printBookList(info: Book => AnyRef) {
    //books.foreach(info)
    for (book <- books) {
      val info1: AnyRef = info(book)
      println(info1)
    }

  }

}

object Customer   {
  def getTitle(p: Publication):String = {
    p.title
  }
  def main(args:Array[String]):Unit = {
    Library.printBookList(getTitle)
  }
}
