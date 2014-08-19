package somarani.soulcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import somarani.soulcraft.common.SoulCraft;
import somarani.soulcraft.itemblock.BlockSlimeItem;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockSlime extends Block {

	public BlockSlime(Material p_i45394_1_) {
		super(Material.sponge);

		setHardness(1f);
		setResistance(1f);
		setBlockName("slimeblock");
		setCreativeTab(SoulCraft.tabSoul);
		setLightLevel(0f);
		setBlockTextureName("soulcraft:slimeblock");

		GameRegistry.registerBlock(this, BlockSlimeItem.class, "slimeblock");
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z,
			Entity entity) {
		
		if(entity instanceof EntityPlayer){

		if (entity instanceof EntityPlayer) {
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(
					Potion.jump.id, 1, 6));
			entity.motionY = 0;

		}

		if (entity instanceof EntityPlayer) {
			((EntityPlayer) entity).jump();
		}

		entity.fallDistance = 0;
		
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x,
			int y, int z) {
		return AxisAlignedBB.getBoundingBox(x, y, z, (double) x + 1.0D,
				(double) y + 0.95D, (double) z + 1.0D);
	}

}
