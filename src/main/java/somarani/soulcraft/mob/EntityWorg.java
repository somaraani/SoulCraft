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
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityWorg extends EntityMob {

	public EntityWorg(World par1World) {
		super(par1World);
		}
	
	
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15d);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1d);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.2D);
		
	}

		
		public int getAttackStrength(Entity entity){
			
			return 0;
			
		}
		
		@Override
		public boolean getCanSpawnHere(){
						
						if  ( this.isValidLightLevel()){
							return true;
						}
						
						return false;
			
		}
		
		/*protected String getLivingSound(){
			
			return "mob.zombie.say";
		}
		
		protected String getDeathSound(){
			return "mob.zombie.death";
		}
		protected String getHurtSound(){
			return "mob.zombie.hurt";
		}*/

		public void onDeath(DamageSource par1DamageSource) {
			
			World world = worldObj;
			
			
			if(!world.isRemote){
			int j = 1;
			
			
			//this.dropItem(SoulCraft.pureSoulFragment, j);
			}
		
			super.onDeath(par1DamageSource);
		}
	}
	

