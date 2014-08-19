package somarani.soulcraft.item;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSoulSword extends ItemSword{

	public ItemSoulSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);

		this.setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:soulsword");

		GameRegistry.registerItem(this, "soulsword");
		
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return SoulCraft.soulFragment == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Durability: " + (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

	}

}
