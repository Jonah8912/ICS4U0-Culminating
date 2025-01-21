import pandas as pd
import requests
from io import StringIO

# URL of the webpage to scrape data from
url = "https://fbref.com/en/comps/9/stats/Premier-League-Stats"

# Fetch the HTML content from the URL and clean it by removing HTML comments
html_content = requests.get(url).text.replace("<!--", "").replace("-->", "")

# Read the HTML content into a DataFrame
df = pd.read_html(StringIO(html_content))[2]

# Set the DataFrame columns to the second level of the multi-index
df.columns = df.columns.get_level_values(1)

# Iterate over the rows of the DataFrame
for index, row in df.iterrows():
    # Drop rows where the "Rk" column has the value "Rk"
    if row["Rk"] == "Rk":
        df.drop(index, inplace=True)

# If the "Age" column exists, split the age range and keep only the first part
if "Age" in df.columns:
    df["Age"] = df["Age"].str.split("-").str[0]

# Remove duplicated columns
df = df.loc[:,~df.columns.duplicated()].copy()

# Drop specific columns by their index
df.drop(df.columns[[0,10,16,20,22,23,24,25,26,27,28]], axis=1, inplace=True)

# Save the cleaned DataFrame to a CSV file
df.to_csv("stats.csv", index=False)