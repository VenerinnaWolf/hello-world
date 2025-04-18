package lectures.week2oop

// Классы

@main def ClassesOop(): Unit = {
  // Для удобства чтения я пишу объявления классов внутри этой функции.
  // На самом деле, их можно вынести наружу или объявлять ниже использования - все будет работать.

  // -----------------
  // Различия для классов в Scala 2 и Scala 3:
  // - В Scala 3 слово new при создании экземпляра класса стало опциональным (благодаря генерализации apply методов)
  // - В Scala 2 для объявления тела класса используются { фигурные скобки }. В Scala 3: двоеточие
  // -----------------

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
  // println(student2.id)  // а к id не сможем
  println(student2.last_name)  // зато сможем обратиться к переменной
  // println(student2.secret_key) // если только она не обозначена как private


  // 5. Если внутри класса прописать какие-то действия, то они выполнятся в момент вызова конструктора:

  class Student3(id: Int, val name: String) {
    println(id)
  }

  val student3 = new Student3(1, "Kate")
  println(student3.name)
  // Выведется:
  // 1
  // Kate


  // ------------
  // Наследование
  // ------------

  // Наследование позволяет создать новый (производный) класс на основе уже существующего (базового) класса.
  // Производный класс получает доступ ко всем полям и методам базового класса, кроме отмеченных private

  class Employee {
    def talk(msg: String): Unit = println(s"Employee says: $msg")
  }

  class Manager extends Employee

  val manager = new Manager

  manager.talk("hello")

  // 1. private и protected
  // private переменные и методы доступны только внутри класса, в котором они определены.
  // protected - доступны внутри класса, в котором определены, а также в производных от него классах.

  class Employee1 {
    protected def talk(msg: String): Unit = println(s"Employee says: $msg")
    private val secret = 123
  }

  class Manager1 extends Employee1 {
    // protected метод talk доступен в подклассе
    def speak(msg: String): Unit = talk(msg)

    // println(secret) - private переменная недоступна в подклассе
  }

  val manager1 = new Manager1

  // manager1.talk("hello") - protected метод talk недоступен вне классов
  // println(manager1.secret) - private переменная недоступна вне классов
  // println(employee1.secret) - private переменная недоступна вне классов


  // 2. Параметры наследуемого класса
  // У производного класса должны быть указаны параметры базового класса.
  // (Дополнительные параметры тоже можно указывать, но параметры базового класса обязательны)

  class Employee2(name: String)

  // class Manager2 extends Employee2 - ошибка
  class Manager2(name: String) extends Employee2(name)  // не ошибка
  class Manager3(name: String, emp_id: Int) extends Employee2(name)  // тоже не ошибка

}
