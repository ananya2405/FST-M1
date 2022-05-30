# User input
fruitName = input("Please enter the fruit you want = ")

# Creating a dictionary for the fruit shop
fruitShop = {
    "Orange": 10,
    "Apple": 15,
    "Banana": 8,
    "Cucumber": 12
}

# Checking if the chosen fruit is available in the shop
if fruitName in fruitShop:
    print("Your chosen fruit is available in the shop.")

else:
    print("Sorry, your chosen fruit is not available at the moment! ")


