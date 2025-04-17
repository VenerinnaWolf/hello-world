# Классы: конструкторы, поля, методы, использование объектов класса

#            ------            #
#            Классы            #
#            ------            #

# Создадим класс для комплексных чисел

class Complex:
    """Класс для комплексных чисел вида re + im*i.
    Число состоит из двух чисел: re - действительная часть, im - мнимая часть (без i)"""

    # 1. Конструктор класса. self - ссылка на текущий объект класса, как this в других ЯП
    def __init__(self, re=0, im=0):
        self.re = re  # Кладем значения в поля объекта класса - это динамические переменные (для каждого объекта свои)
        self.im = im

    # 2. Статические переменные (доступны во всех объектах класса и для всех одинаковы).
    static_val = 1
    # В них можно хранить, например, константы или количество экземпляров класса в программе

    # 3. Переопределение стандартных методов.
    # а) Метод __str__ для приведения объекта класса к строке (для дальнейшего вывода на экран, например)
    def __str__(self):
        return str(self.re) + " + " + str(self.im) + "i"  # привели к строке вида re + im*i
        # return f"{self.re} + {self.im}i"  # можно было написать и вот так

    # б) Метод + для сложения двух объектов класса
    # С такой реализацией будет работать только для двух объектов класса Complex
    # self + other вызывает метод self.__add__(other)
    def __add__(self, other):
        return Complex(self.re + other.re, self.im + other.im)

    # в) Метод * для умножения.
    # Добавим здесь проверки, чтобы можно было умножать и на другие типы данных
    # self * other вызывает метод self.__mul__(other)
    def __mul__(self, other):
        re, im = 0, 0  # заглушки для переменных
        # isinstance() проверяет принадлежность объекта определенному типу
        if isinstance(other, Complex):  # если other - комплексное число
            re = self.re * other.re - self.im * other.im
            im = self.re * other.im + self.im * other.re

        elif isinstance(other, int) or isinstance(other, float):  # если other - целое или вещественное число
        # elif isinstance(other, int | float):  # можно было написать так (python 3.10 и выше)
        # elif isinstance(other, (int, float)):  # или так, это уже просто синтаксис самой функции
            re = self.re * other
            im = self.im * other

        else:  # иначе будем выбрасывать ошибку с помощью созданного нами класса ComplexError (ниже)
            error = ComplexMultError("Multiplication error", self, other)  # конструируем объект класса - ошибку
            raise error  # выбрасываем исключение
        return Complex(re, im)

    # г) Метод * для `правого` умножения (когда что-то умножается на текущий объект)
    # other * self вызывает метод other.__rmul__(self), если не удалось вызвать обычный __mul__
    # Но мы не будем писать def __rmul__(self, other). Т.к. он идентичен обычному умножению, мы напишем так:
    __rmul__ = __mul__

# -----------------------
# -- Обработчик ошибок --
# -----------------------

# Создадим класс для обработки ошибок умножения в нашем классе.
# Нужно обязательно указывать, что он наследуется от BaseException

class ComplexMultError(Exception):
    def __init__(self, message, complex, other):
        self.message = message
        self.arg1 = complex
        self.arg2 = other

# -----------------------
# -- Экземпляры класса --
# -----------------------

# 1. Создание объекта класса
a = Complex()  # 0 + 0i
b = Complex(1, 2)  # 1 + 2i
c = Complex(2)  # 2 + 0i
d = Complex(im=3)  # 0 + 3i

# 2. Доступ к полям класса
print(f"{b.re} + {b.im}i")  # => 1 + 2i

# 3. Использование переопределенных методов:

# а) метод __str__ для печати объекта на экран
print(c)  # => 2 + 0i

# б) метод + = __add__ для сложения двух объектов:
print(b + c)  # => 3 + 2i
print(b + 1)  # => Ошибка, наш метод add работает только с двумя объектами типа Complex

# в) метод * = __mul__ для умножения двух объектов:
print(b * c)  # => 2 + 4i
print(b * 3)  # => 3 + 6i, т.е. работает и с целыми числами
print(b * 0.5)  # => 0.5 + 1.0i, т.е. работает и с вещественными числами

# г) метод * = __rmul__ правое умножение:
print(3 * b)  # => 3 + 6i

# 4. Обработка исключений

# Мы можем просто написать строку с ошибкой:
print(b * "abc")  # => ошибка ComplexMultError: ('Multiplication error', <__main__.Complex object at 0x00000294CAC14F50>, 'abc')

# А можем написать блок try ... except, чтобы программа не останавливала свою работу.
try:
    print(b * "abc")
except ComplexMultError as ce:
    print(f'Multiplication error. Arguments: {ce.arg1}, {ce.arg2}')
