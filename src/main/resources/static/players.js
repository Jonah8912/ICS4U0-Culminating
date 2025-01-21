// Search button click event
document.getElementById("search-btn").addEventListener("click", () => {
    const playerName = document.getElementById("search-bar").value.trim();

    if (!playerName) {
        alert("Please enter a player name.");
        return;
    }

    // Fetch player stats based on the entered name
    fetch(`http://topballerstats.live/player?name=${encodeURIComponent(playerName)}`)
        .then((response) => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then((data) => {
            const statsBody = document.getElementById("player-stats-body");
            const statsSection = document.getElementById("player-stats-section");

            // Clear previous results and show the stats section
            statsBody.innerHTML = "";
            statsSection.style.display = "block";

            if (data.length === 0) {
                statsBody.innerHTML = `
                    <tr>
                        <td colspan="18" style="text-align: center;">Player not found. Please try a different search.</td>
                    </tr>`;
            } else {
                // Populate the table with player data
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
            }
        })
        .catch((err) => {
            console.error("Error fetching player stats:", err);
            const statsBody = document.getElementById("player-stats-body");
            statsBody.innerHTML = `
                <tr>
                    <td colspan="18" style="text-align: center;">Error fetching player stats. Please try again later.</td>
                </tr>`;
        });
});