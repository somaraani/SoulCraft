package somarani.soulcraft.event;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import somarani.soulcraft.common.SoulCraft;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class FlightHandler {

	@SubscribeEvent
	public void Event(PlayerTickEvent event) {

		EntityPlayer player = Minecraft.getMinecraft().thePlayer;

		World world = player.worldObj;

		boolean helmOn = false;
		boolean chestOn = false;
		boolean legsOn = false;
		boolean bootsOn = false;

		if (player.getCurrentArmor(0) != null) {

			ItemStack helm = player.getCurrentArmor(0);
			if (helm.getItem() == SoulCraft.soulBoots2)
				bootsOn = true;
		}

		if (player.getCurrentArmor(1) != null) {

			ItemStack helm = player.getCurrentArmor(1);
			if (helm.getItem() == SoulCraft.soulLeggings2)
				legsOn = true;
		}

		if (player.getCurrentArmor(2) != null) {

			ItemStack chest = player.getCurrentArmor(2);
			if (chest.getItem() == SoulCraft.soulChest2)
				chestOn = true;

		}

		if (player.getCurrentArmor(3) != null) {

			ItemStack helm = player.getCurrentArmor(3);
			if (helm.getItem() == SoulCraft.soulHelmet2)
				helmOn = true;
		}

		if (legsOn)
			player.stepHeight = 1f;
		else
			player.stepHeight = 0.5f;
		if (legsOn || bootsOn || chestOn || helmOn) {
			if (legsOn && bootsOn && chestOn && helmOn) {
				player.capabilities.allowFlying = true;
			}

			else
				player.capabilities.allowFlying = false;
		}

	}

}
