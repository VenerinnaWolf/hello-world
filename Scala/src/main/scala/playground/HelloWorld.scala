package playground

// Два варианта написания кода для запуска из курса Stepic https://stepik.org/lesson/460681/step/4?auth=registration&unit=451276

// Вариант 1 (в версии Scala 3. советуют не использовать)
object ScalaPlaygroundOne extends App {
  println("Hello, Scala, from Stepic object ScalaPlaygroundOne!")
}

// Вариант 2 (такой вариант можно использовать, чтобы работало одновременно для Scala 2 и 3)
object ScalaPlaygroundTwo {
  def main(args: Array[String]) : Unit = {
    println("Hello, Scala, from Stepic object ScalaPlaygroundTwo main function!")
  }
}

// Для Scala 3 лучше использовать вот такую запись
// Hello world более новой версии: https://docs.scala-lang.org/ru/getting-started/intellij-track/building-a-scala-project-with-intellij-and-sbt.html
@main def run(): Unit = {
  println("Hello, Scala, from newer documentation!")
}
