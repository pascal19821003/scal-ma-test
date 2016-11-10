package ershijiu

import scala.beans.BeanProperty

/**
  * Created by Pascal on 2016/11/8.
  */
class Student[T, S](@BeanProperty val name : T, @BeanProperty val age:S) {

}

class Teacher[T, S](val name:T, val age:S)