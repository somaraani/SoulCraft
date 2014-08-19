package somarani.soulcraft.armor;


import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import somarani.soulcraft.common.SoulCraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ArmorSetLost extends ItemArmor {

	public ArmorSetLost(ArmorMaterial material, int id,
			int placement) {
		super(material, id, placement);
		
		this.maxStackSize = 1;

	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == SoulCraft.lostHelmet || stack.getItem() == SoulCraft.lostChest || stack.getItem() == SoulCraft.lostBoots){
			
			return "soulcraft:textures/models/armor/lostSoul_1.png";
			
		}else if (stack.getItem() == SoulCraft.lostLeggings){
			
			return "soulcraft:textures/models/armor/lostSoul_2.png";
		}
		
		return null;
		
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return SoulCraft.soulTrapLostSoul == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {
		par3List.add("Speed I");
		par3List.add("Side Step I");
		par3List.add("Step Assist I");
		par3List.add("Hover");
		par3List.add("Durability: " + (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));

	}
	
	 public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack){
		 
		 boolean bootsOn = false;
		 boolean legsOn = false;
		 boolean chestOn = false;
		 boolean helmOn = false;
		 
		 if(player.getCurrentArmor(2) != null ){
				
				ItemStack chest = player.getCurrentArmor(2);
				if(chest.getItem() == SoulCraft.lostChest) chestOn = true;
				
			}
		 
		 if(player.getCurrentArmor(0) != null ){
				
				ItemStack chest = player.getCurrentArmor(0);
				if(chest.getItem() == SoulCraft.lostBoots) bootsOn = true;
				
			}
			
			if(player.getCurrentArmor(3) != null ){
				
				ItemStack helm = player.getCurrentArmor(3);
				if(helm.getItem() == SoulCraft.lostHelmet) {
					
					helmOn = true;
				}
				
			}

			if(player.getCurrentArmor(1) != null ){ 
				
				ItemStack legs = player.getCurrentArmor(1);
				if(legs.getItem() == SoulCraft.lostLeggings) {
					legsOn = true;
				}}
		 
			
			if(legsOn && chestOn && bootsOn && helmOn){
			
		 if (player.isSneaking() && player.isAirBorne){
			 player.motionY = 0;
			 player.motionX = 0;
			 player.motionZ = 0;
		 }
		 
		 if(player.onGround){
				
				if (player.isSprinting()) player.moveEntityWithHeading(player.moveStrafing, player.moveForward * 0.2f);
				else if (player.isSprinting() && player.moveStrafing != 0) player.moveEntityWithHeading(player.moveStrafing, player.moveForward * 0.05f);

			}

			else{
				
			player.jumpMovementFactor = 0.1f;
			
			}
		
			
			if(player.motionX != 0 || player.motionZ != 0){
			player.stepHeight = 1;}
			else { player.stepHeight = 0.5f; }
		 
		 
			}
		 
	 }
	
	
}
