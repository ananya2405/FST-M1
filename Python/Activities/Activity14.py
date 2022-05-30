# Defining function to generate fibonnaci series till a user defined number
def fibo(num):
    i = 0
    temp = 1
    prevnum = 0
    print(str(prevnum))
    print(str(temp))
    while i < num-2:
        nxtnum = temp + prevnum
        prevnum = temp
        temp = nxtnum
        print(str(nxtnum))
        i = i+1

# User input
number = int(input("Please enter a number: "))
if number < 1:
    print("Please enter a positive number")
    number = int(input("Please enter a number: "))

# calling the function
fibo(number)