package somarani.soulcraft.item;

import ibxm.Player;
import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemZombieSword extends ItemSword{

	public ItemZombieSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);

		this.setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:zombiesword");

		GameRegistry.registerItem(this, "zombiesword");		
	}
	
	
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		
		 if (par2EntityLivingBase instanceof net.minecraft.entity.monster.EntityZombie ||par2EntityLivingBase instanceof net.minecraft.entity.monster.EntityGiantZombie ) {
			
			par2EntityLivingBase.heal(-3);

		}
		 
		 par1ItemStack.damageItem(1, par2EntityLivingBase);
		
		return true;
		 
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return SoulCraft.soulFlesh == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
		 
		 	if(par3EntityPlayer.isSneaking()){
		 		
		 		par1ItemStack.damageItem(SoulCraft.zombieSwordHealDamage, par3EntityPlayer);
		 		
		 		par3EntityPlayer.heal(1f);
		 		
		 	}
		 
			return par1ItemStack;
		 
	    }
	 
	 @SideOnly(Side.CLIENT)
		public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

			par3List.add("Regeneration");
			par3List.add("Durability: " + (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

			
		}

}
