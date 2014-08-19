package somarani.soulcraft.item;

import java.util.Random;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

public class ItemSoulPickaxe2 extends ItemPickaxe {

	public ItemSoulPickaxe2(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		
		this.setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:soulpickaxe2");

		GameRegistry.registerItem(this, "soulpickaxe2");
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return SoulCraft.soulTrapLostSoul == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Fortune");
		par3List.add("Auto Smelt");
		par3List.add("Efficiency");
		par3List.add("Auto-Repair II");
		par3List.add("Durability: " + (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

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
	
	public boolean onBlockDestroyed(ItemStack itemStack, World world,
			Block block, int x, int y,
			int z, EntityLivingBase player) {
		
		EntityPlayer player2 = (EntityPlayer) player;
		

		if (FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(block)) != null){
			
		ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(block)).copy();
		ItemStack stack1 = FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(block)).copy();
		
		if (stack != null) {
			world.setBlockToAir(x, y, z);
			player2.inventory.addItemStackToInventory(stack);
			player2.inventory.addItemStackToInventory(stack1);
		} 
		
		}
		else {
			world.setBlockToAir(x, y, z);
			player2.inventory.addItemStackToInventory(new ItemStack(block));
			
			if(block == Blocks.lit_redstone_ore){
				player2.inventory.addItemStackToInventory(new ItemStack(Blocks.redstone_ore));
			}
		}
		
		itemStack.damageItem(1, player);
		return true;

		
	}
}
