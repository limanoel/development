package dev.limanoel.duelPlugin.manager

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.util.*

object KitManager {

    private val kits = HashMap<UUID, String>()

    fun setKit(p: Player, kit: String) {
        kits[p.uniqueId] = kit
    }

    fun getKit(p: Player): String? {
        return kits[p.uniqueId]
    }

    fun giveKit(p: Player) {

        p.inventory.clear()

        when (getKit(p)) {

            "pvp" -> {
                p.inventory.addItem(ItemStack(Material.DIAMOND_SWORD))
                p.inventory.addItem(ItemStack(Material.GOLDEN_APPLE, 8))
            }

            "archer" -> {
                p.inventory.addItem(ItemStack(Material.BOW))
                p.inventory.addItem(ItemStack(Material.ARROW, 32))
            }
        }
    }
}