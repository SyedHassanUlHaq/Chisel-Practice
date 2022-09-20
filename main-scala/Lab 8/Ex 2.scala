package Lab8

import chisel3._
import chisel3.util._

class twoBankedMemory extends Module{
    val width: Int = 8
    val io = IO(new Bundle{
        val enable = Input(Bool())
        val wrData = Input(Vec(2, UInt(width.W)))
        val rdAddr = Input((UInt(10.W)))
        val wrAddr = Input((UInt(10.W)))
        val mask = Input(Vec(2,Bool()))
        val dataOut = Output(Vec(2,UInt(width.W)))
    })
    val mem = SyncReadMem(1024,Vec(2,UInt(width.W)))
    val write_Reg = RegNext(io.wrData)
    val doForwardReg = RegNext(io.rdAddr === io.wrAddr && io.enable)
    val memReadData = mem.read(io.rdAddr, io.enable)
    when (io.enable){
        mem.write(io.wrAddr, io.wrData, io.mask)
        }
        io.dataOut(0) := Mux(doForwardReg, write_Reg(0), memReadData(0))
        io.dataOut(1) := Mux(doForwardReg, write_Reg(1), memReadData(1))
}