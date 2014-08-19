package somarani.soulcraft.mob;

import somarani.soulcraft.common.SoulCraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityEnder extends EntityThrowable {

	public EntityEnder(World par1World) {
		super(par1World);
	}

	public EntityEnder(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
	}

	public EntityEnder(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);

	}

	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {

		if (!worldObj.isRemote) {
			int x = par1MovingObjectPosition.blockX;
			int y = par1MovingObjectPosition.blockY;
			int z = par1MovingObjectPosition.blockZ;

			if (worldObj.blockExists(x, y, z)) {
				if (worldObj.getBlock(x, y, z) == SoulCraft.enderBlock) {
					if (this.getThrower() != null
							&& this.getThrower() instanceof EntityPlayerMP) {

						this.getThrower().setPositionAndUpdate(x + 0.5 , y + 1, z + 0.5);
						this.getThrower().fallDistance = 0.0F;

						worldObj.playSoundAtEntity(this.getThrower(),
								"mob.endermen.portal", 1.0f, 1.0f);
						this.kill();
					}
				}
			}
		}

	}
	
	@Override
	public void onEntityUpdate() {
		
		this.motionX *= 20;
		this.motionY *= 20;
		this.motionZ *= 20;
		
		super.onEntityUpdate();
	}

	@Override
	protected float getGravityVelocity() {
		return 0.00F;
	}

}