package somarani.soulcraft.item;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemBlazeEssence extends Item{

	public ItemBlazeEssence(){
	this.setCreativeTab(SoulCraft.tabSoul);
	
	setTextureName("soulcraft:blazeessence");

	GameRegistry.registerItem(this, "blazeessence");
	}

}
