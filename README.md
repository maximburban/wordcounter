The Word Counter
================

Scala 2 word count utility implementation.

Building:

     sbt package

Usage:

     scala target/scala-2.13/world-counter_2.13-0.1.jar -c <filename> prints the byte count 
     scala target/scala-2.13/world-counter_2.13-0.1.jar -l <filename> prints the line count
     scala target/scala-2.13/world-counter_2.13-0.1.jar -m <filename> prints the character count
     scala target/scala-2.13/world-counter_2.13-0.1.jar -w <filename> prints the word count
     scala target/scala-2.13/world-counter_2.13-0.1.jar -L <filename> prints the length of the longest line 
