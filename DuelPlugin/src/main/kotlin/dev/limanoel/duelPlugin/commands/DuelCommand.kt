package dev.limanoel.duelPlugin.commands

import dev.limanoel.duelPlugin.manager.DuelManager
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.*
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class DuelCommand(private val duelManager: DuelManager) : CommandExecutor {

    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {

        if (sender !is Player) return true

        openGUI(sender)
        return true
    }

    private fun openGUI(p: Player) {
        val inv = Bukkit.createInventory(null, 27, "§8Kit auswählen")

        val pvp = ItemStack(Material.DIAMOND_SWORD).apply {
            itemMeta = itemMeta?.apply { displayName = "§aPvP Kit" }
        }

        val archer = ItemStack(Material.BOW).apply {
            itemMeta = itemMeta?.apply { displayName = "§eArcher Kit" }
        }

        inv.setItem(11, pvp)
        inv.setItem(15, archer)

        p.openInventory(inv)
    }
}