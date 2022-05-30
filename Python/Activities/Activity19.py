import pandas as pd
from pandas import ExcelWriter

# Creating data dictionary
data = {
    "FirstName": ["Satvik", "Avinash", "Lahri"],
    "LastName": ["Shah", "Kati", "Rath"],
    "Email": ["satshah@example.com", "avinashk@example.com", "lahri.rath@example.com"],
    "PhoneNumber": ["4537829158", "5892184058", "4528727830"]
}
# Creating a datafarme with the above dictionary
dataframe = pd.DataFrame(data)

# Printing the dataframe
print(dataframe)

# Writing the data in an excel file
writer = ExcelWriter("sample.xlsx")
dataframe.to_excel(writer, "Sheet1", index=False)

# Saving the excel file
writer.save()
