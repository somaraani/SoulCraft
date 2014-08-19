package somarani.soulcraft.armor;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import somarani.soulcraft.common.SoulCraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ArmorSetSoul extends ItemArmor {

	public ArmorSetSoul(ArmorMaterial material, int id, int placement) {
		super(material, id, placement);

		this.maxStackSize = 1;

	}

	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
		return SoulCraft.soulFragment == par2ItemStack.getItem() ? true : super
				.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Durability: "
				+ (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {

		if (stack.getItem() == SoulCraft.soulHelmet
				|| stack.getItem() == SoulCraft.soulChest
				|| stack.getItem() == SoulCraft.soulBoots) {

			return "soulcraft:textures/models/armor/Soul_1.png";

		} else if (stack.getItem() == SoulCraft.soulLeggings) {

			return "soulcraft:textures/models/armor/Soul_2.png";
		}

		return null;

	}

}
