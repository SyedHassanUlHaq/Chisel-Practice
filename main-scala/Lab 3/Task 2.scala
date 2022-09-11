package pr

import chisel3._
import chisel3.util._
class LM_IO_Interface_ImmdValGen extends Bundle {
    val Op_code = Input(UInt(32.W))
    val immd_se = Output(UInt(32.W))
}
class ImmdValGen extends Module {
    val io = IO(new LM_IO_Interface_ImmdValGen)
switch(io.Op_code){
    is("b0010011".U){
        io.immd_se := Cat(Fill(20, io.Op_code(31)), io.Op_code(31, 20))
    }
    is("b0100011".U){
        io.immd_se := Cat(Fill(20, io.Op_code(31)), io.Op_code(31, 25), io.Op_code(11, 7))
    }
    is("b1100011".U){
        io.immd_se := Cat(Fill(19, io.Op_code(31)), io.Op_code(31), io.Op_code(7), io.Op_code(30, 25), io.Op_code(8, 11), 0.U)
    }
    is("b0010111".U){
        io.immd_se := Cat(Fill(12, io.Op_code(31)), io.Op_code(31, 12))
    }
    is("b1101111".U){
        io.immd_se := Cat(Fill((11), io.Op_code(31)), io.Op_code(31), io.Op_code(19, 12), io.Op_code(20), io.Op_code(31, 21), 0.U)
    }
}
}