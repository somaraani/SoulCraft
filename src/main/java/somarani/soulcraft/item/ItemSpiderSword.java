package somarani.soulcraft.item;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;

public class ItemSpiderSword extends ItemSword{

	public ItemSpiderSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);

		this.setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:spidersword");

		GameRegistry.registerItem(this, "spidersword");
		
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Poison II");
		par3List.add("Durability: " + (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

		
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return Items.string == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 1));
		
		 if (par2EntityLivingBase instanceof net.minecraft.entity.monster.EntitySpider ||par2EntityLivingBase instanceof net.minecraft.entity.monster.EntityCaveSpider ) {
			
			par2EntityLivingBase.heal(-3);

		}
		 
		 par1ItemStack.damageItem(1, par2EntityLivingBase);
		
		return true;
		 
	}

}
