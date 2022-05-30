# user input for name & age
name = input("Please enter your name")
age = int(input("Please enter your age"))

# Finding the year in which the user's age will turn 100
temp = (2022-age)+100
print(temp)
print("Hi "+name+", you will turn 100 in the year " + str(temp))
