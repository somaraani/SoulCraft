package somarani.soulcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSoulGrass extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon front;
	
	public BlockSoulGrass(Material p_i45394_1_) {
		super(p_i45394_1_);
		
		setBlockName("soulgrass");
		setCreativeTab(SoulCraft.tabSoul);		
		GameRegistry.registerBlock(this, "soulgrass");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int p_149691_2_)
	{
	return side == 1 || side == 0 ? this.top : (side == 2 ? this.front : this.blockIcon);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
	this.blockIcon = p_149651_1_.registerIcon("soulcraft" + ":" + "soulgrass");
	this.top = p_149651_1_.registerIcon("soulcraft" + ":" + "grass_top");
	this.front = p_149651_1_.registerIcon("soulcraft" + ":" + "soulgrass");
	}

}
