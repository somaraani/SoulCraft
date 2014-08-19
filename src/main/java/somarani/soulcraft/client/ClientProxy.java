package somarani.soulcraft.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Type;
import somarani.soulcraft.common.CommonProxy;
import somarani.soulcraft.common.SoulCraft;
import somarani.soulcraft.event.EntityHurtHandler;
import somarani.soulcraft.event.FlightHandler;
import somarani.soulcraft.event.KeyBindings;
import somarani.soulcraft.event.NBT;
import somarani.soulcraft.event.OnStartup;
import somarani.soulcraft.mob.EntityBlasterBolt;
import somarani.soulcraft.mob.EntityEnder;
import somarani.soulcraft.mob.EntityLostSoulMob;
import somarani.soulcraft.mob.EntityWorg;
import somarani.soulcraft.mob.MobLostSoul;
import somarani.soulcraft.mob.MobLostSoulRender;
import somarani.soulcraft.mob.MobWorg;
import somarani.soulcraft.mob.MobWorgRender;
import somarani.soulcraft.mobboss.EntitySoulBossMob;
import somarani.soulcraft.mobboss.MobSoulBoss;
import somarani.soulcraft.mobboss.MobSoulBossRender;

public class ClientProxy extends CommonProxy{
	
@Override
public void registerRenderThings(){
	
	RenderingRegistry.registerEntityRenderingHandler(EntityLostSoulMob.class, new MobLostSoulRender(new MobLostSoul(), 0.8f));
	RenderingRegistry.registerEntityRenderingHandler(EntityWorg.class, new MobWorgRender(new MobWorg(), 0.8f));
	RenderingRegistry.registerEntityRenderingHandler(EntityBlasterBolt.class, new RenderSnowball(SoulCraft.explosiveArrow));
	RenderingRegistry.registerEntityRenderingHandler(EntityEnder.class, new RenderSnowball(Items.ender_pearl));
	RenderingRegistry.registerEntityRenderingHandler(EntitySoulBossMob.class, new MobSoulBossRender(new MobSoulBoss(), 30.0f));
	
	FMLCommonHandler.instance().bus().register(new FlightHandler());
	FMLCommonHandler.instance().bus().register(new OnStartup());
	FMLCommonHandler.instance().bus().register(new NBT());

	}

}
