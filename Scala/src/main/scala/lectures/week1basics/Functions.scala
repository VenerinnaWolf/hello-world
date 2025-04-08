package lectures.week1basics

// Функции

@main def Functions(): Unit = {
  // 1. Объявление функции - def имя(параметр: тип параметра): тип функции = тело функции
  def aPerson(name: String, surname: String): String = {
    s"$name $surname"
  }

  // а) Можно тип функции не объявлять, но лучше так не делать
  // б) Фигурные скобки можно опустить, если строка кода в функции одна
  // в) По сути фигурные скобки - это блок кода.
  //    Соответственно функция возвращает то, что написано в последней строке. Оператор return не требуется

  // 2. Вызов функции:
  println(aPerson("John", "Smith"))  // выведет "John Smith"

  // 3. Можно сделать функцию, которая печатает что-то. Ее тип будет - Unit
  def bPerson(name: String, surname: String): Unit = println(s"$name $surname")
  bPerson("John", "Smith")  // выведет "John Smith"

  // 4. Функция без параметров:
  def aParameterlessFunction(): Unit = println("Function with no parameters")
  aParameterlessFunction()  // Вызов функции без параметров
  //aParameterlessFunction - без скобок можно было писать до Scala 3

  // 5. Параметры по умолчанию
  def aFunctionWithDefaultParameter(x: Int, y: String = "Default Parameter"): String = {
    s"x = $x and y = $y"
  }
  println(aFunctionWithDefaultParameter(1)) // выводит "x = 1 and y = Default Parameter"

  // Также можно явным образом указывать название параметра:
  def printPerson(name: String = "Don't name", surname: String = "Don't surname"): Unit = println(s"$name $surname")
  printPerson(surname = "Biryukov")  // выводит "Don't name Biryukov"


  // 6. Вызов по имени (call-by-name) vs Вызов по значению (call-by-value)

  // Вызов по значению подразумевает вычисление значения переданного выражения перед вызовом функции.
  // Преимущество: значение вычисляется только один раз.
  //
  // Вызов по имени подразумевает вычисление значения выражения в момент его вызова в функции
  // Преимущество: значение не вычисляется, если не используется в теле функции.

  def callByValue(x: Long): Unit = {  // Вызов по значению - строгая функция
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }

  def callByName(x: => Long): Unit = {  // Вызов по имени - ленивая функция
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }

  callByValue(System.nanoTime())  // выведет два одинаковых времени, т.к x высчиталось до начала функции
  callByName(System.nanoTime())  // выведет два разных времени, т.к x высчитывается в момент print-а
  // Примечание - System.nanoTime() возвращает время выполнения в наносекундах.


  // 7. Вложенные функции
  def aBossFunction(): String = {
    def aHelperFunction(): String = "I'm here to help"
    aHelperFunction()
  }
}
