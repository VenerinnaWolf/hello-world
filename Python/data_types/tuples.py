# Кортежи: арифметические операции, преобразование типов, срезы, распаковка и упаковка кортежа

#            -------            #
#            Кортежи            #
#            -------            #

# Кортежи во многом действуют как строки: +, *, срезы, len()
# ! Кортеж - это неизменяемый тип данных

a = (1, 2, 3)
b = (4, 5, 6)

# -- Кортеж из одного элемента (синглтон) --
c = (1)     # Это не кортеж! Это int
d = (1,)    # А это уже кортеж из одного элемента

# -----------------------------
# -- Арифметические операции --
# -----------------------------

# Работают, как со строками
a + b  # => (1, 2, 3, 4, 5, 6)
a * 3  # => (1, 2, 3, 1, 2, 3, 1, 2, 3)

# Важна правильная расстановка скобок
(1, 2) + (3, 4)  # => (1, 2, 3, 4)
1, 2 + 3, 4      # => (1, 5, 4)

# --------------------------
# -- Преобразование типов --
# --------------------------

# -- Преобразование строки в кортеж: tuple() --
string = '123'
my_tuple = tuple(string)  # => ('1', '2', '3')

# -- Преобразование кортежа в строку: str() --
my_tuple = (1, 2, 3)
string = str(my_tuple)  # => '(1, 2, 3)'

# --------------------------------
# -- Доступ к элементам кортежа --
# --------------------------------

my_tuple = (('a', 1, 3.14), 'abc', ((1), (2, )))
my_tuple[0]   # ('a', 1, 3.14)
my_tuple[1]   # 'abc'
my_tuple[2]   # ((1), (2, )) - кортеж состоящий из числа 1 и синглтона (2, )
my_tuple[2][1]   # (2,)
my_tuple[2][1][0]   # 2

# -----------
# -- Срезы --
# -----------

my_tuple = (1, 2, 3)

# Если в срезе более одного параметра, то будет формироваться кортеж (даже если это синглтон)
my_tuple[1:]    # (2, 3)
my_tuple[2]     # 3
my_tuple[2:]    # (3,)

# -----------------------------------
# -- Распаковка и упаковка кортежа --
# -----------------------------------

manDesc = ("Ivan", "Ivanov", 28)
name, surname, age = manDesc
# Теперь в переменных лежат значения: name = "Ivan", surname = "Ivanov", age = 28

a, b, c = 1, 2, 3
a, b, c = c, b, a
print(a, b, c)   # => 3, 2, 1
# Это не эквивалентно записи a = c; b = b; c = a. Тут результат - 3, 2, 3
