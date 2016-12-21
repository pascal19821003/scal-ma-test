package rumenjingtong.di7

/**
  * Created by Pascal on 2016/11/18.
  */
class Student(var name:String,var age:Int){
  private var sex:Int = 0
  def printCompanionObject = println(Student.studentNo)
}

object Student {
  private var studentNo:Int = 0

  def uniqueStudentNo : Int ={
    studentNo +=1
    studentNo
  }

  def apply(name:String, age:Int) = new Student(name, age)


  def main(args:Array[String]): Unit ={
    println(Student.uniqueStudentNo)
    val s = new Student ("John", 29)
    println(s.sex)

    val s1 = Student("json",211)
    println(s1.name)
    println( s1.age)
  }

}


