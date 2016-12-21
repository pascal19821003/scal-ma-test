package qi

import java.io.{FileNotFoundException, IOException}

/*
  * Created by Pascal on 2016/11/15.
  */
object Qizhang {
def main(args:Array[String]): Unit ={
  //if
    val fileName=if(!args.isEmpty)args(0)else "default.txt"
    println(fileName)

  //while
  println( gcdLoop(100,18))

  // do-while
//  var line = ""
//  do{
//    line = readLine()
//    println("read:" + line)
//  }while(line!="")

  //for
  for(i<-1 to 4)
    println(i)

  for(i<-1 until 4)
    println(i)

  for(file<-filesHere ;if file.isFile; if file.getName.endsWith("txt"))println(file)

  grep(".*cc.*")

  val forLineLengths =
    for{
      file <-filesHere;
      if(file.getName.endsWith(".txt"))
      line<-fileLines(file)
      trimed = line.trim
      if( trimed .matches(".*for.*"))
    }yield trimed.length

  forLineLengths.foreach(a=>println(a))

  // try catch
  exceptionTest

  //case
  val firstArg = "chip"

  val friend = firstArg match {
    case "salt" =>"pepper"
    case "chips" => "salsa"
    case "eggs" => "bacon"
    case _ => "huh?"
  }
  println(friend)

}



  def gcdLoop(x:Long, y:Long ):Long ={
    var a= x
    var b = y
    while(a!=0){
      val temp = a
      a = b%a
      b = temp
    }
    b
  }

  def fileLines(file:java.io.File) :scala.List[String] = {
    val lines: List[String] = scala.io.Source.fromFile(file).getLines.toList
   // lines.foreach(println)
    lines
  }

  val filesHere =   (new java.io.File(".").listFiles())
  def grep(pattern:String) =
    for(file <- filesHere
        if (file.getName.endsWith(".txt"));
            line <- fileLines(file);
        if line.trim.matches(pattern)
    )
      println(file + " : " + line.trim )
//      println(file )

  def exceptionTest: Unit ={
    val u: java.io.FileReader = try {
      val f = new java.io.FileReader("input.txt")
      f
    } catch {
      case ex: FileNotFoundException => println("file not found!") ;return ()
      case ex: IOException => println("java io exception") ; return ()

    } finally {
      println("finally")
    }
    u.read()

    //println(a)
  }
}
