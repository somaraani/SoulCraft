package somarani.soulcraft.item;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemUltimateSoul extends Item {
	
	public ItemUltimateSoul(){
		
		this.setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:ultimatesoul");

		GameRegistry.registerItem(this, "ultimatesoul");
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{ 
		return true;
	}
	

}
