package somarani.soulcraft.event;

import somarani.soulcraft.common.SoulCraft;
import somarani.soulcraft.mobboss.EntitySoulBossMob;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EntityHurtHandler {

	@SubscribeEvent
	public void Event(LivingAttackEvent event) {

		if (event.entity instanceof EntityPlayer) {

			EntityPlayer player = (EntityPlayer) event.entity;

			if (player != null) {
				if (player.inventory.getCurrentItem() != null) {
					if (player.inventory.getStackInSlot(
							player.inventory.currentItem).getItem() != null) {

						if (event.source.isExplosion()
								&& player.inventory.getStackInSlot(
										player.inventory.currentItem).getItem() == SoulCraft.creeperBow) {
							event.setCanceled(true);
						}
					}
				}
			}
		}

		if (event.entity instanceof EntitySoulBossMob
				&& event.source.isExplosion()) {
			event.setCanceled(true);
		}
	}

}
