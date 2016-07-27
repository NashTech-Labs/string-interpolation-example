package com.knoldus

import StringContext.treatEscapes
import java.io.{FileOutputStream, File, PrintWriter}

object StringInterpolation {

  implicit class WriteScore(val sc: StringContext) extends AnyVal {

    def write(args: Any*): String = {

      checkLengths(sc.parts.length, args.length)
      val strings = sc.parts.iterator
      val expressions = args.iterator
      val buf = new StringBuffer(treatEscapes(strings.next))
      while (strings.hasNext) {
        buf.append(expressions.next)
        buf.append(treatEscapes(strings.next))
      }
      val message: String = writeToFile(buf.toString)
      message
    }

    private def checkLengths(partLen: Int, argLen: Int) = {

      if (partLen != argLen + 1) {
        throw new IllegalArgumentException("wrong number of arguments")
      }
    }

    private def writeToFile(record: String): String = {

      val writeStatus: String = try {
        val writer = new PrintWriter(new FileOutputStream(new File("./src/test/scala/resources/output"),true))
        writer.println(record)
        writer.close()
        "File written successfully"
      }
      catch {
        case e: Exception => "Cannot write to the file"
      }
      writeStatus
    }
  }
}


