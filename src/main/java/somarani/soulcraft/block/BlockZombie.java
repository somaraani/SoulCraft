package somarani.soulcraft.block;

import java.util.Random;

import somarani.soulcraft.common.SoulCraft;
import somarani.soulcraft.event.NBT;
import somarani.soulcraft.itemblock.BlockZombieItem;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockZombie extends Block {

	public BlockZombie(Material p_i45394_1_) {
		super(p_i45394_1_);

		setHardness(3f);
		setResistance(4f);
		setBlockName("zombieblock");
		setCreativeTab(SoulCraft.tabSoul);
		setLightLevel(1.0f);
		setBlockTextureName("soulcraft:zombieblock");

		GameRegistry.registerBlock(this, BlockZombieItem.class, "zombieblock");

	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z,
			Entity entity) {

		if (entity instanceof EntityPlayer)

		{
			EntityPlayer player = (EntityPlayer) entity;
			
			if (NBT.getTag(player) > 18) {
				((EntityLivingBase) entity).heal(1f);
				NBT.setTag(0, player);
			}

			else {
				NBT.incrementTag(player);
			}

		}

	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x,
			int y, int z) {
		return AxisAlignedBB.getBoundingBox(x, y, z, (double) x + 1.0D,
				(double) y + 0.99D, (double) z + 1.0D);
	}

}
