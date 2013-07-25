/*
 * tswrdb - a program and API to export the TSW resource database
 *
 * Copyright (C) 2013 Joakim Bjørnstad <joakibj@gmail.com>
 *
 * Licensed under the GNU General Public License version 2.
 * Please see the LICENSE file for the license text in verbatim.
 */

package com.joakibj.tswrdb.rdb

import java.io.InputStream
import util.ByteUtils

abstract class RdbFileReader extends ByteUtils {
  protected val MagicNumber: String
  protected val inputStream: InputStream

  def hasMagicNumber(): Boolean = {
    val buf: Array[Byte] = new Array(MagicNumber.size)
    inputStream.read(buf, 0, MagicNumber.length)

    new String(buf) == MagicNumber
  }
}
