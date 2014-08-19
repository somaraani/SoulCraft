package somarani.soulcraft.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import somarani.soulcraft.common.SoulCraft;
import somarani.soulcraft.mob.EntityLostSoulMob;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Type;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSoulTrapEmpty extends Item {
	
	public ItemSoulTrapEmpty(){
		
	this.setCreativeTab(SoulCraft.tabSoul);
	
	setTextureName("soulcraft:soultrap_empty");
	
	this.setMaxStackSize(1);


	GameRegistry.registerItem(this, "soultrapempty");

	}
	

	
	@Override
	public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase target)
	{
	         if (target instanceof EntityLostSoulMob) {
	        	                  

	    		 int i = (int)player.posX;
	             int j = (int)player.posY;
	             int k = (int)player.posZ;
	             
	             World world = player.worldObj;
	             
	             boolean helmOn = false;
	             boolean chestOn = false;
	             boolean legsOn = false;
	             boolean bootsOn = false;
	             
	 			if(player.getCurrentArmor(0) != null ){
	 				
	 				ItemStack boots = player.getCurrentArmor(0);
	 				if(boots.getItem() == SoulCraft.soulBoots || boots.getItem() == SoulCraft.soulBoots2) bootsOn = true;
	 				
	 			}
	 			
	 			if(player.getCurrentArmor(1) != null ){ 
	 				
	 				ItemStack legs = player.getCurrentArmor(1);
	 				if(legs.getItem() == SoulCraft.soulLeggings || legs.getItem() == SoulCraft.soulLeggings2) legsOn = true;
	 				
	 			}
	 			
	 			if(player.getCurrentArmor(2) != null ){
	 				
	 				ItemStack chest = player.getCurrentArmor(2);
	 				if(chest.getItem() == SoulCraft.soulChest || chest.getItem() == SoulCraft.soulChest2) chestOn = true;
	 				
	 			}
	 			
	 			if(player.getCurrentArmor(3) != null ){
	 				
	 				ItemStack helm = player.getCurrentArmor(3);
	 				if(helm.getItem() == SoulCraft.soulHelmet || helm.getItem() == SoulCraft.soulHelmet2) helmOn = true;
	 				
	 			}
	             
	             
	             if(helmOn && chestOn && legsOn && bootsOn) {
	            	 
	            	 world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));

	                 player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(SoulCraft.soulTrapLostSoul));
	                 
		             target.setDead();
	            	 
	             }
	             
	             else {
				
	             world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
	             world.spawnEntityInWorld(new EntityLightningBolt(world, i + 2, j, k));
	             world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k + 2));
	             world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k - 2));
	             world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k - 2));
	             world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
	             world.spawnEntityInWorld(new EntityLightningBolt(world, i + 2, j, k));
	             world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k + 2));
	             world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k - 2));
	             world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k - 2));
	             
	             player.setFire(9);
	           
	             GuiNewChat chat = Minecraft.getMinecraft().ingameGUI.getChatGUI();
	             chat.printChatMessage(new ChatComponentText("A fool tried to capture a soul without proper Soul Armor"));
	            
	             }
	          
	                 return true;

	         }
	         
	         return false;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{ 
		return true;
	}
	

}
