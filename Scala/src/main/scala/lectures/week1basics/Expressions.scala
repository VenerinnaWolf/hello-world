package lectures.week1basics

// Выражения (Expressions) и Инструкции (Instructions)
// Управляющие структуры (if-else, for, while, try-catch)

@main def Expressions(): Unit = {
  // Выражение - это когда мы возвращаем какое-то, как правило, вычисленное значение.
  // Инструкция - это когда мы выполняем какое-то действие, говорим компьютеру сделать что-то, но значение не возвращаем.

  // В Scala все является !выражением!
  println(1 + 2 * 3) // 1 + 2 * 3 - это выражение. И print() тоже выражение, оно возвращает тип Unit

  // Простейшие выражения в Scala:
  // 1) + - / *                   - Арифметические операторы
  // 2) & | ^ << >> >>>           - Побитовые операторы
  // 3) == != > >= <= < ! && ||   - Логические операторы

  // Также есть и другие выражения, которые будут описаны далее.
  // Да, if-else или for можно использовать в качестве выражений, т.е присваивать их значение другой переменной.
}


// ---------
// ! Для управляющих конструкций синтаксис в Scala 2 и Scala 3 слегка отличается.
// ! В Scala 3 можно использовать и более старый синтаксис без проблем.
// ! Я буду приводить оба, как пример
//
// Инфу по управляющим конструкциям я брала вот отсюда: https://docs.scala-lang.org/ru/scala3/book/control-structures.html
// ---------

// ------- If-else -------

@main def IfElse(): Unit = {
  val x = 1

  // 1. Однострочный оператор if:
  if (x == 1) println(x)     // Scala 2
  if x == 1 then println(x)  // Scala 3


  // 2. Многострочный оператор if:
  // Scala 2
  if (x == 1) {
    println("x is 1 as you can see:")
    println(x)
  }

  // Scala 3
  if x == 1 then
    println("x is 1 as you can see:")
    println(x)
  // При желании в конце можно добавить end if. Это поддерживается только в Scala 3
  end if


  // 3. if - else
  // Scala 2
  if (x == 1) {
    println("x is 1, as you can see:")
    println(x)
  } else {
    println("x was not 1")
  }

  // Scala 3
  if x == 1 then
    println("x is 1, as you can see:")
    println(x)
  else
    println("x was not 1")


  // 4. if - else if - else
  // Scala 2
  if (x < 0)
    println("negative")
  else if (x == 0)
    println("zero")
  else
    println("positive")

  // Scala 3
  if x < 0 then
    println("negative")
  else if x == 0 then
    println("zero")
  else
    println("positive")


  // 5. Возвращение результата и типа "тернарный оператор"
  // Если требуется присвоить значение переменной, то лучше писать не вот так:

  var y = 30
  val a = 1

  if (a < 20) {
    y = 20
  } else {
    y = 40
  }

  // А вот так. В Scala принято писать более компактно (да и не использовать var по возможности)
  y = if (a < 20) 20 else 40     // Scala 2
  y = if a < 20 then 20 else 40  // Scala 3

  // Мы можем так написать, т.к if является выражением, и его значение можно присвоить переменной
}


// ------- Цикл for -------

