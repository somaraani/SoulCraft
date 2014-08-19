package somarani.soulcraft.item;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemStoneStick extends Item{
		
	public ItemStoneStick(){
		
		this.setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:stonestick");

		GameRegistry.registerItem(this, "stonestick");
		
	}
}
