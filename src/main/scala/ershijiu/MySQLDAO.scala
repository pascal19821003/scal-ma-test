package ershijiu

/**
  * Created by Pascal on 2016/11/8.
  * 全部是抽象成员，与java的interface等同
  */
trait MySQLDAO{
  def delete(id:String):Boolean={ true}
  def add(o:Any):Boolean
  def update(o:Any):Int
  def query(id:String):List[Any]
}
