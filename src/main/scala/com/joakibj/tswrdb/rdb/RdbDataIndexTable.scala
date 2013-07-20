package com.joakibj.tswrdb.rdb

import collection.mutable.ArrayBuffer

object RdbIndexEntry {
  def apply(rdbType: Int, id: Int, fileNum: Byte, dataOffset: Int, length: Int, hash: Array[Byte]) =
    new RdbIndexEntry(rdbType, id, fileNum, dataOffset, length, hash)

  def apply(tup2: Tuple2[Int, Int], tup4: Tuple4[Byte, Int, Int, Array[Byte]]) =
    new RdbIndexEntry(tup2._1, tup2._2, tup4._1, tup4._2, tup4._3, tup4._4)
}

class RdbIndexEntry(val rdbType: Int,
                    val id: Int,
                    val fileNum: Byte,
                    val dataOffset: Int,
                    val length: Int,
                    val hash: Array[Byte]) {
  val fileName = "%02d.rdbdata" format fileNum

  override def equals(other: Any) = other match { 
    case that: RdbIndexEntry => {
      this.rdbType == that.rdbType &&
      this.id == that.id &&
      this.fileNum == that.fileNum &&
      this.dataOffset == that.dataOffset &&
      this.length == that.length
    }
    case _ => false 
  }

  override def toString = {
    "(type: " + rdbType +
      ", id: " + id +
      ", fileNum: " + fileNum +
      ", fileName: " + fileName +
      ", dataOffset: " + dataOffset +
      ", length: " + length + ")"
  }
}

object RdbDataIndexTable {
  def apply(tbl: ArrayBuffer[RdbIndexEntry]) = new RdbDataIndexTable(tbl)
}

class RdbDataIndexTable(tbl: ArrayBuffer[RdbIndexEntry]) {
  private val table = tbl

  def length = table.size

  def types = table.map(_.rdbType).toSet

  def entriesForType(in: Int): Array[RdbIndexEntry] = {
    if (!RdbTypes.exists(in)) throw new RdbTypeNotFoundException("RdbType not found")

    table.filter((indexEntry: RdbIndexEntry) => indexEntry.rdbType == in).toArray
  }
}
