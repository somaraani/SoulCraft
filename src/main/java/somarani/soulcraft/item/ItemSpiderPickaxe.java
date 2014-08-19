package somarani.soulcraft.item;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import scala.annotation.varargs;
import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpiderPickaxe extends ItemPickaxe {

	public ItemSpiderPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		
		this.setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:spiderpickaxe");

		GameRegistry.registerItem(this, "spiderpickaxe");

	}
	
	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		
		if(!(par1ItemStack.isItemEnchanted())){
			
			par1ItemStack.addEnchantment(Enchantment.silkTouch, 1);
			
		}
		
	}
	
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		if(par1ItemStack.isItemEnchanted() == false){
		par3List.add("Silk Touch I");
		par3List.add("Durability: " + (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

		}
		
	}

	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{ 
		return false;
	}
	
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return Items.string == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	

}
