package me.abetgt.villagertradeevent;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.MerchantRecipe;

public final class VillagerTradeListener implements Listener {

    @EventHandler
    public void onVillagerTrade(InventoryClickEvent event) {
        if (event.getClickedInventory() instanceof MerchantInventory inventory) {
            Integer slotClick = event.getSlot();
            MerchantInventory villagerMerchantInventory = inventory;
            ItemStack slotItem = villagerMerchantInventory.getItem(slotClick);
            MerchantRecipe villagerMerchantRecipe = villagerMerchantInventory.getSelectedRecipe();
            if (slotClick != 2){return;}
            if (slotItem != null || slotItem.getType() != Material.AIR){
                Merchant entity = villagerMerchantInventory.getMerchant();
                TradeEvent villagerTradeEvent = new TradeEvent(
                        (Player) entity.getTrader(),
                        entity,
                        villagerMerchantInventory,
                        villagerMerchantRecipe,
                        slotItem,
                        slotClick,
                        villagerMerchantRecipe.getAdjustedIngredient1(),
                        villagerMerchantRecipe.getMaxUses(),
                        villagerMerchantRecipe.getVillagerExperience()
                );
                Bukkit.getServer().getPluginManager().callEvent(villagerTradeEvent);
                if (villagerTradeEvent.isCancelled()){ event.setCancelled(true); }
            }
        }
    }
}
