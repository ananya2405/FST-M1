# user input
items = tuple(input("Please enter your list of items separated with a comma = ").split(","))

# Printing the numbers from the list that are divisible by 5
print("The items divisible by 5 from the list are = ")
for item in items:
    if int(item) % 5 == 0:
        print(item)
