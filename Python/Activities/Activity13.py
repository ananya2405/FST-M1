# defining function to add the numbers in a list
def sumList(items):
    sum = 0
    for item in items:
        sum = sum + int(item)
    return sum

# user input
listOfNum = list(input("Please enter a list of numbers seprated by comma: ").split(","))

#function call
print("Sum of items is = ", sumList(listOfNum))
