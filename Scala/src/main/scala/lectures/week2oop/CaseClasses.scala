package lectures.week2oop

// Классы образцы (иммутабельные структуры данных)

@main def CaseClasses(): Unit = {
  case class SomeClass()

  // *Пункт 1 описывает поведение case classes для Scala 2. В Scala 3 это также применимо и к обычным классам

  // 1. Экземпляры Case-класса можно создавать без слова new

  // Это возможно благодаря тому, что любой класс образец имеет объект компаньон с методом apply.
  // И именно этот метод позволяет создавать экземпляр класса без new.
  // apply из объекта-компаньона имеет столько аргументов, сколько прописано в соответствующем ему case классе.
  // Вызвать метод apply можно несколькими способами:

  case class Person(name: String, occupation: String)

  // вариант 1
  val person = Person.apply("Bob", "Developer")

  // вариант 2 - этот вариант используется наиболее часто
  val personn = Person("Bob", "Developer")

  // Если необходимо дополнить объект компаньон дополнительным функуционалом,
  // то следует явно прописать в коде объект-компаньон с необходимыми дополнениями.
  // Для примера воспользуемся перегрузкой методов и создадим два дополнительных метода apply:
  case class Person1(name: String, occupation: String) {
    // Можно даже написать вот такой apply прямо в классе:
    def apply(): String = s"$name works as a $occupation"
  }

  object Person1 {
    def apply(name: String): Person = new Person(name, "Developer")
  }

  val person1 = Person1("Sam")  // созданный нами метод apply
  val person2 = Person1("Dan", "Manager")  // метод apply, доступный по умолчанию в каждом объекте компаньоне

  println(person1)  // Person(Sam,Developer)
  println(person2)  // Person(Dan,Manager)
  println(person2())  // Dan works as a Manager - вызываем созданный apply внутри класса
  println(person2.apply())  // Dan works as a Manager - можем вызвать и вот так
  // println(person1()) - для person1 это не пройдет, т.к тут будет использоваться apply из объекта


  // 2. Параметры case класса являются публичными и неизменяемыми

  // т.е можно сразу получить доступ к полям класса образца вне этого класса,
  // нет необходимости вручную дописывать val
  case class Person2(name: String, occupation: String)

  val person_2 = Person2("Bob", "Developer")
  println(person_2.name)

  // При желании поля можно сделать и изменяемыми, но тогда нужно будет добавить var
  // (этот пример из комментов демонстрирует, как можно неизменяемый словарь сделать изменяемым)
  case class ActiveFlag(var activeFlag: Boolean)
  val mTable = Map(
    "back" -> ActiveFlag(true),
    "main" -> ActiveFlag(true)
  )

  println(mTable("back").activeFlag) // true`
  mTable("back").activeFlag = false
  println(mTable("back").activeFlag) // false


  // 3. Доступен встроенный метод .toString

  // По умолчанию toString возвращает строку, состоящую из имени класса и хэш-кода объекта.
  // Именно это можно увидеть при вызове toString для обычного класса:
  // (в println автоматически выполняется метод .toString)
  class JustClass(name: String, occupation: String)

  val classExample = new JustClass("Bob", "Developer")
  println(classExample)  // lectures.week2oop.CaseClasses$package$JustClass$1@2d3fcdbd

  // А вот так это выглядит для case класса
  case class CaseClass(name: String, occupation: String)

  val caseClassExample = CaseClass("Bob", "Developer")
  println(caseClassExample)  // CaseClass(Bob,Developer)


  // 4. Доступен метод equals (==) и классы сравниваются по структуре, а не по ссылкам
  case class Person3(name: String, occupation: String)

  val personA = Person3("Bob", "Developer")
  val personB = Person3("Bob", "Developer")
  val personC = Person3("Alice", "Developer")

  println(personA == personB)  // true (несмотря на то, что они ссылаются на разные объекты)
  println(personA.equals(personB))  // true (несмотря на то, что они ссылаются на разные объекты)
  println(personA.equals(personC))  // false

  // Вот так это выглядит для обычного класса:
  class Person4(name: String, occupation: String)

  val personA_1 = new Person4("Bob", "Developer")
  val personB_1 = new Person4("Bob", "Developer")
  val personC_1 = new Person4("Alice", "Developer")

  println(personA_1 == personB_1)  // false
  println(personA_1.equals(personB_1))  // false
  println(personA_1.equals(personC_1))  // false
  println(personA_1 == personA_1)  // true (т.к ссылаются на один и тот же объект)


  // 5. Доступен метод copy, позволяющий создать копию экземпляра класса образца:
  case class Person5(name: String, occupation: String)

  val person5 = Person5("Bob", "Developer")

  val anotherPerson = person5.copy()
  println(person5)  // Person(Bob,Developer)
  println(anotherPerson)  // Person(Bob,Developer)

  // при копировании можно изменить аргументы конструктора
  val modifiedPerson = person5.copy(occupation = "Manager")
  println(modifiedPerson)  // Person(Bob,Manager)


  //* Кстати, ключевое слово case также можно применять и к объектам
  case object MyObject
  // Создавать подобного рода объекты полезно, когда не лишним будет автоматически предоставить объектам
  // дополнительный функционал (например, реализованный метод.toString)
}