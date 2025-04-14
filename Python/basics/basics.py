# print(), input(), линтер, арифметические операции, кавычки и спецсимволы

#            -------------------------------            #
#            Вывод на экран. Функция print()            #
#            -------------------------------            #

print("Hello, World!")

# -- Функция print() может принимать несколько параметров --

# По умолчанию она ставит пробел между парамерами
print('2 + 3 =', 2 + 3)  # => 2 + 3 = 5
# Но можно установить свой разделитель sep (любую строку)
print(1, 2, 3, 4, sep=' + ')  # => 1 + 2 + 3 + 4

# После каждой функции print() по умолчанию осуществляется перевод строки
# Чтобы это изменить, можно установить свой параметр end (любую строку)

print(1, 2, 3, 4, sep=' + ', end='')
print(' = ', 1 + 2 + 3 + 4, sep='')
# => 1 + 2 + 3 + 4 = 10


#            ------------------------------            #
#            Чтение данных. Функция input()            #
#            ------------------------------            #

name = input()
print('I love', name)

# Функция input() всегда возвращает строку.
# Чтобы иметь другой тип данных, придется привести к нему:
a = int(input())
b = int(input())
print(a + b)

# Иногда для чтения данных лучше использовать файлы. Об этом подробнее в files.py

#            -----------------------------            #
#            Линтер (стандарт кодирования)            #
#            -----------------------------            #

# Общий стандарт в Python - PEP8 https://peps.python.org/pep-0008/
# Программы, проверяющие на соответствие этому стандарту называются линтерами.
# Самый популярный линтер:
# flake8 https://flake8.pycqa.org/en/latest/user/error-codes.html


#            -----------------------            #
#            Арифметические операции            #
#            -----------------------            #

1 + 2   # сложение
1 - 2   # вычитание
1 * 2   # умножение
1 ** 2  # возведение в степень
1 / 2   # деление (результат - float)
1 // 2  # целочисленное деление
1 % 2   # остаток от деления
-3      # унарный оператор -

# Чтобы вывести результат на экран, нужно написать print:
print(1 + 2)    # => 3
print(-8 / -4)  # => 2.0 (то есть можно минусы в скобочки не ставить)

# Арифметические операции с присвоением: +=, -=, *=, **=, /=, //=, %=

#            ---------------------            #
#            Кавычки и спецсимволы            #
#            ---------------------            #

# -- Спецсимволы --

# Экранирование \
# Переход на следующую строку \n
# Табуляция \t,
# Возврат каретки \r — работает только в Windows
print("- Are you hungry?\n- Aaaarrrgh!")

# Экранирование (\) кавычек
print("Dragon's mother said \"No\"")

# Экранирование обратного слеша
print("\\")     # => \
