package lectures.week1basics

// Блоки кода

@main def CodeBlocks(): Unit = {
  // Блок кода - это все те строки кода, что мы пишем в фигурных скобках.

  val aCodeBlock = {
    val someVal = 1
    val y = 2
    if (someVal + y > 1) true else false
  }

  // Блок кода также является выражением, результат (и тип) которого
  // равен результату (и типу) последнего описанного внутри блока кода выражения.
  println(aCodeBlock) // выводит true, т.к результат последнего if равен true

  // Еще один пример:
  val bCodeBlock = {
    val someVal = 1
    val y = 2
    if (someVal + y > 1) true else false

    "String to return"
  }
  println(bCodeBlock) // выводит "String to return"

  // И помните: все, что случилось внутри блока кода, остается внутри блока кода.
  // Т.е, если внутри блока мы определили переменную, которую затем захотели использовать вне этого блока - у нас ничего не выйдет
  // print(someVal)  - будет ошибка
}
