#            ---------            #
#            Цикл: for            #
#            ---------            #

# -------------------
# -- Функция range --
# -------------------

# Функция range генерирует объекты типа iterable, состоящие из целых чисел.

# 1. range(n)
# Генерирует iterable, содержащий последовательные числа от 0 до n-1.
print(tuple(range(10)))  # => (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

# 2. range(from, to)
# Генерирует iterable со всеми числами от from до to-1 включительно.
range(4, 10)      # => 4, 5, 6, 7, 8, 9

# 3. range(from, to, step)
# Генерирует iterable с числами от from, не превышающие to с шагом изменения step.
# Если шаг отрицателен, то from должен быть больше to.
range(4, 10, 3)   # => 4, 7
range(10, 0, -2)  # => 10, 8, 6, 4, 2

# ---------------
# -- Цикл: for --
# ---------------

# Цикл for перебирает элементы tuple или iterable

for color in ('red', 'green', 'yellow'):
    print(color, 'apple')
# red apple
# green apple
# yellow apple

for i in range(1, 100, 2):
    print(i)
# Напечатает нечетные числа от 1 до 99 в столбик

for i in range(1, 11):
    for j in range(1, 11):
        print(i * j, end=' ')
    print()
# Напечатает таблицу умножения
