# user input
items = list(input("Please enter your list of items separated with a comma = ").split(","))
sum = 0

# Retrieve the sum of all items in the list
for item in items:
    sum += int(item)
print(sum)



