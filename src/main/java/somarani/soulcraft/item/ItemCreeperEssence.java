package somarani.soulcraft.item;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemCreeperEssence extends Item{

	public ItemCreeperEssence(){
	this.setCreativeTab(SoulCraft.tabSoul);
	
	setTextureName("soulcraft:creeperessence");

	GameRegistry.registerItem(this, "creeperessence");
	}

}
