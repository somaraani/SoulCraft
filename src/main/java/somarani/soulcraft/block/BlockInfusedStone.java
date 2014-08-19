package somarani.soulcraft.block;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import somarani.soulcraft.common.SoulCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;



public class BlockInfusedStone extends Block{

	public BlockInfusedStone(Material p_i45394_1_) {
		super(p_i45394_1_);
		
		setHardness(7f);
		setResistance(7f);
		setBlockName("infusedstone");
		setCreativeTab(SoulCraft.tabSoul);
		setLightLevel(1f);
		setBlockTextureName("soulcraft:infusedstone1");
	
		
		GameRegistry.registerBlock(this, "infusedstone");
		
	}
	

	public Item getItemDropped(int par1,Random random, int par2){
		
		return SoulCraft.soulFragment;
		
	}
	
	public int getExpDrop(IBlockAccess block, int i, int j){
		return 15;
		
	}
	
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random){
		
		float f1 = (float)x + 0.5f; 
		float f2 = (float)y + 1.1f; 
		float f3 = (float)z + 0.5f; 
		float f4 = random.nextFloat() * 0.6f - 0.3f; 
		float f5 = random.nextFloat() * -0.6f - -0.3f; 
		
		world.spawnParticle("smoke", (double)(f1 + f4), (double)f2, (double)(f3+f5), 0.0D, 0.0D, 0.0D);
		
		
	}
	

}
