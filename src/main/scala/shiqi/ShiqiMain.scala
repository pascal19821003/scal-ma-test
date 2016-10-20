package shiqi

/**
  * Created by Pascal on 2016/10/12.
  */
object ShiqiMain {
  def longestWord(words:Array[String])={
    var word = words(0)
    var idx = 0
    for(i<-1 until words.length){
      if(words(i).length > word.length){
        word = words(i)
        idx = i
      }
    }
    (word, idx)
  }
  def main(args:Array[String])={
    longestWord("The quick brown fox aaaaaa bbb".split(" ")) match  {
      case (x, y ) => {
        println(x + " " +y )
    }
    }

    val (x,y) =  longestWord("The quick brown fox aaaaaa bbb".split(" "))
    println(x + "-->"+y)
  }
}
