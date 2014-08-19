package somarani.soulcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import somarani.soulcraft.common.SoulCraft;
import net.minecraft.item.Item;

public class ItemPureSoulFragment extends Item {

	public ItemPureSoulFragment() {
		
		setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:goodsoulfragment");
		
		//GameRegistry.registerItem(this, "puresoulfragment");
		
	}
}
