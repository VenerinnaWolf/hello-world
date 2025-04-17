# Ошибки и исключения: обработка исключений, определение пользовательских исключений

#            -------------------            #
#            Ошибки и исключения            #
#            -------------------            #

# У Python есть два типа ошибок: синтаксические ошибки и исключения.

# 1. Синтаксическая ошибка - это обычно пропущенный/лишний знак или другая ошибка грамматических правил:
print("Hello, world"     # => SyntaxError: '(' was never closed
# Синтаксические ошибки обычно фатальны и не позволяют даже запустить код

# 2. Исключения же бывают совершенно разные, от ошибки деления на ноль, обращения к несуществующему индексу списка и пр.
print(3 / 0)    # => ZeroDivisionError: division by zero


# --------------------------
# -- Обработка исключений --
# --------------------------

# 1. Для обработки исключений существует блок try-except:

try:
    a = int(input("Введите число: "))
    b = int(input("Введите еще одно число: "))
    print (a / b)
except ZeroDivisionError:
    print("Ошибка деления на ноль!")
except ValueError:
    print("Ошибка ввода числа")

# 2. Полная форма try-except-else-finally:

# try - пытаемся выполнить код
# except - ловим некоторые ошибки
# else - если ошибок не было, выполняем что-то
# finally - вне зависимости от того, были ли ошибки или нет, делаем еще что-то

# Например, обработка файла:
try:
    # Открытие файла в режиме чтения
    file = open("file.txt", "r")
    print("Successfully opened the file")
except FileNotFoundError:
    # Обработка ошибки, возникающей в том случае, если файл не найден
    print("File Not Found Error: No such file or directory")
    exit()
except PermissionError:
    # Обработка ошибок, связанных с разрешением на доступ к файлу
    print("Permission Denied Error: Access is denied")
else:
    # Всё хорошо - сделать что-то с данными, прочитанными из файла
    content = file.read()
finally:
    # Прибираемся после себя даже в том случае, если выше возникло исключение
    file.close()

# 3. Можно ловить несколько ошибок за раз и давать имя ошибке.

# В блоке except ошибке можно присвоить имя и дальше использовать ее, как объект
a = ["10", "twenty", 30]  # Mixed list of integers and strings
try:
    total = int(a[0]) + int(a[1])  # 'twenty' cannot be converted to int
except (ValueError, TypeError) as e:  # дали имя ошибке и использовали его дальше
    print("Error", e)
except IndexError:
    print("Index out of range.")


# ---------------------------------
# -- Пользовательские исключения --
# ---------------------------------

# В Python можно определять пользовательские исключения.
# Они должны наследоваться от BaseException, Exception
# или любых других классов, являющихся прямыми наследниками Exception.

# BaseException — это общий базовый класс всех исключений.
# Один из его подклассов, Exception, является базовым классом всех нефатальных исключений

# 1. Создадим исключение для некорректного адреса email:
class InvalidEmailAddress(ValueError):
    def __init__(self, message):
        self.message = message

# В статье, откуда я брала, была вот такая реализация, но у меня результат получается такой же.
# class InvalidEmailAddress(ValueError):
#     def __init__(self, message):
#         super().__init__(message)
#         self.msgfmt = message

# 2. Создадим что-нибудь, что выбрасывает это исключение:
def send_email(address):
    if not isinstance(address, str):
        raise InvalidEmailAddress("Invalid email address")  # raise <- здесь выбрасывается исключение

# 3. Теперь триггернем это исключение:
send_email(None)  # => Получили ошибку - InvalidEmailAddress: Invalid email address
