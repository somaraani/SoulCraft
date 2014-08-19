package somarani.soulcraft.mob;

import somarani.soulcraft.common.SoulCraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBlasterBolt extends EntityThrowable
{
	
    public EntityBlasterBolt(World par1World)
    {
        super(par1World);
    }
    public EntityBlasterBolt(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }
    public EntityBlasterBolt(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    
    
    @Override
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition){
    	
    	if(!worldObj.isRemote){	
    this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) SoulCraft.creeperBowDamage, SoulCraft.creeperBowBlockDamage); 
    this.kill();
    	}

   
    }
    @Override
    protected float getGravityVelocity()
    {
        return 0.01F;
    }
    
}