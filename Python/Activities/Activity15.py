# Exception handling when variable is not defined
try:
    print(name)
except NameError:
    print("Undefined variable!")
