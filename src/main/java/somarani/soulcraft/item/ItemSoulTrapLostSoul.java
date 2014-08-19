package somarani.soulcraft.item;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSoulTrapLostSoul extends Item {
	
	public ItemSoulTrapLostSoul(){
	
this.setCreativeTab(SoulCraft.tabSoul);
	
	setTextureName("soulcraft:soultrap_full");
	
	this.setMaxStackSize(1);

	GameRegistry.registerItem(this, "soultraplostsoul");
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{ 
		return true;
	}
}
