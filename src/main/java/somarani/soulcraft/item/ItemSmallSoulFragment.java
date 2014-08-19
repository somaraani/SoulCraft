package somarani.soulcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import somarani.soulcraft.common.SoulCraft;
import net.minecraft.item.Item;

public class ItemSmallSoulFragment extends Item {

	public ItemSmallSoulFragment() {
		
		setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:smallsoulfragment");
		
		GameRegistry.registerItem(this, "smallsoulfragment");
		
	}
}
