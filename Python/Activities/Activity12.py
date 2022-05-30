# Defining a function to print the sum of numbers from 0 to 10
def sum(number):
    if number <= 1:
        return number

    else:
        return number + sum(number-1)

# function call
print("The sum is = " , sum(10))