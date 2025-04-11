package lectures.week2oop

// Объекты (используются для организации "статических" методов)
// (Статический метод - не имеющий доступа к состоянию (полям) объекта, то есть к переменной this)

@main def ObjectsOop(): Unit = {
  // Отличительной чертой объектов является то, что они:
  // а) не имеют параметров
  // б) являются одиночками (Singleton Object), т.е существуют в единственном экземпляре
  // По сути это статические методы в других ЯП

  object Number
  val number1 = Number
  val number2 = Number
  println(number1 == number2)  // true, т.е они ссылаются на один и тот же объект - Singleton

  class Number1
  val number_1 = new Number1
  val number_2 = new Number1
  println(number_1 == number_2)  // false - это два разных экземпляра класса

  // 1. Внутри объектов также можно определять переменные и методы
  object Num {
    val Pi = 3.14
    def whoAmI(): Unit = println("I am a Num object")
  }

  val num = Num
  println(num.Pi)
  num.whoAmI()


  // 2. Объекты-компаньоны
  // Объект компаньон - это объект, имеющий то же имя, что и класс, расположенный с ним в одном файле.
  // Объект компаньон может содержать в себе методы, создающие экземпляры класса спутника.
  // Т.е в объекте компаньоне можно описать свой механизм создания экземпляра класса
  // и при этом нет необходимости менять конструктор класса:

  class Student(id: Int, name: String) {
    override def toString: String = s"Student id [$id], name [$name]"
  }

  object Student {
    def create(s: String): Student = {
      val params = s.split(" ")
      new Student(params(0).toInt, params(1))
    }
  }

  val student = Student.create("1 Bob")
  print(student)  // Student id [1], name [Bob]


  // Еще один пример из официальной документации:

  import scala.math._

  class Circle(val radius: Double) {
    def area: Double = Circle.calculateArea(radius)
  }

  object Circle {
    private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
  }

  val circle1 = new Circle(5.0)
  circle1.area

  // In this example the `area` method that’s available to each instance uses
  // the `calculateArea` method that’s defined in the companion object.
  // Once again, `calculateArea` is similar to a static method in Java.
  // Also, because `calculateArea` is private, it can’t be accessed by other code,
  // but as shown, it can be seen by instances of the `Circle` class.


  // 3. Также объекты можно использовать и без создания переменной:
  object StringUtils {
    val hello = "Hello!"
    def truncate(s: String, length: Int): String = s.take(length)
    def containsWhitespace(s: String): Boolean = s.matches(".*\\s.*")
    def isNullOrEmpty(s: String): Boolean = s == null || s.trim.isEmpty
  }

  println(StringUtils.hello)
  StringUtils.truncate("Chuck Bartowski", 5)  // "Chuck"


  // 4. Импорт объектов
  // а) Импорт всего, что есть в объекте:
  import StringUtils._  // Scala 2
  import StringUtils.*  // Scala 3

  truncate("Chuck Bartowski", 5)  // "Chuck"
  containsWhitespace("Sarah Walker")  // true
  isNullOrEmpty("John Casey")  // false

  // б) Импорт только чего-то конкретного:
  import StringUtils.{truncate, containsWhitespace}
  truncate("Charles Carmichael", 7)  // "Charles"
  containsWhitespace("Captain Awesome")  // true
  isNullOrEmpty("Morgan Grimes")  // Not found: isNullOrEmpty (error)
}