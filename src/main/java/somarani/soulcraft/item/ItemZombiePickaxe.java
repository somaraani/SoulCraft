package somarani.soulcraft.item;

import java.util.Random;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import scala.annotation.varargs;
import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemZombiePickaxe extends ItemPickaxe {

	public ItemZombiePickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		
		this.setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:zombiepickaxe");

		GameRegistry.registerItem(this, "zombiepickaxe");

	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Auto-Repair");
		par3List.add("Durability: " + (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

		
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return SoulCraft.soulFlesh == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
    	Random rand = new Random();
   	 
    	int j = rand.nextInt(50) + 1;
    	    	
    	if (par1ItemStack.isItemDamaged()){
    	
    	if (j == 20){
    		par1ItemStack.damageItem(-1, (EntityLivingBase) par3Entity);
    	}
    	}
    	
    }

	

}
