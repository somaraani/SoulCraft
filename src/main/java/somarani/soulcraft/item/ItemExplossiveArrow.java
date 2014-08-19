package somarani.soulcraft.item;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemExplossiveArrow extends Item{

	public ItemExplossiveArrow(){
	this.setCreativeTab(SoulCraft.tabSoul);
	
	setTextureName("soulcraft:arrow");

	GameRegistry.registerItem(this, "explosivearrow");
	}

}
