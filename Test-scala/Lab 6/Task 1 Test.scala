package pr

import chisel3._
import org.scalatest._
import chiseltest._

class counterTest extends FreeSpec with ChiselScalatestTester{
    "counter Test T1 lab6"in{
        test(new counter(13)){
            C =>
            C.clock.step(50)
        }
    }
}