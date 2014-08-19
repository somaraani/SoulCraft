package somarani.soulcraft.itemblock;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockSoulGlassItem extends ItemBlock {

	public BlockSoulGlassItem(Block p_i45328_1_) {
		super(p_i45328_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player,
			List list, boolean par4) {
		if (org.lwjgl.input.Keyboard
				.isKeyDown(org.lwjgl.input.Keyboard.KEY_LSHIFT)) {
			list.add("Allows players to walk right through.");
			list.add("Will instantly kill any entity that is");
			list.add("not a player");
		} else {
			list.add("Semi-Permeable");
			list.add("press \u00a79shift \u00a77to learn more");
		}

	}

}
