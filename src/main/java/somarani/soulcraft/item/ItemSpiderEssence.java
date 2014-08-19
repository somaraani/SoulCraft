package somarani.soulcraft.item;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemSpiderEssence extends Item{

	public ItemSpiderEssence(){
	this.setCreativeTab(SoulCraft.tabSoul);
	
	setTextureName("soulcraft:spideressence");

	GameRegistry.registerItem(this, "spideressence");
	}

}
