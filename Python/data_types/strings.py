# Строки: форматирование строк, multi-line строки, функции и методы для работы со строками, срезы строк

#            ------            #
#            Строки            #
#            ------            #

# -- Умножение на число --
print('+' * 5)  # => '+++++'

# -------------------------------------
# -- 5 способов форматирования строк --
# -------------------------------------

name = "Дмитрий"
age = 25

# 1. Конкатенация
print("Меня зовут " + name + ". Мне " + str(age) + " лет.")

# 2. %-форматирование

# Передавать значения в строку можно через списки, кортежи и словари.
# Во втором случае значения помещаются не по позиции, а по имени.
print("Меня зовут %s. Мне %d лет." % (name, age))
print("Меня зовут %(name)s. Мне %(age)d лет." % {"name": name, "age": age})

# 3. Template-строки
s = Template('Меня зовут $name. Мне $age лет.')
print(s.substitute(name=name, age=age))

# 4. Форматирование с помощью метода format()
print("Меня зовут {}. Мне {} лет.".format(name, age))
print("Меня зовут {name} Мне {age} лет.".format(age=age, name=name))

# 5. Интерполяция или же f-строки.
print(f"Меня зовут {name} Мне {age} лет.")

# -----------------------
# -- Multi-line строки --
# -----------------------

# Пишется внутри тройных кавычек (как """, так и ''')
# Не требует написания \n для переноса строки
# Не требует экранирования кавычек
text = """Здесь не нужно экранировать
'одинарные' и
"двойные" кавычки"""

# -- Из таких строк можно делать f-строки --
a = 'A'
b = 'B'
text = f'''{a} и {b}
сидели на трубе'''

# -----------------------
# -- Некоторые функции --
# -----------------------

# -- Длина строки: len() --
print(len('Hello!'))  # => 6

# -- Перевод значения Unicode в символ --
print(chr(63))   # => '?'

# -- Перевод символа в номер в кодировке Unicode --
print(ord('?'))  # => 63

# -- Преобразование типа в строку --
str(5)

# ----------------------
# -- Некоторые методы --
# ----------------------

name = 'Python'

# 1. .find() - Индекс первого вхождения подстроки в строку
name.find('th')        # 2

# Второй необязательный параметр - начало (поиск в подстроке s[from:])
name.find('th', 2)     # 2 (нумерация останется как в исходной строке)

# Третий необязательный параметр - конец (поиск в подстроке s[a:b])
name.find('th', 2, 5)  # 2 (нумерация останется как в исходной строке)

# Если вхождение не найдено, возвращает -1

# 2. .rfind() - Индекс последнего вхождения подстроки в строку
'abcda'.rfind('a')     # 4
# Аналогично с find имеет второй и третий необязательные параметры

# 3. .replace(old, new) - Замена всех вхождений подстроки old на подстроку new
name.replace('on', 'off')  # 'Pythoff'
'AAAAAA'.replace('AA', 'A')  # 'AAA', а не 'A'

# Модификация replace(old, new, count) осуществляет не более count замен
'AAAAAA'.replace('AA', 'A', 1)  # 'AAAAA'

# 4. .count() - Количество вхождений подстроки
'AAAAAA'.count('AA')   # 3
# Аналогично с find имеет второй и третий необязательные параметры

# 5. Верхний регистр: .upper()
name.upper()  # => 'PYTHON'

# 6. Нижний регистр: .lower()
name.lower()  # 'python'

# 7. Разрезание строки: .split()
# Разрезает по пробелам, табуляциям и переводам строк. Возвращает список
print('red green        blue'.split())  # => ['red', 'green', 'blue']

# 8. Склеивание строки: .join()
# Вызывается от разделителя между элементами. Принимает только iterable строк
print(', '.join(['Veni', 'Vidi', 'Vici']))  # => 'Veni, Vidi, Vici'

# 9. isalpha - проверяет, что все символы строки являются буквами.
# 10. isdigit - проверяет, что все символы строки являются цифрами.
# 11. isalnum - проверяет, что все символы строки являются буквами или цифрами.
# 12. islower - проверяет, что все символы строки являются маленькими (строчными) буквами.
# 13. isupper - проверяет, что все символы строки являются большими (заглавными, прописными) буквами.
# 14. lstrip - обрезает все пробельные символы в начале строки.
# 15. rstrip - обрезает все пробельные символы в конце строки.
# 16. strip - обрезает все пробельные символы в начале и конце строки.


#            -----------------------            #
#            Срез строки (подстрока)            #
#            -----------------------            #

# Спецсимволы вроде \n считаются за один символ
# Отрицательные индексы начинают отсчет от конца строки

# ----------------------------------------------------
# -- Обращение по индексу (срез с одним параметром) --
# ----------------------------------------------------

# Это простейший срез с одним параметром

first_name = 'Alexander'
print(first_name[0])  # => A
print(first_name[-1])  # => r

# Наглядно продемонстрирую нумерацию символов в строке "Hexlet":
#    H     e     x     l     e     t
#   [0]   [1]   [2]   [3]   [4]   [5]
#   [-6]  [-5]  [-4]  [-3]  [-2]  [-1]

# Изменять значение по индексу нельзя
first_name[0] = 'B'  # TypeError: 'str' object does not support item assignment

# ------------------------------
# -- Срез с двумя параметрами --
# ------------------------------

date = '12-08-2034'
year = date[6:10]  # подстрока с 6 индекса по 10 индекс, не включая 10-й
print(year)  # => 2034

value = 'Hexlet'

# 1. Можно не указывать одну из границ
value[3:]    # 'let'
value[:3]    # 'Hex'
value[:]     # 'Hexlet'

# 2. Можно указывать отрицательные индексы

# Правая граница отрицательная. Считаем -1 от конца строки
value[3:-1]  # 'le'
# Левая граница отрицательная. Считаем -5 от конца строки
value[-5:3]  # 'ex'

# 3. Если первый параметр находится правее второго, получим пустую строку
value[3:1]   # ''

# --------------------------------------
# -- Шаг извлечения (третий параметр) --
# --------------------------------------

# Добавим необязательный третий параметр

# По умолчанию этот шаг = 1.
# Шаг 2 это каждый второй в подстроке (индексы [0], [2] и т.д).
# Если взять срез S[a:b:d],
#   то в результате будут взяты символы с индексами a, a+d, a+2*d и т.д

value[1:5:2]  # el
# 1:5 это подстрока 'exle'
# 1:5:2 - шаг 2 это [0], [2] и т.д, то есть 'e' и 'l'

value[:5:2]   # 'Hxe'
value[1::2]   # 'elt'

# -- Отрицательный шаг извлечения --

# Переворот строки
value[::-1]  # 'telxeH'
# Если шаг отрицательный, и элементы извлекаются в обратном порядке
#   — тогда и границы среза тоже нужно указывать в обратном порядке.
# Первой указывается правая граница среза, второй — левая:
value[4:1:-1]  # 'elx'