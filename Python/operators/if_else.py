#            ------------------------------            #
#            Условный оператор: if ... else            #
#            ------------------------------            #

# Обязательно соблюдать отступ в 4 пробела или один tab.
# Блок else необязателен

x = int(input())
if x >= 0:
    print(x)
else:
    print(-x)

# ---------------------------------
# -- Вложенный условный оператор --
# ---------------------------------

eyes = int(input())
legs = int(input())
if eyes >= 8:
    if legs == 8:
        print("spider")
    else:
        print("scallop")
else:
    if legs == 6:
        print("bug")
    else:
        print("cat")

# -------------------------------
# -- Конструкция "иначе-если" --
# --   if ... elif ... else   --
# -------------------------------

number = int(input())
if number == 1:
    print('One')
elif number == 2:
    print('Two')
else:
    print('Other')
