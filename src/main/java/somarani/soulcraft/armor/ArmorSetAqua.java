package somarani.soulcraft.armor;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import somarani.soulcraft.common.SoulCraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ArmorSetAqua extends ItemArmor {

	public ArmorSetAqua(ArmorMaterial material, int id, int placement) {
		super(material, id, placement);

		this.maxStackSize = 1;

	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {

		if (stack.getItem() == SoulCraft.aquaHelmet
				|| stack.getItem() == SoulCraft.aquaChest
				|| stack.getItem() == SoulCraft.aquaBoots) {

			return "soulcraft:textures/models/armor/Aqua_1.png";

		} else if (stack.getItem() == SoulCraft.aquaLeggings) {

			return "soulcraft:textures/models/armor/Aqua_2.png";
		}

		return null;

	}

	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
		return Items.fish == par2ItemStack.getItem() ? true : super
				.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Water God V");
		par3List.add("Durability: "
				+ (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

	}

	public void onArmorTick(World world, EntityPlayer player,
			ItemStack itemStack) {

		boolean bootsOn = false;
		boolean legsOn = false;
		boolean chestOn = false;
		boolean helmOn = false;

		if (player.getCurrentArmor(2) != null) {

			ItemStack chest = player.getCurrentArmor(2);
			if (chest.getItem() == SoulCraft.aquaChest)
				chestOn = true;

		}

		if (player.getCurrentArmor(0) != null) {

			ItemStack chest = player.getCurrentArmor(0);
			if (chest.getItem() == SoulCraft.aquaBoots)
				bootsOn = true;

		}

		if (player.getCurrentArmor(3) != null) {

			ItemStack helm = player.getCurrentArmor(3);
			if (helm.getItem() == SoulCraft.aquaHelmet) {

				helmOn = true;
			}

		}

		if (player.getCurrentArmor(1) != null) {

			ItemStack legs = player.getCurrentArmor(1);
			if (legs.getItem() == SoulCraft.aquaLeggings) {
				legsOn = true;
			}
		}

		if (legsOn && chestOn && bootsOn && helmOn) {

			player.setAir(300);

			if (player.isInWater()) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id,
						1, 0));

				player.addPotionEffect(new PotionEffect(Potion.nightVision.id,
						1, 0));

				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id,
						1, 2));

				player.addPotionEffect(new PotionEffect(Potion.resistance.id,
						1, 2));
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1,
						2));
			}

			if (!player.isSneaking()) {
				if (player.worldObj.getBlock((int) player.posX,
						(int) player.posY - 2, (int) player.posZ) == Blocks.water) {
					player.motionY = 0.0f;
				}

			}

		}

	}

}
