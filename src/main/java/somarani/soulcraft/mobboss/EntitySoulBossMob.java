package somarani.soulcraft.mobboss;

import org.omg.CORBA.PUBLIC_MEMBER;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import scala.annotation.varargs;
import scala.reflect.internal.Trees.This;
import somarani.soulcraft.common.SoulCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;

public class EntitySoulBossMob extends EntityMob implements IRangedAttackMob,
		IBossDisplayData {

	public static int count = 1000;
	public static int lightning = 0;

	public EntitySoulBossMob(World par1World) {
		super(par1World);
		
		this.stepHeight = 3f;

	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(200d);

	}

	public void onLivingUpdate() {
		
		if(worldObj.isRemote){
			BossStatus.setBossStatus(this, true);
			}

		EntityPlayer entityplayer = this.worldObj
				.getClosestVulnerablePlayerToEntity(this, 16.0D);
		if (entityplayer != null) {
			int x = (int) entityplayer.posX;
			int y = (int) entityplayer.posY;
			int z = (int) entityplayer.posZ;

			EntityCreeper creeper = new EntityCreeper(worldObj);
			EntitySkeleton skeleton = new EntitySkeleton(worldObj);
			EntitySpider spider = new EntitySpider(worldObj);
			EntityZombie zombie = new EntityZombie(worldObj);

			creeper.setPosition(x + 10, y + 10, z);
			skeleton.setPosition(this.posX, this.posY, this.posZ);
			spider.setPosition(x + 5, y, z + 5);
			zombie.setPosition(this.posX, this.posY, this.posZ);

			if (count > 169) {
				if (!worldObj.isRemote) {

					worldObj.spawnEntityInWorld(creeper);
					worldObj.spawnEntityInWorld(creeper);
					worldObj.spawnEntityInWorld(skeleton);
					worldObj.spawnEntityInWorld(skeleton);
					worldObj.spawnEntityInWorld(skeleton);
					worldObj.spawnEntityInWorld(spider);
					worldObj.spawnEntityInWorld(zombie);
					worldObj.spawnEntityInWorld(zombie);

					count = 0;
				}
			}

			else
				count++;
		}

		if (this.getHealth() == 0) {

			if (!worldObj.isRemote) {
				this.worldObj.spawnEntityInWorld(new EntityLightningBolt(
						this.worldObj, this.posX + 30, this.posY,
						this.posZ + 30));
				this.worldObj.spawnEntityInWorld(new EntityLightningBolt(
						this.worldObj, this.posX + 50, this.posY,
						this.posZ + 80));
				this.worldObj.spawnEntityInWorld(new EntityLightningBolt(
						this.worldObj, this.posX + 100, this.posY,
						this.posZ + 70));
			}

		}

		if (worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
			this.kill();
		}

		if (lightning >= 200) {
			if (entityplayer != null) {
				int x = (int) entityplayer.posX;
				int y = (int) entityplayer.posY;
				int z = (int) entityplayer.posZ;

				if (!worldObj.isRemote) {
					this.worldObj.spawnEntityInWorld(new EntityLightningBolt(
							this.worldObj, x + 3, y, z + 3));
					lightning = 0;
				}
			}
		}

		else {
			lightning++;
		}

		super.onLivingUpdate();
	}

	public void onDeath(DamageSource par1DamageSource) {

		World world = worldObj;

		if (!world.isRemote) {

			ItemStack book = new ItemStack(Items.written_book);

			NBTTagCompound tag = new NBTTagCompound();
			NBTTagList bookPages = new NBTTagList();
			bookPages.appendTag(new NBTTagString("Long ago lived a brave warrior know as Tayean. Obsessed with becoming as powerful as can be, he "
					+ "took up the dark art of SoulCraft. Although once a noble man, the power of the Soul's was too strong for a simple man to handle "
					+ "Tayeans eyes turned purple as his hate grew."));
			
			bookPages.appendTag(new NBTTagString("Fearing for their life, the mobs of the world teamed up to seal Tayeans soul "
					+ "away for ever."
					+ "Although Tayean was a master in Soulcraft, there are many who have long surpassed him. To aquire the ultiamte power, you "
					+ "must kill them all."));
			
			//bookPages.appendTag(new NBTTagString("Omak 7elwa"));
			book.setTagInfo("pages", bookPages);
			book.setTagInfo("author", new NBTTagString("unknown"));
			book.setTagInfo("title", new NBTTagString(
					"\u00a75Tayean's Legend"));

			this.entityDropItem(book, 1);

			if (worldObj.difficultySetting == EnumDifficulty.EASY)
				this.experienceValue = 4200;

			if (worldObj.difficultySetting == EnumDifficulty.NORMAL)
				this.experienceValue = 5700;

			if (worldObj.difficultySetting == EnumDifficulty.NORMAL)
				this.experienceValue = 7000;
		}

		super.onDeath(par1DamageSource);

	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase var1, float var2) {
		// TODO Auto-generated method stub

	}

}
