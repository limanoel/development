package dev.limanoel.duelPlugin.listener

import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.*
import org.bukkit.event.inventory.InventoryClickEvent

class DuelKitListener(private val duelManager: DuelManager) : Listener {

    @EventHandler
    fun onClick(e: InventoryClickEvent) {

        val p = e.whoClicked as? Player ?: return

        if (e.view.title != "§8Kit auswählen") return

        e.isCancelled = true

        val item = e.currentItem ?: return
        val meta = item.itemMeta ?: return

        when (meta.displayName) {

            "§aPvP Kit" -> {
                KitManager.setKit(p, "pvp")
                duelManager.joinQueue(p)
                p.closeInventory()
            }

            "§eArcher Kit" -> {
                KitManager.setKit(p, "archer")
                duelManager.joinQueue(p)
                p.closeInventory()
            }
        }
    }
}