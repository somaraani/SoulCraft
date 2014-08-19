package somarani.soulcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import scala.annotation.varargs;
import somarani.soulcraft.common.SoulCraft;
import somarani.soulcraft.itemblock.BlockSoulGlassItem;
import somarani.soulcraft.mobboss.EntitySoulBossMob;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSoulGlass extends Block {

	public static boolean skull = false;
	public static boolean spider = false;
	public static boolean creeper = false;
	public static boolean zombie = false;
	public static boolean shouldSpawn = false;

	public BlockSoulGlass(Material p_i45394_1_) {
		super(p_i45394_1_);

		setHardness(2f);
		setResistance(5f);
		setBlockName("soulglass");
		setCreativeTab(SoulCraft.tabSoul);
		setLightLevel(0f);
		setBlockTextureName("soulcraft:soulglass");

		GameRegistry.registerBlock(this, BlockSoulGlassItem.class,"soulglass");

	}
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess,
			int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		Block block = blockAccess.getBlock(p_149646_2_, p_149646_3_,
				p_149646_4_);

		if (this == SoulCraft.soulGlass) {
			if (blockAccess.getBlockMetadata(p_149646_2_, p_149646_3_,
					p_149646_4_) != blockAccess.getBlockMetadata(p_149646_2_
					- Facing.offsetsXForSide[p_149646_5_], p_149646_3_
					- Facing.offsetsYForSide[p_149646_5_], p_149646_4_
					- Facing.offsetsZForSide[p_149646_5_])) {
				return true;
			}

			if (block == this) {
				return false;
			}
		}

		return true;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public boolean isOpaqueCube() {
		return false;
	}

	public void onEntityCollidedWithBlock(World world1, int x,
			int y, int z, Entity entity) {
		
		
		if (!(entity instanceof EntityPlayer || entity instanceof EntitySoulBossMob)) {
			entity.setDead();
		}

		System.out.println(entity);
		if (entity instanceof EntityItem) {
			if (entity.toString().contains("spideressence")) {
				spider = true;
			}

			if (entity.toString().contains("bonehelmet")) {
				skull = true;
			}
			if (entity.toString().contains("creeperessence")) {
				creeper = true;
			}

			if (entity.toString().contains("zombieeessence")) {
				zombie = true;
			}
			
			if(spider && skull && creeper && zombie){
				
				World world = entity.worldObj;
				
				if(!world.isRemote){
				
				shouldSpawn = true;
				
				EntitySoulBossMob boss = new EntitySoulBossMob(world);
				
				boss.setPosition(x + 2, y + 2, z + 2);

				world.spawnEntityInWorld(new EntityLightningBolt(world, x + 10, y + 6, z + 3));
				world.setBlockToAir(x, y, z);
				if(!boss.worldObj.isRemote){
				boss.worldObj.spawnEntityInWorld(boss);}
				}

			}
			
			
		}

	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4) {
		return null;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

}
