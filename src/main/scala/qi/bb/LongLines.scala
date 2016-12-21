package qi.bb

import scala.io.Source

/**
  * Created by Pascal on 2016/12/20.
  */
object LongLines {
  def processFile(filename:String, width:Int): Unit ={
    // inner function
    def processLine(line:String): Unit ={
      if( line.length > width){
        println("filename: "+ filename + " line: "+ line)
      }
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines()){
      processLine(line)
    }
  }

}

object FindLongLines{
  def main(args:Array[String]): Unit ={
    val width = args(0).toInt
    for (arg <- args.drop(1)){
      LongLines.processFile(arg, width)
    }
  }
}
