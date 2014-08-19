package somarani.soulcraft.item;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemEnderEssence extends Item{

	public ItemEnderEssence(){
	this.setCreativeTab(SoulCraft.tabSoul);
	
	setTextureName("soulcraft:enderessence");

	GameRegistry.registerItem(this, "enderessence");
	}

}
