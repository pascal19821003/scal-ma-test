package org.pascal

import scala.io.Source

/**
  * Created by Pascal on 2016/9/27.
  */
object LongLines {
  def processFile(filename:String , width: Int): Unit ={

    def processLine(line: String, width :Int  ): Unit ={
      if(line.length > width ){
        println(filename + " " + line );
      }
    }

    val source = Source.fromFile(filename);
    for(line<-source.getLines()){
      processLine(line, width);
    }
  }

}
