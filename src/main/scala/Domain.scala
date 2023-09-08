package pl.ayeo.steps

object Domain {
  trait Subject

  trait WithName {
    def getName: String
  }

  trait WithAge {
    def getAge: Int
  }

  trait WithAnimal {
    def hasAnimal: Boolean
  }

  trait NameEnricher[S] {
    def addName(s: S, name: String): S with WithName
  }

  trait AgeEnricher[S] {
    def addAge(s: S, age: Int): S with WithAge
  }

  trait AnimalEnricher[S] {
    def addAnimal(s: S, has: Boolean): S with WithAnimal
  }
}
