package somarani.soulcraft.item;

import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnderSword extends ItemSword{

	public ItemEnderSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);

		this.setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:endersword");

		GameRegistry.registerItem(this, "endersword");
		
	}
	
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }
	
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		
		 if (par2EntityLivingBase instanceof EntityEnderman){
			
			par2EntityLivingBase.heal(-3);

		}
		
		 par1ItemStack.damageItem(1, par2EntityLivingBase);
		 
		return true;
		 
	}

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return Items.ender_pearl == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Teleportaion I");
		par3List.add("Durability: " + (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));
		
	}
	

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
		 if(par3EntityPlayer.isSneaking()){
			 
	
			 Vec3 vec3 = par3EntityPlayer.getLookVec();
			 
			 vec3.xCoord = par3EntityPlayer.posX;
			 vec3.yCoord = par3EntityPlayer.posY;
			 vec3.zCoord = par3EntityPlayer.posZ;
			 
			 vec3.yCoord++;
			 
			 double distance = SoulCraft.enderSwordTravel;
			 
			 Vec3 lookVec = par3EntityPlayer.getLook(1.0f);
			 Vec3 aVector = vec3.addVector(lookVec.xCoord * distance, lookVec.yCoord * distance, lookVec.zCoord * distance);
			 
			 MovingObjectPosition movingObjPos = par2World.rayTraceBlocks(vec3, aVector);
			 
			 MovingObjectType a = MovingObjectPosition.MovingObjectType.BLOCK;
			 
			 if (movingObjPos != null && movingObjPos.typeOfHit == a)
			 {
			 
			 int blockX = movingObjPos.blockX;
			 int blockY = movingObjPos.blockY;
			 int blockZ = movingObjPos.blockZ;
			 
			 
			 par3EntityPlayer.setPositionAndUpdate((double) blockX, (double) ((float) blockY + 1F), (double) blockZ);
			 
			 par2World.playSoundAtEntity(par3EntityPlayer, "mob.endermen.portal", 1.0f, 1.0f);	
			 
			
	
			 par1ItemStack.damageItem(SoulCraft.enderSwordTravelDamage, par3EntityPlayer);
			 
			 }
			 
		 }
		 
	        return par1ItemStack;
	    }
	
	

}
