package dev.limanoel.duelPlugin.manager
import org.bukkit.entity.Player
import org.bukkit.Location
import java.util.*


class DuelManager {

    private val queue: Queue<Player> = LinkedList()
    private val activeDuels = HashMap<UUID, UUID>()

    fun joinQueue(p: Player) {
        if (queue.contains(p)) return

        if (queue.isEmpty()) {
            queue.add(p)
            p.sendMessage("§aWarte auf Gegner...")
        } else {
            val opponent = queue.poll()
            startDuel(p, opponent)
        }
    }

    private fun startDuel(p1: Player, p2: Player) {

        val map = MapManager.getRandomMap()

        p1.teleport(map["spawn1"]!!)
        p2.teleport(map["spawn2"]!!)

        KitManager.giveKit(p1)
        KitManager.giveKit(p2)

        activeDuels[p1.uniqueId] = p2.uniqueId
        activeDuels[p2.uniqueId] = p1.uniqueId
    }

    fun endDuel(winner: Player, loser: Player) {

        activeDuels.remove(winner.uniqueId)
        activeDuels.remove(loser.uniqueId)

        DuelPlugin.economy.depositPlayer(winner, 1000.0)

        winner.sendMessage("§aDu hast gewonnen!")
    }

    fun isInDuel(p: Player): Boolean {
        return activeDuels.containsKey(p.uniqueId)
    }
}