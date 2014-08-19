package somarani.soulcraft.mob;

import net.minecraft.entity.EntityList;
import somarani.soulcraft.common.SoulCraft;
import somarani.soulcraft.mobboss.EntitySoulBossMob;
import cpw.mods.fml.common.registry.EntityRegistry;

public class SoulCraftEntity {
	
	public static void mainRegistry(){
		
		registerEntity();
		
	}
	
	public static void registerEntity(){
		
		createEntity(EntityLostSoulMob.class,"lostsoul", 0x000000,0xAC30AC);
		createEntity(EntityWorg.class,"worg", 0x000000,0xAC30AC);
		createEntity(EntityBlasterBolt.class,"bolt", 0x000000,0x000000);
		createEntity(EntityEnder.class,"ender", 0x000000,0x000000);
		createEntity(EntitySoulBossMob.class,"boss", 0xCC00FF,0xA0099);
		
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor){
		int randomId = EntityRegistry.findGlobalUniqueEntityId(); 
		
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, SoulCraft.instance, 64, 1, true);
		createEgg(randomId,solidColor, spotColor);
	}

	private static void createEgg(int randomId, int solidColor,int spotColor) {
	
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));	
	}

}
