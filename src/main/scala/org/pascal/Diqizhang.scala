package org.pascal

import java.io.{File, FileNotFoundException, FileReader, IOException}
import java.net.{MalformedURLException, URL}

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException

/**
  * Created by Pascal on 2016/9/23.
  */
object Diqizhang {
  def main(args: Array[String]): Unit = {
    val filename = if (!args.isEmpty) args(0) else "default.txt"
    println(filename)
    println(println(filename) == ())
    println(println(filename))

    //  for
    val filesHere = (new java.io.File(".")).listFiles
    for (file <- filesHere) {
      println(file)
    }

    for (i <- 1 to 4) {
      println("Iteration: " + i)
    }

    var filesHere2 = (new java.io.File("C:\\Users\\Pascal\\IdeaProjects\\scal-ma-test\\src\\main\\scala\\org\\pascal")).listFiles
    for (file <- filesHere2 if file.getName.endsWith(".scala"))
      println(file)

    for(file<-filesHere
        if file.isFile;
      if file.getName.endsWith(".xml")
    )println(file)

    grep(".*hello.*", filesHere2)

    scalaFiles(filesHere2).foreach(println)

    //
//    val n = 5
//   val half =
//   if (n % 2 == 0)
//     n / 2
//   else
//     throw new RuntimeException("n must be event")
//    println(half)

    testTryCatch

    println(testUrl("aa"))

    println(testMatch(""))

  }

  def testMatch(firstArg : String) : String = {
    firstArg match{
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "huh?"
    }

  }
  def testUrl (path:String): URL ={
    try{
      new URL(path)
    }catch{
      case e:MalformedURLException=>new URL("http://www.baidu.com")
    }
  }

  def testTryCatch(): Unit ={
    try{
      val f = new FileReader("input.txt")
    }catch{
      case ex:FileNotFoundException => println("file not found")
      case ex:IOException => println("io error")
    }
  }


  def scalaFiles(fileHeres: Array[File]) =
    for{
      file<-fileHeres
      if file.getName.endsWith(".scala")
    }yield  file

  def fileLines(file: java.io.File)  =
    scala.io.Source.fromFile(file ).getLines.toList

  def grep(pattern :String, fileHeres: Array[File]): Unit = for(
    file <- fileHeres
    if file.getName.endsWith(".scala");
     line <- fileLines(file)
    if line.trim.matches(pattern)
  )println(file + ":"+ line.trim)
}
