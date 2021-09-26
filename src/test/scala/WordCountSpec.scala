package com.course.ch0

import WordCount.{Bytes, Characters, Lines, LongestLine, Words}

import org.mockito.MockitoSugar
import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class WordCountSpec extends AnyFunSuite with MockitoSugar {

  private val mockSource: Source = mock[Source]

  when(mockSource.getLines()).thenReturn(Seq("line one", "line two", "line three").iterator)
  test("counter should return line count if operation type is Lines") {

    val result = WordCount.count(Lines)(mockSource)
    assert(result == 3)
  }

  test("counter should return word count if operation type is Words") {
    when(mockSource.getLines()).thenReturn(Seq("line one", "line two", "line three").iterator)

    val result = WordCount.count(Words)(mockSource)
    assert(result == 6)
  }

  test("counter should return count of bytes if operation type is Bytes") {
    val length = 100
    when(mockSource.length).thenReturn(length)

    val result = WordCount.count(Bytes)(mockSource)
    assert(result == 100)
  }

  test("counter should return count of characters if operation type is Characters") {
    when(mockSource.toList).thenReturn(List('a', 'b', 'c'))

    val result = WordCount.count(Characters)(mockSource)
    assert(result == 3)
  }

  test("counter should return count of longest line if operation type is LongestLine") {
    when(mockSource.getLines()).thenReturn(Seq("line one", "line two", "line three").iterator)

    val result = WordCount.count(LongestLine)(mockSource)
    assert(result == 10)
  }
}
