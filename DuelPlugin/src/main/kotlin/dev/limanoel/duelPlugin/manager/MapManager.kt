package.dev.limanoel.duelPlugin.manager

import org.bukkit.Bukkit
import org.bukkit.Location

object MapManager {

    fun getRandomMap(): Map<String, Location> {

        val world = Bukkit.getWorld("duel_map")!!

        val spawn1 = Location(world, 100.0, 65.0, 100.0)
        val spawn2 = Location(world, 120.0, 65.0, 120.0)

        return mapOf(
            "spawn1" to spawn1,
            "spawn2" to spawn2
        )
    }
}