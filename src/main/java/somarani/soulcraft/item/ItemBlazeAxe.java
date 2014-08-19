package somarani.soulcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import somarani.soulcraft.common.SoulCraft;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

public class ItemBlazeAxe extends ItemAxe {

	public ItemBlazeAxe(ToolMaterial p_i45327_1_) {
		super(p_i45327_1_);

		this.setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:blazeaxe");
		
		GameRegistry.registerItem(this, "blazeaxe");
		
	}
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return Items.blaze_powder == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	public boolean onBlockDestroyed(ItemStack itemStack, World world,
			Block block, int x, int y,
			int z, EntityLivingBase player) {
		
		if (FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(block)) != null){
			
		
		
		ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(block)).copy();
		
		if (stack != null) {
			world.setBlockToAir(x, y, z);
			
		if(!world.isRemote) player.entityDropItem(stack, 1);
		
		} 
		
		}
		itemStack.damageItem(1, player);
		
		return true;

		
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Auto Smelt");
		par3List.add("Durability: " + (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

		
	}

}
