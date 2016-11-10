package ershijiu

/**
  * Created by Pascal on 2016/11/8.
  */
class ScalaThrower {
  //Scala利用注解@throws声明抛出异常
  @throws(classOf[Exception])
  def exceptionThrower {
    throw new Exception("Exception!")
  }
}
