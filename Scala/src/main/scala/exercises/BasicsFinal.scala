package exercises

// Задание.
// Требуется модифицировать поданную на вход строку так, чтобы слова в ней разместились в обратном порядке.
// Например, строка "I like     Scala" должна трансформироваться в "Scala like I"
// Как вы уже могли заметить, в результирующей строке слова разделены одиночным пробелом,
// так что не забудьте предусмотреть удаление всех лишних пробелов из исходной строки.
// Проверьте, чтобы в начале и конце строки пробелов вообще не было.
//
// Примечание:
//  - обратиться к подаваемой на вход строке можно через переменную input
//  - не забудьте предусмотреть принт конечного результата
//
// Sample Input:
// I like Scala
// Sample Output:
// Scala like I

@main def BasicsFinal(): Unit = {
  val input = "   I like     Scala   "
  val trim_input = input.trim()  // обрезаем пробелы в начале и конце строки
  val pattern = raw"\s+".r  // используем регулярное выражение для поиска 1 и более пробелов
  val one_spaces_input = pattern.replaceAllIn(trim_input, " ")  // заменяем все пробелы на один пробел

  val arr = one_spaces_input.split(" ")  // делим строку по пробелам
  val reverse_arr = arr.reverse  // разворачиваем массив
  val output = reverse_arr.mkString(" ")  // склеиваем массив обратно в строку
  println(output)


  // *В решениях нашла вот такое решение в одну строчку. В целом, идея та же)
  println(input.split("\\s+").reverse.mkString(" "))
}
