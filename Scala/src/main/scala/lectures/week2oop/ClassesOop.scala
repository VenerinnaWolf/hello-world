package lectures.week2oop

// Классы

@main def ClassesOop(): Unit = {
  // Для удобства чтения я пишу объявления классов внутри этой функции.
  // На самом деле, их можно вынести наружу или объявлять ниже использования - все будет работать.

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
  // *В версии Scala 3, слово new является опциональным
  val student_alice = new Student(1, "Alice")  // используем конструктор по умолчанию
  val student_john = new Student("John")  // используем другой конструктор

  // *Такого же эффекта можно было бы добиться, если бы мы указали параметр по умолчанию:
  class Student1(id: Int = 0, name: String)

  val student1_alice = new Student1(1, "Alice")
  val student1_john = new Student1(name = "John")


  // 3. Использование методов класса
  student_alice.makeFriends("Mary")  // выведет "Alice wants to be friends with Mary"
  student_alice.showId()  // выведет "Student has id = 1"
  student_alice.showId(3)  // перегрузка метода - выведет 3 раза "Student has id = 1"


  // 4. Обращение к полям класса извне

  // Просто так обратиться: `student_alice.name` не получится.
  // Для этого нужно дописать var / val к полю.
  // Также мы сможем обращаться к любым другим переменным val / var, объявленным внутри класса,
  // если только мы не обозначили предварительно private

  class Student2(id: Int, val name: String) {
    val last_name = "Smith"
    private val secret_key = 1234
  }

  val student2 = new Student2(1, "Ivan")
  println(student2.name)  // теперь мы можем обратиться к полю name
  // println(student.id)  // а к id не сможем
  println(student2.last_name)  // зато сможем обратиться к переменной
  // println(student.secret_key) // если только она не обозначена как private


  // 5. Если внутри класса прописать какие-то действия, то они выполнятся в момент вызова конструктора:

  class Student3(id: Int, val name: String) {
    println(id)
  }

  val student3 = new Student3(1, "Kate")
  println(student3.name)
  // Выведется:
  // 1
  // Kate



}
