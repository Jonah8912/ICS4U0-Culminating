package com.stats.TopBallerStats.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Player entities.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
}