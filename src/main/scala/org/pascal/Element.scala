package org.pascal

/**
  * Created by Pascal on 2016/10/1.
  */
abstract  class Element {
  def contents : Array[String]
  def height: Int = contents.length
  def width :Int = if(height ==0) 0 else contents(0).length


}
