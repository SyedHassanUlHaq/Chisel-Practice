package pr

import chisel3._
import org.scalatest._
import chiseltest._
import utest.Tests

class ImmGenTest extends FreeSpec with ChiselScalatestTester{
    "Imm Gen Test" in {
        test(new ImmdValGen){
            C => 
            C.io.Op_code.poke("b00100011".U)
            C.clock.step(50)
        }
    }
}