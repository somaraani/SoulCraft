package somarani.soulcraft.item;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

public class ItemEnderPickaxe extends ItemPickaxe {

	public ItemEnderPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		
		this.setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:enderpickaxe");

		GameRegistry.registerItem(this, "enderpickaxe");
	}


	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return Items.ender_pearl == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
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
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Ender Miner I");
		par3List.add("Durability: " + (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

		
	}
}
