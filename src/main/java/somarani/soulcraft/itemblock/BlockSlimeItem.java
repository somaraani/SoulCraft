package somarani.soulcraft.itemblock;


import java.util.List;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockSlimeItem extends ItemBlock{

	public BlockSlimeItem(Block p_i45328_1_) {
		super(p_i45328_1_);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	 public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	        list.add("Jump Boost VII");
	     
	    }
	
	

}
