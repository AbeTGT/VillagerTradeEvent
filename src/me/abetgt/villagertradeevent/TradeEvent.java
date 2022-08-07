package me.abetgt.villagertradeevent;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.MerchantRecipe;;

public final class TradeEvent extends Event implements Cancellable {
    public static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;

    private Player eventPlayer;
    private Merchant eventvillager;
    private ItemStack eventItem;
    private ItemStack eventgetAdjustedIngredient1;
    private Integer eventgetMaxUses;
    private MerchantInventory eventMerchantInventory;
    private MerchantRecipe eventMerchantRecipe;
    private Integer eventVillagerExperience;
    private Integer eventReturnSlot;

    /**
     * An event that triggers when a player trades with a villager/merchant.
     * Please do not use anything that has event like getEventPlayer(). They are deprecated.
     */
    public TradeEvent(Player player,
                      Merchant villager,
                      MerchantInventory merchantInventory,
                      MerchantRecipe merchantRecipe,
                      ItemStack returnItem,
                      Integer returnSlot,
                      ItemStack getAdjustedIngredient1,
                      Integer getMaxUses,
                      Integer getVillagerExperience
                      ){

        eventPlayer = player;
        eventvillager = villager;
        eventItem = returnItem;
        eventgetAdjustedIngredient1 = getAdjustedIngredient1;
        eventgetMaxUses = getMaxUses;
        eventMerchantInventory = merchantInventory;
        eventMerchantRecipe = merchantRecipe;
        eventVillagerExperience = getVillagerExperience;
        eventReturnSlot = returnSlot;
    }

    /**
     * Returns the player involved in the trade.
     * @return Returns the player.
     */
    public Player getPlayer() {return eventPlayer;}

    /**
     * Returns the player involved in the trade.
     * @deprecated Please use getPlayer() instead, even though they return the same thing.
     * @return Returns the player.
     */
    public Player getEventPlayer() {return eventPlayer;}

    /**
     * Returns the merchant/villager/entity involved in the trade.
     * @return Returns the merchant/villager/entity.
     */
    public Merchant getMerchant() {return eventvillager;}

    /**
     * Returns the merchant/villager/entity involved in the trade.
     * @deprecated Now returns the same thing as getMerchant().
     * @return Returns the merchant/villager/entity.
     */
    public Merchant getEventEntity() {return eventvillager;}

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
     * Returns the item involved in this event.
     * @deprecated Now returns the same thing as getItem().
     * @return Returns the item.
     */
    public ItemStack getEventItem() {return eventItem;}

    /**
     * Returns the adjusted ingredient - 1
     */
    public ItemStack getAdjustedIngredient1() {return eventgetAdjustedIngredient1;}

    /**
     * Returns the max trade uses.
     */
    public Integer getMaxUses() {return eventgetMaxUses;}

    /**
     * Returns the given villager experience.
     */
    public Integer getVillagerExperience() {return eventVillagerExperience;}

    /**
     * Returns the item slot involved in this event.
     * <p>This is an integer. If you are looking at getting the item, please use getItem().</p>
     * @return Returns the item slot involved.
     */
    public Integer getItemSlot() {return eventReturnSlot;}

    public static final HandlerList getHandlerList(){
        return handlers;
    }

    public final HandlerList getHandlers(){
        return handlers;
    }

    public boolean isCancelled(){
        return this.cancel;
    }

    public void setCancelled(boolean cancel){
        this.cancel = cancel;
    }
}
