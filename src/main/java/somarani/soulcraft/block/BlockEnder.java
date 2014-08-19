package somarani.soulcraft.block;

import java.awt.event.KeyEvent;

import somarani.soulcraft.common.SoulCraft;
import somarani.soulcraft.event.NBT;
import somarani.soulcraft.itemblock.BlockEnderItem;
import somarani.soulcraft.mob.EntityBlasterBolt;
import somarani.soulcraft.mob.EntityEnder;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.java.games.input.Keyboard;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;

public class BlockEnder extends Block {

	public BlockEnder(Material p_i45394_1_) {
		super(p_i45394_1_);

		setHardness(4f);
		setResistance(4f);
		setBlockName("enderblock");
		setCreativeTab(SoulCraft.tabSoul);
		setLightLevel(1.0f);
		setBlockTextureName("soulcraft:enderblock1");

		GameRegistry.registerBlock(this, BlockEnderItem.class, "enderblock");

	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z,
			Entity entity) {

		if (entity instanceof EntityPlayer) {

			EntityPlayer par3EntityPlayer = (EntityPlayer) entity;
			if (NBT.getTag(par3EntityPlayer) > 17) {
				if (par3EntityPlayer.isSneaking()) {
					world.spawnEntityInWorld(new EntityEnder(world,
							par3EntityPlayer));
					NBT.setTag(0, par3EntityPlayer);

				}
			} else {
				NBT.incrementTag(par3EntityPlayer);
			}
			/*
			 * Vec3 vec3 = par3EntityPlayer.getLookVec();
			 * 
			 * vec3.xCoord = par3EntityPlayer.posX; vec3.yCoord =
			 * par3EntityPlayer.posY; vec3.zCoord = par3EntityPlayer.posZ;
			 * 
			 * vec3.yCoord++;
			 * 
			 * Vec3 lookVec = par3EntityPlayer.getLook(1f); Vec3 aVector =
			 * vec3.addVector(lookVec.xCoord * 75, lookVec.yCoord * 75,
			 * lookVec.zCoord * 75);
			 * 
			 * MovingObjectPosition movingObjPos = world.rayTraceBlocks(vec3,
			 * aVector);
			 * 
			 * MovingObjectType a = MovingObjectPosition.MovingObjectType.BLOCK;
			 * 
			 * if (movingObjPos != null && movingObjPos.typeOfHit == a) {
			 * 
			 * int blockX = movingObjPos.blockX; int blockY =
			 * movingObjPos.blockY; int blockZ = movingObjPos.blockZ;
			 * 
			 * if(world.blockExists(blockX, blockY, blockZ)){
			 * if(world.getBlock(blockX, blockY, blockZ) ==
			 * SoulCraft.enderBlock){
			 * par3EntityPlayer.setPositionAndUpdate((double) blockX + 0.5,
			 * (double) ((float) blockY + 1F), (double) blockZ + 0.5); } } else
			 * {
			 * 
			 * lookVec = par3EntityPlayer.getLook(1.0f); aVector =
			 * vec3.addVector(blockX, blockY, blockZ);
			 * 
			 * movingObjPos = world.rayTraceBlocks(vec3, aVector);
			 * 
			 * }
			 * 
			 * }
			 */

		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x,
			int y, int z) {
		return AxisAlignedBB.getBoundingBox(x, y, z, (double) x + 1.0D,
				(double) y + 0.9D, (double) z + 1.0D);
	}

}
