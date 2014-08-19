package somarani.soulcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import somarani.soulcraft.common.SoulCraft;
import net.minecraft.item.Item;

public class ItemSoulFragment extends Item {

	public ItemSoulFragment() {
		
		setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:soulfragment");
		
		GameRegistry.registerItem(this, "soulfragment");
		
	}
}
