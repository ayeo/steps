package pl.ayeo.steps

import Domain._

object Implicits {

  implicit object BaseNameEnricher extends NameEnricher[Subject] {
    def addName(s: Subject, name: String): Subject with WithName =
      new Subject with WithName {
        def getName: String = name
      }
  }

  implicit object BaseAgeEnricher extends AgeEnricher[Subject] {
    def addAge(s: Subject, age: Int): Subject with WithAge =
      new Subject with WithAge {
        def getAge: Int = age
      }
  }

  implicit object NameAgeEnricher extends AgeEnricher[Subject with WithName] {
    def addAge(s: Subject with WithName, age: Int): Subject with WithName with WithAge =
      new Subject with WithName with WithAge {
        def getName: String = s.getName

        def getAge: Int = age
      }
  }

  implicit object AgeNameEnricher extends NameEnricher[Subject with WithAge] {
    def addName(s: Subject with WithAge, name: String): Subject with WithName with WithAge =
      new Subject with WithName with WithAge {
        def getName: String = name

        def getAge: Int = s.getAge
      }
  }

  implicit object NameAndAgeAnimalEnricher extends AnimalEnricher[Subject with WithName with WithAge] {
    def addAnimal(s: Subject with WithName with WithAge, has: Boolean): Subject with WithName with WithAge with WithAnimal =
      new Subject with WithName with WithAge with WithAnimal {
        def getName: String = s.getName

        def getAge: Int = s.getAge

        def hasAnimal: Boolean = has
      }
  }
}
