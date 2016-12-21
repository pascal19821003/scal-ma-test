package shiqi.s

import scala.collection._

/**
  * Created by Pascal on 2016/11/28.
  */
object Testshib {
  def main(args:Array[String]): Unit ={
    val text = "See Spot run. Run, Spot. Run!"
    val split: Array[String] = text.split("[ !,.]+")
    println(split.mkString(","))

    //set
    val words = mutable.Set.empty[String]
    for(word<-split){
      words += word
    }
    println(words)

    //set->method
    val nums = Set(1,2,3)
    println(nums)
    println("nums + 5:"+(nums + 5))
    println("nums - 3:"+(nums - 3))
    println("nums ++ List(5,6):"+(nums ++ List(5,6)))
    println("nums -- List(1,2):"+(nums -- List(1,2)))
    println("nums.intersect(Set(1,3,5)):" + nums.intersect(Set(1,3,5))  )
    println("nums.size:"+nums.size)
    println("nums.contains(3):  "+nums.contains(3))

    import scala.collection.mutable.Set
    val wordss = Set.empty[String]
    wordss += "the"
    println("+= words:" + wordss )
    wordss -= "the"
    println("-= words:" + wordss )
    wordss ++= Set("do, re, mi")
    println("++= words:" + wordss )
    wordss --=List("do", "re")
    println("--= words:" + wordss )
    wordss.clear
    println("words.clear words:" + wordss )

    //map
    val map: mutable.Map[String, Int] = mutable.Map.empty[String,Int]
    map("hello")=1
    map("there")=2
    println(map)
    println(map("hello"))

    def countWords(text:String)={
      var wordCount:Map[String, Int] = mutable.Map.empty[String, Int]
      for(word <-  text.split("[ |,.!]+")){
        val wordLow = word.toLowerCase
        val thisWordCount = if(wordCount.contains(wordLow)){
           wordCount(wordLow)
        }else {
          0
        }
        wordCount += (wordLow -> (thisWordCount + 1))
      }
      wordCount
    }
    println(countWords("See Spot run! Run, Spot. Run!"))

    val nums1  = Map("i"->1 , "ii"->2)
    println("nums1:"+nums1)
    println("\"vi\"->6:"+nums1 + ("vi"->6))
    println("nums1 - \"ii\":"+(nums1 - "ii"))
    println("nums1 ++ List(\"iii\"->3, \"v\"->5):"+(nums1 ++ List("iii"->3, "v"->5)))
    println("nums1 -- List(\"i\", \"ii\"):"+ ( nums1 -- List("i", "ii")))
    println("nums1.size:"+nums1.size)
    println("nums1.contains(\"ii\"):"+nums1.contains("ii"))
    println("nums1.keys:"+nums1.keys)
    println("nums1.values:"+nums1.values)
    println("nums1.isEmpty:"+nums1.isEmpty)

    import mutable.Map
    val wordd = Map.empty[String, Int]
    wordd += ("one"->1)
    println(wordd)
    wordd -= "one"
    println(wordd)
    wordd ++= List("one"->1, "two"->2, "three"->3)
    println(wordd)
    wordd --= List("one", "two")
    println(wordd)

  }
}
