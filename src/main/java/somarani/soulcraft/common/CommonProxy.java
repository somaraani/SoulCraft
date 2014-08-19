package somarani.soulcraft.common;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import somarani.soulcraft.event.EntityHurtHandler;
import somarani.soulcraft.event.FlightHandler;
import somarani.soulcraft.mob.EntityLostSoulMob;
import somarani.soulcraft.mob.MobLostSoul;
import somarani.soulcraft.mob.MobLostSoulRender;

public class CommonProxy {

	public void registerRenderThings() {

	}

	public void registerArmor() {

		// Register Armor
		GameRegistry.registerItem(SoulCraft.soulHelmet2, "soulhelmet2");
		GameRegistry.registerItem(SoulCraft.soulChest2, "soulchest2");
		GameRegistry.registerItem(SoulCraft.soulLeggings2, "soulleggings2");
		GameRegistry.registerItem(SoulCraft.soulBoots2, "soulboots2");

		GameRegistry.registerItem(SoulCraft.soulHelmet, "soulhelmet");
		GameRegistry.registerItem(SoulCraft.soulChest, "soulchest");
		GameRegistry.registerItem(SoulCraft.soulLeggings, "soulleggings");
		GameRegistry.registerItem(SoulCraft.soulBoots, "soulboots");

		GameRegistry.registerItem(SoulCraft.boneHelmet, "bonehelmet");
		GameRegistry.registerItem(SoulCraft.boneChest, "bonechest");
		GameRegistry.registerItem(SoulCraft.boneLeggings, "boneleggings");
		GameRegistry.registerItem(SoulCraft.boneBoots, "boneboots");

		GameRegistry.registerItem(SoulCraft.lostHelmet, "losthelmet");
		GameRegistry.registerItem(SoulCraft.lostChest, "lostchestplate");
		GameRegistry.registerItem(SoulCraft.lostLeggings, "lostleggings");
		GameRegistry.registerItem(SoulCraft.lostBoots, "lostboots");

		GameRegistry.registerItem(SoulCraft.aquaHelmet, "aquahelmet");
		GameRegistry.registerItem(SoulCraft.aquaChest, "aquachestplate");
		GameRegistry.registerItem(SoulCraft.aquaLeggings, "aqualeggings");
		GameRegistry.registerItem(SoulCraft.aquaBoots, "aquaboots");

		GameRegistry.registerItem(SoulCraft.slimeBoots, "slimeboots");

		GameRegistry.registerItem(SoulCraft.spiderHelmet, "spiderhelmet");
		GameRegistry.registerItem(SoulCraft.spiderChest, "spiderchestplate");
		GameRegistry.registerItem(SoulCraft.spiderLeggings, "spiderleggings");
		GameRegistry.registerItem(SoulCraft.spiderBoots, "spiderboots");

		MinecraftForge.EVENT_BUS.register(new EntityHurtHandler());

	}

}
