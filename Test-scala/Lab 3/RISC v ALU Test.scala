package Lab3

import chisel3._
import org.scalatest._
import chiseltest._

class RISCVTest extends FreeSpec with ChiselScalatestTester{
    "ALU test" in {
        test(new ALU()){
            C =>
            C.io.in_A.poke(5.U)
            C.io.in_B.poke(7.U)
            C.io.alu_Op.poke(4.U)
            C.clock.step(50)
        }
    }
}