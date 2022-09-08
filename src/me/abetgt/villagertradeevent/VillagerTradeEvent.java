package me.abetgt.villagertradeevent;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.MerchantRecipe;

public final class VillagerTradeEvent extends PlayerEvent implements Cancellable {
    public static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;

    private Merchant eventvillager;
    private ItemStack eventItem;
    private MerchantInventory eventMerchantInventory;
    private MerchantRecipe eventMerchantRecipe;
    private Integer eventReturnSlot;

    /**
     * An event that triggers when a player trades with a villager/merchant.
     * Please do not use anything that has event like getEventPlayer(). They are deprecated.
     */
    public VillagerTradeEvent(Player player,
                      Merchant villager,
                      MerchantInventory merchantInventory,
                      MerchantRecipe merchantRecipe,
                      ItemStack returnItem,
                      Integer returnSlot
    ){
        super(player);
        eventvillager = villager;
        eventItem = returnItem;
        eventMerchantInventory = merchantInventory;
        eventMerchantRecipe = merchantRecipe;
        eventReturnSlot = returnSlot;
    }

    /**
     * Returns the merchant/villager/entity involved in the trade.
     * @return Returns the merchant/villager/entity.
     */
    public Merchant getMerchant() {return eventvillager;}

    /**
     * Returns the MerchantInventory.
     */
    public MerchantInventory getMerchantInventory() {return eventMerchantInventory;}

    /**
     * Returns the MerchantRecipe.
     */
    public MerchantRecipe getMerchantRecipe() {return eventMerchantRecipe;}

    /**
     * Returns the item involved in this event.
     * @return Returns the item.
     */
    public ItemStack getItem() {return eventItem;}

    /**
     * Returns the item slot involved in this event.
     * <p>This is an integer. If you are looking at getting the item, please use getItem().</p>
     * @return Returns the item slot involved.
     */
    public Integer getItemSlot() {return eventReturnSlot;}

    public static HandlerList getHandlerList(){
        return handlers;
    }

    public HandlerList getHandlers(){
        return handlers;
    }

    public boolean isCancelled(){
        return this.cancel;
    }

    public void setCancelled(boolean cancel){
        this.cancel = cancel;
    }
}
