package somarani.soulcraft.armor;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import somarani.soulcraft.common.SoulCraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ArmorSetSpider extends ItemArmor {

	public ArmorSetSpider(ArmorMaterial material, int id, int placement) {

		super(material, id, placement);

		this.maxStackSize = 1;

	}

	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
		return Items.string == par2ItemStack.getItem() ? true : super
				.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Wall Climber");
		par3List.add("Feather Falling");
		par3List.add("Durability: "
				+ (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {

		if (stack.getItem() == SoulCraft.spiderHelmet
				|| stack.getItem() == SoulCraft.spiderChest
				|| stack.getItem() == SoulCraft.spiderBoots) {

			return "soulcraft:textures/models/armor/Spider_1.png";

		} else if (stack.getItem() == SoulCraft.spiderLeggings) {

			return "soulcraft:textures/models/armor/Spider_2.png";
		}

		return null;

	}

	public void onArmorTick(World world, EntityPlayer player,
			ItemStack itemStack) {

		boolean collided = player.isCollidedHorizontally;
		boolean collided1 = player.isCollidedVertically;

		if (collided) {
			player.motionY = 0.065555559;
		}
		if (player.isSneaking() && collided) {
			player.motionY = 0;
		}

		int j1 = MathHelper.floor_double(player.posX);
		int k3 = MathHelper.floor_double(player.posY + 1.0D);
		int j5 = MathHelper.floor_double(player.posZ);

		if(world.isRemote){
		if (world.getBlock(j1, k3, j5).isBlockNormalCube()) {
			if (collided1) {
				player.motionY = 1.0D;
			}
		}
			if (collided1 && player.isSneaking()) {
				player.motionY = -0.39999999999999998D;
			}

		}

		player.fallDistance = 0.0F;
		player.addPotionEffect(new PotionEffect(Potion.jump.id, 1, 1));

	}

}
