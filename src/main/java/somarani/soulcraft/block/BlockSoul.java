package somarani.soulcraft.block;

import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockSoul extends Block {

	public BlockSoul(Material p_i45394_1_) {
		super(p_i45394_1_);
		
		
		setHardness(20f);
		setResistance(30f);
		setBlockName("soulblock");
		setCreativeTab(SoulCraft.tabSoul);
		setLightLevel(1.0f);
		setBlockTextureName("soulcraft:soulblock");
		
		GameRegistry.registerBlock(this, "soulblock");
		
	}


}
