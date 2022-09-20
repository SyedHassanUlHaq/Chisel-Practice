package Lab8

import chisel3._
import org.scalatest._
import chiseltest._

class twoBankedMemoryTest extends FreeSpec with ChiselScalatestTester{
    "Two Bank Memory" in{
        test(new twoBankedMemory){
            C =>
            C.io.enable.poke(1.B)
            C.io.wrData(0).poke(4.U)
            C.io.wrData(1).poke(6.U)
            C.io.rdAddr.poke(9.U)
            C.io.wrAddr.poke(12.U)
            C.io.mask(0).poke(1.B)
            C.clock.step(50)
        }
    }
}
