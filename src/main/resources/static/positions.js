document.getElementById("position-dropdown").addEventListener("change", () => {
    const fullPositionName = document.getElementById("position-dropdown").value;

    // Map full position names to their abbreviations
    const positionAbbreviations = {
        Forward: "FW",
        Midfielder: "MF",
        Defender: "DF",
        Goalkeeper: "GK",
    };

    // Get the abbreviated position name
    const positionAbbreviation = positionAbbreviations[fullPositionName];

    // Check if the selection is valid
    if (!positionAbbreviation) {
        console.error("Invalid position selected!");
        return;
    }

    // Fetch data for the selected position
    fetch(`http://www.topballerstats.live/player?position=${encodeURIComponent(positionAbbreviation)}`)
        .then((response) => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then((data) => {
            const statsSection = document.getElementById("position-stats-section");
            const statsBody = document.getElementById("position-stats-body");
            const positionNameHeader = document.getElementById("position-name");

            statsSection.style.display = "block"; // Show the stats section
            statsBody.innerHTML = ""; // Clear previous table data
            positionNameHeader.textContent = fullPositionName; // Update the header

            if (data.length === 0) {
                statsBody.innerHTML = `
                    <tr>
                        <td colspan="18">No players found for the position "${fullPositionName}".</td>
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
            console.error("Error fetching players by position:", err);
        });
});