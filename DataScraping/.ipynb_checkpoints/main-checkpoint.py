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


df.drop(["Rk", "Matches", "90s", "npxG", "npxG+xAG", "PrgC", "PrgP","PrgR"], axis=1, inplace=True)



df.to_csv("stats.csv", index=False)
