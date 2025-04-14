# Преобразование типов и переменные

#            --------------------------            #
#            Явное преобразование типов            #
#            --------------------------            #

# Python - язык со строгой типизацией, в отличие от PHP или JavaScript

# ------------------------------------------
# -- int() - преобразование в целое число --
# ------------------------------------------

# -- Строки --
converted_value = int('10')    # => 10
converted_value = int('')      # => Ошибка ValueError
converted_value = int('Text')  # => Ошибка ValueError

# -- Булевые переменные --
converted_value = int(False)   # => 0
converted_value = int(True)    # => 1

# -- Вещественные числа --
converted_value = int(3.61)     # => 3

# -------------------------------------
# -- str() - преобразование в строку --
# -------------------------------------

value = str(10)    # '10'
value = str(10.1)  # '10.1'
value = str(True)  # 'True'
value = str()      # ''

# ---------------------------------------------------
# -- float() - преобразование в вещественное число --
# ---------------------------------------------------

value = float(5)   # 5.0

# В операциях с float, все int неявно преобразуются в float
value = 3 + 1.2    # 4.2 (неявно выполняется код float(3) + 1.2)


#            ---------            #
#            Пременные            #
#            ---------            #

euros_count = 100
dollars = euros_count * 1.25
a, b, c = 1, 2, 3

# ---------------------------------
# -- Определение типа переменной --
# ---------------------------------

a = 1
b = '123'
c = (1, (2, 3), 4)
type(a)  # => <class 'int'>
type(b)  # => <class 'str'>
type(c)  # => <class 'tuple'>

# ---------------------------
# -- Именование переменных --
# ---------------------------

# kebab-case — составные части переменной разделяются дефисом (my-super-var)
# snake_case — для разделения используется подчеркивание (my_super_var)
# CamelCase — каждое слово в переменной пишется с заглавной буквы (MySuperVar)
# В Python используется snake_case

# ---------------------------------------
# -- Локальные и глобальные переменные --
# ---------------------------------------

# Использование глобальных переменных внутри функций - очень плохой тон!

# 1. *Глобальные* переменные видны внутри функций
def f():
    print(a)
a = 1   # Глобальная
f()     # => 1 (Никакой ошибки)

# 2. Переменные, определенные внутри функций, считаются *локальными*
def f():
    a = 1   # Локальная
f()         # => 1
print(a)    # => NameError: name 'a' is not defined

# 3. Локальные переменные можно называть так же, как глобальные
def f():
    a = 1   # Локальная
    print(a)
a = 0       # Глобальная
f()         # => 1
print(a)    # => 0

# Даже если присваивание никогда не выполнится, переменная будет локальной
def f():
    print(a)
    if False:
        a = 0  # Локальная
a = 1   # Глобальная
f()     # => UnboundLocalError: local variable 'a' referenced before assignment

# 4. Принудительное указание глобальной переменной
def f():
    global a    # Указание, что функция может менять глобальную переменную a
    a = 1   # Глобальная
    print(a, end=' ')
a = 0       # Глобальная
print(a)    # => 0
f()         # => 1
print(a)    # => 1

# --------------
# -- Константы --
# --------------

# Те же переменные, но пишутся заглавными буквами (и, увы, их можно поменять)
PI = 3.14
