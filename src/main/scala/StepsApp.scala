package pl.ayeo.steps

import Domain._
import Implicits._

object StepsApp extends App {

  private def enrichWithAge[S](s: S)(implicit enricher: AgeEnricher[S]): S with WithAge = enricher.addAge(s, 42)
  private def enrichWithName[S](s: S)(implicit enricher: NameEnricher[S]): S with WithName = enricher.addName(s, "Adam Mickiewicz")
  private def enrichWithAnimal[S](s: S)(implicit enricher: AnimalEnricher[S]): S with WithAnimal = enricher.addAnimal(s, has = false)

  private def print(subject: Subject with WithName with WithAge with WithAnimal): Unit =
    println(s"name: ${subject.getName}, age: ${subject.getAge}, hasAnimal: ${subject.hasAnimal}")


  val a: Subject = new Subject {}
  val b = enrichWithName(a)
  val c = enrichWithAge(b)
  val d = enrichWithAnimal(c)
  print(d)

  //different order of processing
  val a1: Subject = new Subject {}
  val b1 = enrichWithAge(a1)
  val c1 = enrichWithName(b1)
  val d1 = enrichWithAnimal(c1)
  print(d1)
}
