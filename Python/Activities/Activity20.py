import pandas as pd

# Reading the excel file and printing its data
dataframe = pd.read_excel("sample.xlsx")
print(dataframe)

# Printing the number of rows and columns of the excel
print(dataframe.shape)

# Printing the data in the emails column only
print(dataframe["Email"])

# Sorting the data based on FirstName in ascending order and print the data
print(dataframe.sort_values("FirstName"))

