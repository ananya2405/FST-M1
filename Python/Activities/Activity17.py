import pandas as pd

# Creating a data dictionary
data = {
    "Username": ["Admin", "Charles", "Deku"],
    "Password": ["Password", "Charl13", "AllMight"]
}
# Create the dataframe using the data
dataframe = pd.DataFrame(data)

# Printing the dataframe
print(dataframe)

# Writing the data to the csv file
dataframe.to_csv("cred.csv")