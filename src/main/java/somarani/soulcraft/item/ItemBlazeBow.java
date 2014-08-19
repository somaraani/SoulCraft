package somarani.soulcraft.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlazeBow extends Item {
	public static final String[] bowPullIconNameArray = new String[] {
			"pulling_0", "pulling_1", "pulling_2" };
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	private static final String __OBFID = "CL_00001777";

	public ItemBlazeBow() {
		this.maxStackSize = 1;
		this.setMaxDamage(384);
		this.setCreativeTab(SoulCraft.tabSoul);

		this.setFull3D();

		setTextureName("soulcraft:bow_standby");

		GameRegistry.registerItem(this, "blazebow");

	}

	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
		return Items.blaze_powder == par2ItemStack.getItem() ? true : super
				.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	public void registerIcons(IIconRegister iconRegister) {
		iconArray = new IIcon[4];
		this.itemIcon = iconRegister.registerIcon("soulcraft:bow_standby");
		iconArray[0] = iconRegister.registerIcon("soulcraft:bow_pulling_0");
		iconArray[1] = iconRegister.registerIcon("soulcraft:bow_pulling_1");
		iconArray[2] = iconRegister.registerIcon("soulcraft:bow_pulling_2");
	}

	/**
	 * called when the player releases the use item button. Args: itemstack,
	 * world, entityplayer, itemInUseCount
	 */
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer, int par4) {
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

		ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer,
				par1ItemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return;
		}
		j = event.charge;

		boolean flag = par3EntityPlayer.capabilities.isCreativeMode
				|| EnchantmentHelper.getEnchantmentLevel(
						Enchantment.infinity.effectId, par1ItemStack) > 0;

		if (flag || par3EntityPlayer.inventory.hasItem(Items.arrow)) {
			float f = (float) j / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;

			if ((double) f < 0.1D) {
				return;
			}

			if (f > 1.0F) {
				f = 1.0F;
			}

			EntityArrow entityarrow = new EntityArrow(par2World,
					par3EntityPlayer, f * 2.0f);

			if (f == 1.0F) {
				entityarrow.setIsCritical(true);
			}

			int k = EnchantmentHelper.getEnchantmentLevel(
					Enchantment.power.effectId, par1ItemStack);

			if (k > 0) {
				entityarrow.setDamage(entityarrow.getDamage() + (double) k
						* 0.5D + 0.5D);
			}

			int l = EnchantmentHelper.getEnchantmentLevel(
					Enchantment.punch.effectId, par1ItemStack);

			if (l > 0) {
				entityarrow.setKnockbackStrength(l);
			}

			entityarrow.setFire(100);

			par1ItemStack.damageItem(1, par3EntityPlayer);
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F,
					1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			if (flag) {
				entityarrow.canBePickedUp = 2;
			} else {
				par3EntityPlayer.inventory.consumeInventoryItem(Items.arrow);
			}

			entityarrow.setDamage(entityarrow.getDamage() + 1.8d);

			if (!par2World.isRemote) {
				par2World.spawnEntityInWorld(entityarrow);

			}
		}
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		return par1ItemStack;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	/**
	 * returns the action that specifies what animation to play when the items
	 * is being used
	 */
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.bow;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer,
				par1ItemStack);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return event.result;
		}

		if (par3EntityPlayer.capabilities.isCreativeMode
				|| par3EntityPlayer.inventory.hasItem(Items.arrow)) {
			par3EntityPlayer.setItemInUse(par1ItemStack,
					this.getMaxItemUseDuration(par1ItemStack));
		}

		return par1ItemStack;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Flame I");
		par3List.add("Durability: "
				+ (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player,
			ItemStack usingItem, int useRemaining) {

		if (usingItem == null) {
			return itemIcon;
		}
		int ticksInUse = stack.getMaxItemUseDuration() - useRemaining;
		if (ticksInUse > 17) {
			return iconArray[2];
		} else if (ticksInUse > 13) {
			return iconArray[1];
		} else if (ticksInUse > 0) {
			return iconArray[0];
		} else {
			return itemIcon;
		}
	}

	/**
	 * Return the enchantability factor of the item, most of the time is based
	 * on material.
	 */
	public int getItemEnchantability() {
		return 1;
	}

	/**
	 * used to cycle through icons based on their used duration, i.e. for the
	 * bow
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getItemIconForUseDuration(int par1) {
		return this.iconArray[par1];
	}
}