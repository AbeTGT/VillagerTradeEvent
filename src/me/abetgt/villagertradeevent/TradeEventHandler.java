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
import org.bukkit.plugin.java.JavaPlugin;

public final class TradeEventHandler extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        Metrics metrics = new Metrics(this, 16056);
    }

    private VillagerTradeEvent doTradeEvent(MerchantInventory inventory, int slotClick, ItemStack slotItem){
        MerchantRecipe recipe = inventory.getSelectedRecipe();
        Merchant merchant = inventory.getMerchant();
        return new VillagerTradeEvent(
                (Player) merchant.getTrader(),
                merchant,
                inventory,
                recipe,
                slotItem,
                slotClick
        );
    }

    @EventHandler
    private void onVillagerTrade_InventoryClick(InventoryClickEvent event){
        if (event.getClickedInventory() instanceof MerchantInventory){
            MerchantInventory merchantInventory = (MerchantInventory) event.getClickedInventory();
            int slotClick = event.getSlot();
            ItemStack slotItem = merchantInventory.getItem(slotClick);
            if (slotClick != 2) {return;}
            if (slotItem != null || slotItem.getType() != Material.AIR){
                if (event.getClick() == ClickType.DROP || event.getClick() == ClickType.CONTROL_DROP) {
                    VillagerTradeEvent tradeEvent = doTradeEvent(merchantInventory, slotClick, slotItem);
                    Bukkit.getServer().getPluginManager().callEvent(tradeEvent);
                    if (tradeEvent.isCancelled()) event.setCancelled(true);
                } else {
                    VillagerTradeEvent tradeEvent = doTradeEvent(merchantInventory, slotClick, slotItem);
                    Bukkit.getServer().getPluginManager().callEvent(tradeEvent);
                    if (tradeEvent.isCancelled()) event.setCancelled(true);
                }
            }
        }
    }

}
