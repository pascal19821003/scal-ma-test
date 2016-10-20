package org.pascal{

  package p{

    import bobsrockets.Rocket

    class Super{
      protected  def f(): Unit ={
        println("In Super")
        println("f")
      }
      class Sub extends Super{
        println("In Sub")
        f()
      }


    }
    package tt{
      class T1{
        def t(): Unit ={
          println("t")
        }
      }
    }
    object Dishisanzhang {
      def main(args:Array[String]){
        //val outer = new Outer()
        val super1 = new Super
        val sub = new super1.Sub
        val t1 = new tt.T1
        t1.t()
        ////////////////

       val rocket = new  Rocket
        Rocket.chooseStategy(rocket)
      }
    }
  }
}

/**
  * Created by Pascal on 2016/10/7.
  */

package bobsrockets{
  package navigation{
    private [bobsrockets] class Navigator{
      protected  [navigation] def useStarChart(): Unit ={
        println(this.speed)
        val other = new Navigator
//        println(other.speed)

        val left = new LefOfJourney
       // left.distance
      }
      class LefOfJourney{
        private[Navigator] val distance = 100
      }
      private [this] var speed = 200
    }

    package launch{
     // import navigation._
      object Vehicle{
        private [launch] val guide = new Navigator
        guide.useStarChart()

        val left = new guide.LefOfJourney

      }
    }
  }
  class Rocket{
    import Rocket.fuel
    private def canGoHomeAgain=fuel>20
  }
  object Rocket{
    private def fuel  = 10
    def chooseStategy(rocket:Rocket): Unit ={
      if(rocket.canGoHomeAgain){
        goHome()
      }else{
        pickAsStar()
      }
    }
    def goHome(): Unit ={
      println("go home")
    }
    def pickAsStar(): Unit ={
      println("pick as start")
    }

  }
}


