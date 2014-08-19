package somarani.soulcraft.block;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import somarani.soulcraft.common.SoulCraft;
import somarani.soulcraft.itemblock.BlockClearSoulGlassItem;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockClearSoulGlass extends Block {

	public BlockClearSoulGlass(Material p_i45394_1_) {
		super(p_i45394_1_);

		setHardness(2f);
		setResistance(5f);
		setBlockName("clearsoulglass");
		setCreativeTab(SoulCraft.tabSoul);
		setLightLevel(0f);
		setBlockTextureName("soulcraft:isg");

		GameRegistry.registerBlock(this, BlockClearSoulGlassItem.class,"clearsoulglass");

	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_,
			int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public boolean isOpaqueCube() {
		return false;
	}

	public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_,
			int p_149670_3_, int p_149670_4_, Entity entity) {
		if (!(entity instanceof EntityPlayer)) {
			entity.setDead();
		}

	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4) {
		return null;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

}
