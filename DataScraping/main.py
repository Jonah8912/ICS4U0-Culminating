import pandas as pd
import requests
from io import StringIO

url = "https://fbref.com/en/comps/9/stats/Premier-League-Stats"

html_content = requests.get(url).text.replace("<!--", "").replace("-->", "")

df = pd.read_html(StringIO(html_content))[2]

df.columns = df.columns.get_level_values(1)

for index, row in df.iterrows():
    if row["Rk"] == "Rk":
        df.drop(index, inplace=True)

if "Age" in df.columns:
    df["Age"] = df["Age"].str.split("-").str[0]

df = df.loc[:,~df.columns.duplicated()].copy()

df.drop(df.columns[[0,10,16,20,22,23,24,25,26,27,28]], axis=1, inplace=True)

df.to_csv("stats.csv", index=False)

