package somarani.soulcraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSoulApple2 extends ItemFood {

	public ItemSoulApple2(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		
		setCreativeTab(SoulCraft.tabSoul);
		
		setTextureName("soulcraft:soulapple");
		
		GameRegistry.registerItem(this, "soulapple2");
	
		
		
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, java.util.List par3List, boolean par4) {

		par3List.add("Regeneration II : 30 sec");
		par3List.add("Absorption II : 2 min");
		par3List.add("Resistance II : 5 min");
		par3List.add("Fire Protection II : 5 min");
		
	}
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        --par1ItemStack.stackSize;
        par3EntityPlayer.getFoodStats().func_151686_a(this, par1ItemStack);
        par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
        this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        return par1ItemStack;
    }
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.canEat(true))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
    }
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player){
		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 1));
		player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 2400, 1));
		player.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 1));
		player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 1));
		player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 6000, 1));
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{ 
		return true;
	}
	

}
