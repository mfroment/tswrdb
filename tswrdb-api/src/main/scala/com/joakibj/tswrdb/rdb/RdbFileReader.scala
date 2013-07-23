package com.joakibj.tswrdb.rdb

import java.io.FileInputStream
import java.nio.{ByteOrder, ByteBuffer}
import util.ByteUtils

abstract class RdbFileReader extends ByteUtils {
  protected val MagicNumber: String
  protected val fileInputStream: FileInputStream

  def hasMagicNumber(): Boolean = {
    val buf: Array[Byte] = new Array(MagicNumber.size)
    fileInputStream.read(buf, 0, MagicNumber.length)
    if (new String(buf) == MagicNumber) true else false
  }
}
