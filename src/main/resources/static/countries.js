// Search button click event
document.getElementById("search-btn").addEventListener("click", () => {
    const countryName = document.getElementById("search-bar").value.trim();

    if (!countryName) {
        alert("Please enter a country.");
        return;
    }

    // Fetch data from the backend
    fetch(`http://www.topballerstats.live/player?nation=${encodeURIComponent(countryName)}`)
        .then((response) => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then((data) => {
            const statsSection = document.getElementById("country-stats-section");
            const statsBody = document.getElementById("country-stats-body");
            const countryNameHeader = document.getElementById("country-name");

            // Show the stats section and clear any previous results
            statsSection.style.display = "block";
            statsBody.innerHTML = "";
            countryNameHeader.textContent = countryName;

            if (data.length === 0) {
                statsBody.innerHTML = `
                    <tr>
                        <td colspan="15">No players found for the country "${countryName}".</td>
                    </tr>`;
                return;
            }

            // Populate the table with data
            data.forEach((player) => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${player.name}</td>
                    <td>${player.nation}</td>
                    <td>${player.position}</td>
                    <td>${player.team_name}</td>
                    <td>${player.age}</td>
                    <td>${player.year_born}</td>
                    <td>${player.matches_played}</td>
                    <td>${player.starts || "N/A"}</td>
                    <td>${player.minutes_played || "N/A"}</td>
                    <td>${player.goals}</td>
                    <td>${player.assists}</td>
                    <td>${player.goals_assists}</td>
                    <td>${player.goals_assists_nopk}</td>
                    <td>${player.penalties_scored}</td>
                    <td>${player.yellow_cards}</td>
                    <td>${player.red_cards || "N/A"}</td>
                    <td>${player.expected_goals.toFixed(2)}</td>
                    <td>${player.expected_assists.toFixed(2)}</td>
                `;
                statsBody.appendChild(row);
            });
        })
        .catch((err) => {
            console.error("Error fetching players by country:", err);
        });
});