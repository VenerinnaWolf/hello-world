package lectures.week2oop

// Классы

@main def ClassesOop(): Unit = {
  // 1. Объявление класса
  class Student(id: Int, name: String) {
    // а) Конструкторы.  ↑ Поля класса являются конструктором по умолчанию
    // Другие конструкторы:
    def this(name: String) = this(0, name)  // этот конструктор создаст человека с id=0 и любым именем

    // б) Методы класса
    // В методах можно использовать те же названия переменных, что в и полях класса,
    // т.к к полям класса мы обращаемся через this.
    def makeFriends(name: String): Unit = {
      println(this.name + " wants to be friends with " + name)
    }

    // в) Перегрузка методов
    def showId(): Unit = {
      println(s"Student has id = ${this.id}")  // кстати можно вместо this.id просто написать id, тоже сработает
      // println(s"Student has id = $id")
    }

    def showId(number: Int): Unit = {
      for (i <- 1 to number) println(s"Student has id = $id")
    }
  }

  // 2. Создание экземпляра класса (объекта) через конструктор
  val student_alice = new Student(1, "Alice")  // используем конструктор по умолчанию
  val student_john = new Student("John")  // используем другой конструктор

  // *Такого же эффекта можно было бы добиться, если бы мы указали параметр по умолчанию:
  class Student1(id: Int = 0, name: String) {}

  val student1_alice = new Student1(1, "Alice")
  val student1_john = new Student1(name = "John")

  // 3. Использование методов класса
  student_alice.makeFriends("Mary")  // выведет "Alice wants to be friends with Mary"
  student_alice.showId()  // выведет "Student has id = 1"
  student_alice.showId(3)  // выведет 3 раза "Student has id = 1"



}
