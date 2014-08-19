package somarani.soulcraft.mob;

import org.omg.CORBA.PUBLIC_MEMBER;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import scala.annotation.varargs;
import somarani.soulcraft.common.SoulCraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityLostSoulMob extends EntityMob {

	public EntityLostSoulMob(World par1World) {
		super(par1World);
		}
	
	
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(SoulCraft.lostSoulHealth);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(SoulCraft.lostSoulDamage);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32d);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(SoulCraft.lostSoulSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.2D);
		
	}
	   public void onLivingUpdate()
	    {
	        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild())
	        {
	            float f = this.getBrightness(1.0F);

	            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
	            {
	                boolean flag = true;
	                
	                if (flag)
	                {
	                    this.setFire(8);
	                }
	            }
	        }
	        
	        if(worldObj.difficultySetting == EnumDifficulty.PEACEFUL){
	        	this.kill();
	        }

	        super.onLivingUpdate();
	    }

	@Override
	public boolean getCanSpawnHere(){
					
					if (!(this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) && this.isValidLightLevel()){
						return true;
					}
					
					return false;
		
	}
		
		public int getAttackStrength(Entity entity){
			
			return 3;
			
		}
		

		public void onDeath(DamageSource par1DamageSource) {
			
			World world = worldObj;
			
			if(!world.isRemote){
			int j = this.rand.nextInt(2) + 1;
			
			
			this.dropItem(SoulCraft.smallSoulFragment, j);
			}
		
			super.onDeath(par1DamageSource);
		}
	}
	

