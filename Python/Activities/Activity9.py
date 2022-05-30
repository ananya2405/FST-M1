# User input for the 2 lists
items1 = list(input("Please enter your list of items separated with a comma = ").split(","))
items2 = list(input("Please enter your list of items separated with a comma = ").split(","))

# declaring the third list
newitemlist = []

# adding only even numbers from first list
for item in items1:
    if int(item) % 2 == 0:
        newitemlist.append(item)

# adding only odd numbers from second list
for item in items2:
    if int(item) % 2 != 0:
        newitemlist.append(item)

# print the final list
print("The final list is = " + str(newitemlist))