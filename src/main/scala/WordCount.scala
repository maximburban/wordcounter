package com.course.ch0

import scala.io.Source

object WordCount {

  sealed trait Operation

  case object Lines extends Operation

  case object Words extends Operation

  case object Bytes extends Operation

  case object Characters extends Operation

  case object LongestLine extends Operation

  def main(args: Array[String]): Unit =
    println(process(args.toList))

  def process(list: List[String]): String =
    list match {
      case command :: file :: _ => implicit val source: Source = Source.fromFile(file)
        command match {
          case "-c" => "bytes count: " + count(Bytes)
          case "-l" => "lines count: " + count(Lines)
          case "-m" => "characters count: " + count(Characters)
          case "-w" => "words count: " + count(Words)
          case "-L" => "length of the longest line: " + count(LongestLine)
        }
      case Nil | _ => helpMessage
    }

  def count(op: Operation)(implicit source: Source): Int =
    try op match {
      case Lines =>
        source.getLines.size
      case Words =>
        val theWholeText = source.getLines.mkString("\n")
        theWholeText.split("\\s+").length
      case Bytes =>
        source.length
      case Characters =>
        source.toList.length
      case LongestLine =>
        val lines = source.getLines()
        val lengths = lines.map(_.length)
        lengths.max
    }
    finally
      source.close()

  val helpMessage: String =
    """
      |usage:
      | wc -c <filename> prints the bytes count
      | wc -l <filename> prints the line count
      | wc -m <filename> prints the character count
      | wc -w <filename> prints the word count
      | wc -L <filename> prints the length of the longest line """.stripMargin

}