package somarani.soulcraft.item;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemZombieEssence extends Item{

	public ItemZombieEssence(){
	this.setCreativeTab(SoulCraft.tabSoul);
	
	setTextureName("soulcraft:zombieessence");

	GameRegistry.registerItem(this, "zombieessence");
	}

}
