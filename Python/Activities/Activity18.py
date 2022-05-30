import pandas as pd

dataframe = pd.read_csv("cred.csv")
print("Full data table : ")
print(dataframe)

print("Printing the values only in the Usernames column : ")
print(dataframe["Username"])

print("Printing the username and password of the second row : ")
print(dataframe["Username"][1], dataframe["Password"][1])

print("Sorting the Usernames column in ascending order : ")
print(dataframe.sort_values("Username"))

print("Sorting the Passwords column in descending order : ")
print(dataframe.sort_values("Password", ascending=False))




