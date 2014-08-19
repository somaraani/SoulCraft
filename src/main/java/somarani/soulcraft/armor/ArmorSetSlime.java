package somarani.soulcraft.armor;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import somarani.soulcraft.common.SoulCraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ArmorSetSlime extends ItemArmor {

	public ArmorSetSlime(ArmorMaterial material, int id, int placement) {
		super(material, id, placement);

		this.maxStackSize = 1;

	}

	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
		return Items.slime_ball == par2ItemStack.getItem() ? true : super
				.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {

		if (stack.getItem() == SoulCraft.slimeBoots) {

			return "soulcraft:textures/models/armor/Slime_1.png";
		}

		return null;

	}

	public void onArmorTick(World world, EntityPlayer player,
			ItemStack itemStack) {
		player.addPotionEffect(new PotionEffect(Potion.jump.id, 1, 3));
		player.fallDistance = 0;

	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Jump Boost IV");
		par3List.add("Durability: "
				+ (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

	}

}
