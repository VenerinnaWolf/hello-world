package exercises

// Задание.
// Вам предстоит поработать с двумя классами:
// Instructor(instructorId, name, surname) и  Course(courseId, title, releaseYear, instructor).
//
// Методы класса Instructor
// 1. fullName - возвращает полное имя в виде Имя Фамилия.
//    Первые буквы имени и фамилии обязательно должны быть заглавными,
//    изменять регистр остальных букв не требуется.
//
// Методы класса Course
// 1. getId() - возвращает id , который состоит из двух частей:
//    первая часть - это значение id курса, вторая часть - это значение id инструктора.
//    Например, если courseId = 1, а instructorId = 2, то метод вернет 12;
//    если courseId = 45, а instructorId = 783, то метод вернет 45783
// 2. isTaughtBy(instructor) - проверяет, является ли указанный instructor инструктором курса
// 3. copyCourse(newReleaseYear) - возвращает новый экземпляр класса Course
//    с обновленным значением поля releaseYear
//
// Примечание:
//  - от вас требуется написать лишь код классов; cоздавать экземпляры классов и что-то принтить не надо
//  - чтобы ваш код успешно прошел тесты - позаботьтесь, чтобы releaseYear был доступен даже вне тела класса
//
// Вы можете протестировать каждый метод по отдельности:
//
// 1. для тестирования getId() и fullName() требуется передать в Sample Input
// следующие параметры (указываются через пробел):
//  - название метода (getId или fullName)
//  - instructorId
//  - name
//  - surname
//  - courseId
//  - title
//  - releaseYear
//
// 2. для тестирования isTaughtBy требуется передать в Sample Input следующие параметры:
//  - название метода (isTaughtBy)
//  - instructorId
//  - name
//  - surname
//  - courseId
//  - title
//  - releaseYear
//  - параметры инструктора для сравнения (instructorId, name, surname)
//
// 3. для тестирования copyCourse требуется передать в Sample Input следующие параметры:
//  - название метода (copyCourse)
//  - instructorId
//  - name
//  - surname
//  - courseId
//  - title
//  - releaseYear
//  - значение newReleaseYear
//
// Sample Input:
// fullName 1 james brown 1 Scala 2024
// Sample Output:
// James Brown 

@main def first(): Unit = {

  class Instructor(val instructorId: Int, val name: String, val surname: String) {
    // возвращает полное имя в виде "Имя Фамилия"
    def fullName(): String = s"${name.capitalize} ${surname.capitalize}"
  }

  class Course(courseId: Int, title: String, val releaseYear: String, instructor: Instructor) {
    // возвращает id из двух частей: значение id курса, значение id инструктора
    def getId(): String = s"$courseId${instructor.instructorId}"

    // проверяет, является ли указанный instructor инструктором курса
    def isTaughtBy(instructor: Instructor): Boolean = {
      this.instructor.instructorId == instructor.instructorId &&
      this.instructor.name == instructor.name &&
      this.instructor.surname == instructor.surname
    }

    // возвращает новый экземпляр класса Course с обновленным значением поля releaseYear
    def copyCourse(newReleaseYear: String): Course = new Course(courseId, title, newReleaseYear, instructor)
  }

  val instructor1 = new Instructor(1, "Victor", "Ivanov")
  val instructor2 = new Instructor(2, "Mary", "Ivanova")
  val course = new Course(1, "First course", "2021", instructor1)

  println(instructor1.fullName())
  println(course.getId())
  println(course.isTaughtBy(instructor1))
  println(course.isTaughtBy(instructor2))
  println(course.copyCourse("2025"))
}