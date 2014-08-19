package somarani.soulcraft.itemblock;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockEnderItem extends ItemBlock {

	public BlockEnderItem(Block p_i45328_1_) {
		super(p_i45328_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player,
			List list, boolean par4) {
		if (org.lwjgl.input.Keyboard
				.isKeyDown(org.lwjgl.input.Keyboard.KEY_LSHIFT)) {

			list.add("Stand on top of this block and");
			list.add("aim at another ender block");
			list.add("then \u00a79Sneak \u00a77to teleport to it");
		} else {
			list.add("Teleportation");
			list.add("press \u00a79shift \u00a77to learn more");
		}

	}

}
