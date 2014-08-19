package somarani.soulcraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import somarani.soulcraft.common.SoulCraft;
import somarani.soulcraft.itemblock.BlockBlazeItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockBlaze extends Block {

	public BlockBlaze(Material p_i45394_1_) {
		super(p_i45394_1_);
	
		setHardness(2f);
		setResistance(3f);
		setBlockName("blazeblock");
		setCreativeTab(SoulCraft.tabSoul);
		setLightLevel(1f);
		setBlockTextureName("soulcraft:blazeblock");
		
		
		GameRegistry.registerBlock(this, BlockBlazeItem.class,"blazeblock");

		
	}
	
	@Override
    public void onEntityCollidedWithBlock (World world, int x, int y, int z, Entity entity)
    {
	
		if (entity instanceof EntityLivingBase)
        {
            entity.setFire(7);
        }
		
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool (World world, int x, int y, int z)
    {
        return AxisAlignedBB.getBoundingBox(x, y, z, (double) x + 1.0D, (double) y + 0.99D, (double) z + 1.0D);
    }
    

    public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face)
    {
        return true;
    }


}