@main def ForCycle(): Unit = {
  // Код i <- 1 to 5 называется генератором.

  // 1. "Классический" for - диапазон. Включает обе границы
  for (i <- 1 to 5) print(i)   // Scala 2
  for i <- 1 to 5 do print(i)  // Scala 3
  // Результат: 12345

  // 2. Диапазон с шагом
  for (i <- 1 to 10 by 2) print(i)   // Scala 2
  for i <- 1 to 10 by 2 do print(i)  // Scala 3
  // Результат: 13579

  // 3. Перебрать элементы коллекции
  val ints = Seq(1, 2, 3)
  for (i <- ints) print(i)   // Scala 2
  for i <- ints do print(i)  // Scala 3
  // Результат: 123


  // 4. Многострочный for
  // Scala 2
  for (i <- ints) {
    val x = i * 2
    println(s"i = $i, x = $x")
  }

  // Scala 3
  for i <- ints do
    val x = i * 2
    println(s"i = $i, x = $x")
  // По аналогии с end if можно использовать end for
  end for


  // 5. Несколько генераторов
  // Scala 2
  for {
    i <- 1 to 2
    j <- 'a' to 'b'
    k <- 1 to 10 by 5
  } {
    println(s"i = $i, j = $j, k = $k")
  }

  // Scala 3
  for
    i <- 1 to 2
    j <- 'a' to 'b'
    k <- 1 to 10 by 5
  do
    println(s"i = $i, j = $j, k = $k")

  /*
    Результат:
    i = 1, j = a, k = 1
    i = 1, j = a, k = 6
    i = 1, j = b, k = 1
    i = 1, j = b, k = 6
    i = 2, j = a, k = 1
    i = 2, j = a, k = 6
    i = 2, j = b, k = 1
    i = 2, j = b, k = 6
  */


  // 6. Ограничители (guards)
  // Scala 2
  for {
    i <- 1 to 5
    if i % 2 == 0
  } {
    print(i)
  }

  // Scala 3
  for
    i <- 1 to 5
    if i % 2 == 0
  do
    print(i)

  // Результат: 24


  // 7. Несколько ограничителей
  // Scala 2
  for {
    i <- 1 to 10
    if i > 3
    if i < 6
    if i % 2 == 0
  } {
    println(i)
  }

  // Scala 3
  for
    i <- 1 to 10
    if i > 3
    if i < 6
    if i % 2 == 0
  do
    println(i)

  // Результат: 4


  // 8. Использование for с Maps
  val states = Map(
    "AK" -> "Alaska",
    "AL" -> "Alabama",
    "AR" -> "Arizona"
  )

  for ((abbrev, fullName) <- states) println(s"$abbrev: $fullName")   // Scala 2
  for (abbrev, fullName) <- states do println(s"$abbrev: $fullName")  // Scala 3
  /*
    Результат:
    AK: Alaska
    AL: Alabama
    AR: Arizona
  */

  // Когда цикл for перебирает мапу, каждая пара ключ/значение привязывается
  // к переменным abbrev и fullName, которые находятся в кортеже: (abbrev, fullName) <- states
  // По мере выполнения цикла переменная abbrev принимает значение текущего ключа в мапе,
  // а переменная fullName - соответствующему ключу значению.


  // 9. Выражение for. Использование yield
  // Выражение (которое возвращает значение) создается с помощью yield
  // Scala 2
  val list =
    for (i <- 10 to 12)
      yield i * 2

  // Scala 3
  val list1 =
    for i <- 10 to 12
      yield i * 2

  // Результат. В переменной list: IndexedSeq[Int] = Vector(20, 22, 24)
  // После выполнения этого выражения for переменная list содержит Vector с отображаемыми значениями.
  //
  // Вот как работает выражение:
  // 1. Выражение for начинает перебирать значения в диапазоне (10, 11, 12).
  //    Сначала оно работает со значением 10, умножает его на 2, затем выдает результат - 20.
  // 2. Далее берет 11 — второе значение в диапазоне.
  //    Умножает его на 2, а затем выдает значение 22.
  //    Можно представить эти полученные значения как накопление во временном хранилище.
  // 3. Наконец, цикл берет число 12 из диапазона, умножает его на 2, получая число 24.
  //    Цикл завершается в этой точке и выдает конечный результат - Vector(20, 22, 24).

  // Кстати, показанное выражение for эквивалентно вызову метода map:
  val list2 = (10 to 12).map(i => i * 2)


  // 10. Использование блока кода после yield
  val names = List("_olivia", "_walter", "_peter")

  // Scala 2
  val capNames = for (name <- names) yield {
    val nameWithoutUnderscore = name.drop(1)
    val capName = nameWithoutUnderscore.capitalize
    capName
  }

  // Scala 3
  val capNames1 = for name <- names yield
    val nameWithoutUnderscore = name.drop(1)
    val capName = nameWithoutUnderscore.capitalize
    capName

  // Результат capNames: List[String] = List(Olivia, Walter, Peter)


  // 11. Использование выражения for в качестве тела метода
  // Поскольку выражение for возвращает результат, его можно использовать в качестве тела метода,
  // который возвращает полезное значение.
  // Этот метод возвращает все значения в заданном списке целых чисел, которые находятся между 3 и 10

  // Scala 2
  def between3and10(xs: List[Int]): List[Int] =
    for {
      x <- xs
      if x >= 3
      if x <= 10
    } yield x

  // Scala 3
  def between3and10_1(xs: List[Int]): List[Int] =
    for
      x <- xs
      if x >= 3
      if x <= 10
    yield x

  between3and10(List(1, 3, 7, 11)) // : List[Int] = List(3, 7)
}


// ------- Цикл while -------

@main def WhileCycle(): Unit = {
  // Внимание! Циклы while использовать не приветствуется в функциональной парадигме,
  // т.к они используют var-переменные.
  // По возможности вместо while лучше использовать хвостовую рекурсию

  var i = 0

  // Scala 2
  while (i < 3) {
    println(i)
    i += 1
  }

  // Scala 3
  while i < 3 do
    println(i)
    i += 1
}

// Также в этой статье есть информация про match (case) и try-catch, но это я пока описывать не буду.
