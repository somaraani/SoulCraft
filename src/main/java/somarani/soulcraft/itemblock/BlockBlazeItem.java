package somarani.soulcraft.itemblock;


import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockBlazeItem extends ItemBlock{

	public BlockBlazeItem(Block p_i45328_1_) {
		super(p_i45328_1_);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	 public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	        list.add("Sets Entities on Fire");
	    }

}
