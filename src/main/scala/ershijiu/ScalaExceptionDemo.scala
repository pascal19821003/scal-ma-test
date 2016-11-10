package ershijiu

import java.io.{File, IOException}

/**
  * Created by Pascal on 2016/11/8.
  */
object ScalaExceptionDemo {
def main(args:Array[String]): Unit ={
  val file: File = new File("a.txt")
  if(!file.exists()){
    try{
      file.createNewFile()
    }catch{
      case e:IOException =>{
        e.printStackTrace()
      }
    }
  }
}
}
