# user input
items = list(input("Please enter your list of items separated with a comma = ").split(","))

# comparing the first and last item in the list
if items[0] == items[-1]:
    print("Match found")
else:
    print("No match!")



