package lectures.week1basics

// Работа со строками

@main def StringOperations(): Unit = {

  // ------- Методы работы со строками -------

  // .length - выводит длину строки
  // .charAt(index) - возвращает символ строки, находящийся на указанной позиции (index) в строке. В качестве индекса допускается указывать значения от 0 до length - 1
  // .substring(beginIndex, endIndex) - возвращает подстроку, включая первый индекс и НЕ включая второй
  // .startsWith(prefix) - проверяет, начинается ли строка с указанного префикса (prefix)
  // .replace(target, replacement) - заменяет подстроку target на подстроку replacement
  // .toLowerCase - все символы в строке преобразует в нижний регистр (все большие буквы превращает в маленькие)
  // .toUpperCase - все символы в строке преобразует в верхний регистр
  // .reverse - возвращает перевернутую строку
  // .take(n) - возвращает строку, состоящую из n первых символов исходной строки; при этом метод take направлен на взятие первых n элементов, и задать отрицательное число для n не выйдет
  // .toInt - преобразует значение String в значение типа Int (если преобразование невозможно, будет исключение NumberFormatException)

  val aString: String = "Hello, world!"

  println(aString.length)             // 13
  println(aString.charAt(1))          // "e"
  println(aString.substring(0, 2))    // "He"
  println(aString.startsWith("He"))   // true
  println(aString.replace("!", "."))  // "Hello, world."
  println(aString.toLowerCase)        // "hello, world!"
  println(aString.toUpperCase)        // "HELLO, WORLD!"
  println("abcd".reverse)             // "dcba"
  println("abcd".take(2))             // "ab"

  val aStringNum: String = "123"
  val anIntNum: Int = aStringNum.toInt  // anIntNum = 123

  // Методы можно комбинировать. И присваивать результат другой переменной
  val bString = aString.toUpperCase.substring(7, aString.length)  // "WORLD!"


  // ------- Интерполяция строк --------

  // Или же использование переменных в строках

  val courseTitle = "Scala"

  // 1 - s-интерполяция. Похоже на f-строку из Python
  println(s"Welcome to $courseTitle course") // Welcome to Scala course
  // 2 - конкатенация
  println("Welcome to " + courseTitle + " course") // Welcome to Scala course
  // 3 - если используется какое-то выражение, его пишем в {фигурных скобках}
  println(s"Welcome to ${courseTitle.toUpperCase} course") // Welcome to SCALA course
  // 4 - существуют спецсимволы \n, \t. Если требуется их игнорировать, вместо s используется raw
  println(s"Welcome to \t$courseTitle course")    // Welcome to 	Scala course
  println(raw"Welcome to \t$courseTitle course")  // Welcome to \tScala course

}
