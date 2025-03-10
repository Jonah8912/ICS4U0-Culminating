document.getElementById("search-btn").addEventListener("click", () => {
    const playerName = document.getElementById("search-bar").value.trim();

    const url = playerName
        ? `https://topballerstats.live/player?name=${encodeURIComponent(playerName)}`
        : "https://topballerstats.live/player";

    fetch(url)
        .then((response) => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then((data) => {
            const statsBody = document.getElementById("player-stats-body");
            const statsSection = document.getElementById("player-stats-section");

            statsBody.innerHTML = "";
            statsSection.style.display = "block";

            if (data.length === 0) {
                statsBody.innerHTML = `
                    <tr>
                        <td colspan="18" style="text-align: center;">
                            ${playerName ? "Player not found. Please try a different search." : "No players found."}
                        </td>
                    </tr>`;
            } else {
                data.forEach((player) => {
                    const row = document.createElement("tr");
                    row.innerHTML = `
                        <td>${player.name || "N/A"}</td>
                        <td>${player.nation || "N/A"}</td>
                        <td>${player.position || "N/A"}</td>
                        <td>${player.team_name || "N/A"}</td>
                        <td>${player.age || "N/A"}</td>
                        <td>${player.year_born || "N/A"}</td>
                        <td>${player.matches_played || "N/A"}</td>
                        <td>${player.starts ?? "N/A"}</td>
                        <td>${player.minutes_played ?? "N/A"}</td>
                        <td>${player.goals ?? "0"}</td>
                        <td>${player.assists ?? "0"}</td>
                        <td>${player.goals_assists ?? "0"}</td>
                        <td>${player.goals_assists_nopk ?? "0"}</td>
                        <td>${player.penalties_scored ?? "0"}</td>
                        <td>${player.yellow_cards ?? "0"}</td>
                        <td>${player.red_cards ?? "0"}</td>
                        <td>${player.expected_goals ? player.expected_goals.toFixed(2) : "N/A"}</td>
                        <td>${player.expected_assists ? player.expected_assists.toFixed(2) : "N/A"}</td>
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
