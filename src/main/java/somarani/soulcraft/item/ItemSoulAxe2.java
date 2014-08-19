package somarani.soulcraft.item;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import somarani.soulcraft.common.SoulCraft;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

public class ItemSoulAxe2 extends ItemAxe {

	public ItemSoulAxe2(ToolMaterial p_i45327_1_) {
		super(p_i45327_1_);

		this.setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:soulaxe2");
		
		GameRegistry.registerItem(this, "soulaxe2");
		
	}
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return SoulCraft.soulTrapLostSoul == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	

	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
    	Random rand = new Random();
   	 
    	int j = rand.nextInt(69) + 1;
    	    	
    	if (par1ItemStack.isItemDamaged()){
    	
    	if (j == 20){
    		par1ItemStack.damageItem(-1, (EntityLivingBase) par3Entity);
    	}
    	}
    	
    }
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Efficiency");
		par3List.add("Auto-Repair II");
		par3List.add("Ender Miner I");
		par3List.add("Durability: " + (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

	}


	public boolean onBlockDestroyed(ItemStack itemStack, World world,
			Block block, int x, int y,
			int z, EntityLivingBase player) {
		
		
		
		EntityPlayer player2 = (EntityPlayer) player;
		
		player2.inventory.addItemStackToInventory(new ItemStack(block));
		
		if(block == Blocks.lit_redstone_ore){
			player2.inventory.addItemStackToInventory(new ItemStack(Blocks.redstone_ore));
		}
		
			world.setBlockToAir(x, y, z);

			itemStack.damageItem(1, player);
			
			return true;
			
		
	}

}
