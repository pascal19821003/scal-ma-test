package shiba

/**
  * Created by Pascal on 2016/10/13.
  */
object ShibaMai {
  def main(args: Array[String]): Unit = {
    //  println(1)
    val account = new BankAccount

    account deposit (100)
    //account deposit  -10
    println(account withdraw (80))
    println(account withdraw (60))

    val time = new shiba.Time
    time hour_= 23
    println(time.hour)
  }
}

class BankAccount {
  private var bal: Int = 0

  def balance: Int = bal

  def deposit(amount: Int): Unit = {
    require(amount > 0)
    bal += amount
  }

  def withdraw(amount: Int): Boolean = {
    if (amount > bal) {
      false
    } else {
      bal -= amount
      true
    }
  }


}

class Time {
  //  var hour = 12
  //  var minute = 0
  private[this] var h = 12
  private[this] var m = 12

  def hour: Int = h

  def hour_=(x: Int) {
    require(0 <= x && x < 24)
    h = x
  }

  def minute = m

  def minute_= (x: Int) {
    require(0 <= x && x < 60)
    m = x
  }

}
