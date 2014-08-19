package somarani.soulcraft.armor;

import org.lwjgl.Sys;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorSetSoul2 extends ItemArmor {

	public ArmorSetSoul2(ArmorMaterial material, int id, int placement) {
		super(material, id, placement);

		this.maxStackSize = 1;

	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {

		if (stack.getItem() == SoulCraft.soulHelmet2
				|| stack.getItem() == SoulCraft.soulChest2
				|| stack.getItem() == SoulCraft.soulBoots2) {

			return "soulcraft:textures/models/armor/Soulv2_1.png";

		} else if (stack.getItem() == SoulCraft.soulLeggings2) {

			return "soulcraft:textures/models/armor/Soulv2_2.png";
		}

		return null;

	}

	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
		return SoulCraft.soulTrapLostSoul == par2ItemStack.getItem() ? true
				: super.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Speed II");

		if (par1ItemStack.getItem() == SoulCraft.soulBoots2) {

			par3List.add("Water Walking");

		}

		if (par1ItemStack.getItem() == SoulCraft.soulLeggings2) {

			par3List.add("Step Assist");

		}
		if (par1ItemStack.getItem() == SoulCraft.soulHelmet2) {

			par3List.add("Water Breathing");

		}

		par3List.add("Flight");
		par3List.add("Durability: "
				+ (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

	}

	public void onArmorTick(World world, EntityPlayer player,
			ItemStack itemStack) {
		float bootsOn = 0;
		float legsOn = 0;
		float chestOn = 0;
		float helmOn = 0;
		float step = 0;

		if (player.getCurrentArmor(0) != null) {

			ItemStack boots = player.getCurrentArmor(0);
			if (boots.getItem() == SoulCraft.soulBoots2) {
				bootsOn = 0.1f;
				if (!player.isSneaking()) {
					if (player.worldObj.getBlock((int) player.posX,
							(int) player.posY - 2, (int) player.posZ) == Blocks.water) {
						player.motionY = 0.0f;
					}
				}
			}

		}

		if (player.getCurrentArmor(2) != null) {

			ItemStack chest = player.getCurrentArmor(2);
			if (chest.getItem() == SoulCraft.soulChest2)
				chestOn = 0.1f;

		}

		if (player.getCurrentArmor(3) != null) {

			ItemStack helm = player.getCurrentArmor(3);
			if (helm.getItem() == SoulCraft.soulHelmet2) {

				helmOn = 0.1f;

				player.setAir(300);
			}

		}

		if (player.getCurrentArmor(1) != null) {

			ItemStack legs = player.getCurrentArmor(1);
			if (legs.getItem() == SoulCraft.soulLeggings2) {
				legsOn = 1f;

				step = 0.5f;

			}

		}

		// player.capabilities.setPlayerWalkSpeed(0.1f + bootsOn + legsOn +
		// chestOn + helmOn);

		if (player.onGround) {

			if (player.isSprinting())
				player.moveEntityWithHeading(player.moveStrafing,
						player.moveForward * 0.5f);

		}

		else {

			player.jumpMovementFactor = 0.2f;

		}

		player.fallDistance = 0f;

	}

}
