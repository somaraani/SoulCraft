package somarani.soulcraft.item;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemAquaEssence extends Item{

	public ItemAquaEssence(){
	this.setCreativeTab(SoulCraft.tabSoul);
	
	setTextureName("soulcraft:fishessence");

	GameRegistry.registerItem(this, "fishessence");
	}

}
