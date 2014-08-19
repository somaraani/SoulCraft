package somarani.soulcraft.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import somarani.soulcraft.armor.ArmorSetAqua;
import somarani.soulcraft.armor.ArmorSetBone;
import somarani.soulcraft.armor.ArmorSetLost;
import somarani.soulcraft.armor.ArmorSetSlime;
import somarani.soulcraft.armor.ArmorSetSoul;
import somarani.soulcraft.armor.ArmorSetSoul2;
import somarani.soulcraft.armor.ArmorSetSpider;
import somarani.soulcraft.block.BlockBlaze;
import somarani.soulcraft.block.BlockClearGlass;
import somarani.soulcraft.block.BlockClearSoulGlass;
import somarani.soulcraft.block.BlockEnder;
import somarani.soulcraft.block.BlockInfusedStone;
import somarani.soulcraft.block.BlockSlime;
import somarani.soulcraft.block.BlockSoul;
import somarani.soulcraft.block.BlockSoulGlass;
import somarani.soulcraft.block.BlockSoulGrass;
import somarani.soulcraft.block.BlockZombie;
import somarani.soulcraft.item.ItemAquaEssence;
import somarani.soulcraft.item.ItemBlazeAxe;
import somarani.soulcraft.item.ItemBlazeBow;
import somarani.soulcraft.item.ItemBlazeEssence;
import somarani.soulcraft.item.ItemBlazePickaxe;
import somarani.soulcraft.item.ItemBlazeShovel;
import somarani.soulcraft.item.ItemBlazeSword;
import somarani.soulcraft.item.ItemBoneAxe;
import somarani.soulcraft.item.ItemBoneHoe;
import somarani.soulcraft.item.ItemBonePickaxe;
import somarani.soulcraft.item.ItemBoneShovel;
import somarani.soulcraft.item.ItemBoneSword;
import somarani.soulcraft.item.ItemCreeperBow;
import somarani.soulcraft.item.ItemCreeperEssence;
import somarani.soulcraft.item.ItemEnderAxe;
import somarani.soulcraft.item.ItemEnderEssence;
import somarani.soulcraft.item.ItemEnderPickaxe;
import somarani.soulcraft.item.ItemEnderShovel;
import somarani.soulcraft.item.ItemEnderSword;
import somarani.soulcraft.item.ItemExplossiveArrow;
import somarani.soulcraft.item.ItemLightningSword;
import somarani.soulcraft.item.ItemSmallSoulFragment;
import somarani.soulcraft.item.ItemSoulApple;
import somarani.soulcraft.item.ItemSoulApple2;
import somarani.soulcraft.item.ItemSoulAxe;
import somarani.soulcraft.item.ItemSoulAxe2;
import somarani.soulcraft.item.ItemSoulBone;
import somarani.soulcraft.item.ItemSoulFlesh;
import somarani.soulcraft.item.ItemSoulFragment;
import somarani.soulcraft.item.ItemSoulPickaxe;
import somarani.soulcraft.item.ItemSoulPickaxe2;
import somarani.soulcraft.item.ItemSoulShovel;
import somarani.soulcraft.item.ItemSoulShovel2;
import somarani.soulcraft.item.ItemSoulSword;
import somarani.soulcraft.item.ItemSoulSword2;
import somarani.soulcraft.item.ItemSoulTrapEmpty;
import somarani.soulcraft.item.ItemSoulTrapLostSoul;
import somarani.soulcraft.item.ItemSpiderAxe;
import somarani.soulcraft.item.ItemSpiderEssence;
import somarani.soulcraft.item.ItemSpiderPickaxe;
import somarani.soulcraft.item.ItemSpiderShovel;
import somarani.soulcraft.item.ItemSpiderSword;
import somarani.soulcraft.item.ItemStoneStick;
import somarani.soulcraft.item.ItemUltimateSoul;
import somarani.soulcraft.item.ItemZombieAxe;
import somarani.soulcraft.item.ItemZombieEssence;
import somarani.soulcraft.item.ItemZombiePickaxe;
import somarani.soulcraft.item.ItemZombieShovel;
import somarani.soulcraft.item.ItemZombieSword;
import somarani.soulcraft.mob.EntityLostSoulMob;
import somarani.soulcraft.mob.SoulCraftEntity;
import somarani.soulcraft.worldgeneration.WorldgenInfusedStone;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = SoulCraft.MODID, version = SoulCraft.VERSION)
public class SoulCraft {
	public static final String MODID = "soulcraft";
	public static final String VERSION = "1.3";

	@SidedProxy(clientSide = "somarani.soulcraft.client.ClientProxy", serverSide = "somarani.soulcraft.common.CommonProxy")
	public static CommonProxy proxy;

	@Instance(MODID)
	public static SoulCraft instance;

	public static CreativeTabs tabSoul = new CreativeTabs("SoulCraft") {
		@Override
		public Item getTabIconItem() {
			return ultimateSoul;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		SoulCraftEntity.mainRegistry();

		proxy.registerArmor();
		proxy.registerRenderThings();

		// Register world gen
		GameRegistry.registerWorldGenerator(infusedStoneGen, 1);
		// GameRegistry.registerWorldGenerator(pureInfusedStoneGen, 1);

		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());

		config.load();

		enderSwordTravel = config.get(CATEGORY_TOOLS, "enderSwordTravel", 50d,
				"The maximum range the enderman sword can teleport").getDouble(
				50d);
		enderSwordTravelDamage = config
				.get(CATEGORY_TOOLS, "enderSwordTravelDamage", 15,
						"The amount of damage it does to the enderman sword each time you teleport")
				.getInt(15);

		soulv2SwordTravel = config.get(CATEGORY_TOOLS, "enderSwordTravel", 75d,
				"The maximum range the Soul v2 Sword can teleport").getDouble(
				75d);

		creeperBowBlockDamage = config.get(CATEGORY_TOOLS,
				"creeperBowBlockDamage", false,
				"Decides whether the creeper bow does damage to blocks ")
				.getBoolean(false);

		checkUpdate = config.get(CATEGORY_GENERAL,
				"checkUpdate", true,
				"Decides whether to check for a new update when joining world")
				.getBoolean(true);
		
		creeperBowDamage = config
				.get(CATEGORY_TOOLS, "creeperBowDamage", 5.5d,
						"The amount of explosive damage the creeper bow does(higher is stronger)")
				.getDouble(5.5d);

		zombieSwordHealDamage = config
				.get(CATEGORY_TOOLS, "zombieSwordRegenDamage", 10,
						"The amount of damage it does to the zombie sword each time you use it to heal")
				.getInt(10);

		lostSoulDamage = config
				.get(CATEGORY_MOB, "lostSoulDamage", 1.5d,
						"Amount of damage the Lost Soul mob does to a player (in hearts)")
				.getDouble(1.5d);
		lostSoulHealth = config.get(CATEGORY_MOB, "lostSoulHealth", 10d,
				"The health of the Lost Soul mob (in hearts)").getDouble(10d);

		lostSoulSpeed = config.get(CATEGORY_MOB, "lostSoulSpeed", 1.5d,
				"The speed of the Lost Soul mob").getDouble(1.5d);

		soulSpawnRate = config
				.get(CATEGORY_GENERAL, "soulOreSpawnRate", 11,
						"The spawn rate of the Infused Stone Ore (Higher numbers spawns more ore)")
				.getInt(11);

		lostSoulSpawnRate = config
				.get(CATEGORY_GENERAL, "LostSoulSpawnRate", 50,
						"The spawn rate of the Lost Soul Mob (Higher numbers spawns more Lost Souls)")
				.getInt(50);

		enderBlockTravelDistance = config.get(CATEGORY_GENERAL,
				"enderBlockTravelDistance", 100,
				"The maximum range the ender block can teleport").getInt(100);
		// worgSpawnRate = config.get(CATEGORY_GENERAL, "worgSpawnRate", 5,
		// "The spawn rate of the Worg Mob (Higher numbers spawns more Lost Souls").getInt(5);

		// pureSoulSpawnRate = config.get(CATEGORY_GENERAL,
		// "pureSoulOreSpawnRate", 14,
		// "The spawn rate of the Pure Infused Stone Ore (Higher numbers spawns more ore").getInt(14);

		config.save();

	}

	// config
	public static double enderSwordTravel;
	public static double soulv2SwordTravel;
	public static int enderSwordTravelDamage;

	public static int enderBlockTravelDistance;

	public static int zombieSwordHealDamage;

	public static double lostSoulDamage;
	public static double lostSoulHealth;
	public static double lostSoulSpeed;

	public static int soulSpawnRate;
	public static int lostSoulSpawnRate;
	public static int worgSpawnRate;
	
	public static boolean checkUpdate;

	public static boolean creeperBowBlockDamage;

	public static double creeperBowDamage;

	// public static int pureSoulSpawnRate;

	public static final String CATEGORY_TOOLS = "Tools";
	public static final String CATEGORY_MOB = "Mobs";
	public static final String CATEGORY_GENERAL = "General";

	// Blocks--------------------------------------------------------------------
	public static Block infusedStone = new BlockInfusedStone(Material.rock);
	public static Block soulBlock = new BlockSoul(Material.rock);
	public static Block blazeBlock = new BlockBlaze(Material.rock);
	public static Block zombieBlock = new BlockZombie(Material.rock);
	public static Block slimeBlock = new BlockSlime(Material.sponge);
	public static Block enderBlock = new BlockEnder(Material.sponge);
	public static Block soulGrass = new BlockSoulGrass(Material.ground);
	public static Block soulGlass = new BlockSoulGlass(Material.glass);
	public static Block clearGlass = new BlockClearGlass(Material.glass);
	public static Block clearSoulGlass = new BlockClearSoulGlass(Material.glass);

	// Items--------------------------------------------------------------------
	public static Item soulFragment = new ItemSoulFragment()
			.setUnlocalizedName("soulfragment");

	// public static Item pureSoulFragment = new
	// ItemPureSoulFragment().setUnlocalizedName("puresoulfragment");

	// public static Block pureInfusedStone = new
	// BlockPureInfusedStone(Material.rock);

	public static Item smallSoulFragment = new ItemSmallSoulFragment()
			.setUnlocalizedName("smallsoulfragment");
	public static Item stoneStick = new ItemStoneStick()
			.setUnlocalizedName("stonestick");
	public static Item soulBone = new ItemSoulBone()
			.setUnlocalizedName("soulbone");
	public static Item soulApple = new ItemSoulApple(4, 2f, false)
			.setUnlocalizedName("soulapple");
	public static Item soulApple2 = new ItemSoulApple2(8, 4f, false)
			.setUnlocalizedName("soulapple2");

	public static Item explosiveArrow = new ItemExplossiveArrow()
			.setUnlocalizedName("explosivearrow");

	public static Item ultimateSoul = new ItemUltimateSoul()
			.setUnlocalizedName("ultimatesoul");

	public static Item soulFlesh = new ItemSoulFlesh(8, 3f, false)
			.setUnlocalizedName("infusedflesh");

	public static Item soulTrapEmpty = new ItemSoulTrapEmpty()
			.setUnlocalizedName("Empty Soul Trap");
	public static Item soulTrapLostSoul = new ItemSoulTrapLostSoul()
			.setUnlocalizedName("Trapped Lost Soul");

	public static Item creeperBow = new ItemCreeperBow()
			.setUnlocalizedName("Creeper Bow");
	public static Item blazeBow = new ItemBlazeBow()
			.setUnlocalizedName("Blaze Bow");

	// ESSENCES

	public static Item spiderEssence = new ItemSpiderEssence()
			.setUnlocalizedName("spideressence");
	public static Item blazeEssence = new ItemBlazeEssence()
			.setUnlocalizedName("blazeessence");
	public static Item zombieEssence = new ItemZombieEssence()
			.setUnlocalizedName("zombieeessence");
	public static Item enderEssence = new ItemEnderEssence()
			.setUnlocalizedName("enderessence");
	public static Item aquaEssence = new ItemAquaEssence()
			.setUnlocalizedName("aquaessence");
	public static Item creeperEssence = new ItemCreeperEssence()
			.setUnlocalizedName("creeperessence");

	// Tools----------------------------------------------------------------------

	// Material
	public static ToolMaterial toolBone = new EnumHelper().addToolMaterial(
			"BONE", 1, 225, 5.0f, 1.5f, 17);
	public static ToolMaterial toolSoul = new EnumHelper().addToolMaterial(
			"SOUL", 2, 999, 7.0f, 3f, 22);
	public static ToolMaterial toolSoul2 = new EnumHelper().addToolMaterial(
			"SOUL2", 3, 3000, 18.0f, 5.0f, 24);

	// tool items
	public static Item bonePickaxe = new ItemBonePickaxe(toolBone)
			.setUnlocalizedName("Bone Pickaxe");
	public static Item boneShovel = new ItemBoneShovel(toolBone)
			.setUnlocalizedName("Bone Shovel");
	public static Item boneHoe = new ItemBoneHoe(toolBone)
			.setUnlocalizedName("Bone Hoe");
	public static Item boneAxe = new ItemBoneAxe(toolBone)
			.setUnlocalizedName("Bone Axe");
	public static Item boneSword = new ItemBoneSword(toolBone)
			.setUnlocalizedName("Bone Sword");

	public static Item soulPickaxe = new ItemSoulPickaxe(toolSoul)
			.setUnlocalizedName("Soul Pickaxe");
	public static Item soulSword = new ItemSoulSword(toolSoul)
			.setUnlocalizedName("Soul Sword");
	public static Item souleAxe = new ItemSoulAxe(toolSoul)
			.setUnlocalizedName("Soul Axe");
	public static Item soulShovel = new ItemSoulShovel(toolSoul)
			.setUnlocalizedName("Soul Shovel");

	public static Item soulPickaxe2 = new ItemSoulPickaxe2(toolSoul2)
			.setUnlocalizedName("Soul Pickaxe2");
	public static Item soulSword2 = new ItemSoulSword2(toolSoul2)
			.setUnlocalizedName("Soul Sword2");
	public static Item souleAxe2 = new ItemSoulAxe2(toolSoul2)
			.setUnlocalizedName("Soul Axe2");
	public static Item soulShovel2 = new ItemSoulShovel2(toolSoul2)
			.setUnlocalizedName("Soul Shovel2");

	// ESSENCE SWORDS
	public static Item spiderSword = new ItemSpiderSword(toolSoul)
			.setUnlocalizedName("Spider Sword");
	public static Item spiderPickaxe = new ItemSpiderPickaxe(toolSoul)
			.setUnlocalizedName("Spider Pickaxe");
	public static Item spiderAxe = new ItemSpiderAxe(toolSoul)
			.setUnlocalizedName("Spider Axe");
	public static Item spiderShovel = new ItemSpiderShovel(toolSoul)
			.setUnlocalizedName("Spider Shovel");

	public static Item blazeSword = new ItemBlazeSword(toolSoul)
			.setUnlocalizedName("Blaze Sword");
	public static Item blazePickaxe = new ItemBlazePickaxe(toolSoul)
			.setUnlocalizedName("Blaze Pickaxe");
	public static Item blazeAxe = new ItemBlazeAxe(toolSoul)
			.setUnlocalizedName("Blaze Axe");
	public static Item blazeShovel = new ItemBlazeShovel(toolSoul)
			.setUnlocalizedName("Blaze Shovel");

	public static Item zombieSword = new ItemZombieSword(toolSoul)
			.setUnlocalizedName("Zombie Sword");
	public static Item zombiePickaxe = new ItemZombiePickaxe(toolSoul)
			.setUnlocalizedName("Zombie Pickaxe");
	public static Item zombieAxe = new ItemZombieAxe(toolSoul)
			.setUnlocalizedName("Zombie Axe");
	public static Item zombieShovel = new ItemZombieShovel(toolSoul)
			.setUnlocalizedName("Zombie Shovel");

	public static Item enderSword = new ItemEnderSword(toolSoul)
			.setUnlocalizedName("Ender Sword");
	public static Item enderPickaxe = new ItemEnderPickaxe(toolSoul)
			.setUnlocalizedName("Ender Pickaxe");
	public static Item enderAxe = new ItemEnderAxe(toolSoul)
			.setUnlocalizedName("Ender Axe");
	public static Item enderShovel = new ItemEnderShovel(toolSoul)
			.setUnlocalizedName("Ender Shovel");
	
	/*public static Item lightningSword = new ItemLightningSword(toolSoul)
	.setUnlocalizedName("Lightning Sword");*/

	// Armor------------------------------------------------------------------------------------

	// Material
	public static ArmorMaterial armorSoul = EnumHelper.addArmorMaterial("SOUL",
			23, new int[] { 3, 8, 6, 3 }, 25);
	public static ArmorMaterial armorSoul2 = EnumHelper.addArmorMaterial(
			"SOUL2", 27, new int[] { 3, 9, 7, 3 }, 30);
	public static ArmorMaterial armorBone = EnumHelper.addArmorMaterial("BONE",
			13, new int[] { 2, 5, 5, 2 }, 21);
	public static ArmorMaterial armorLostSoul = EnumHelper.addArmorMaterial(
			"LOSTSOUL", 25, new int[] { 3, 9, 6, 3 }, 25);
	public static ArmorMaterial armorAqua = EnumHelper.addArmorMaterial("AQUA",
			23, new int[] { 3, 8, 6, 3 }, 25);
	public static ArmorMaterial armorSlime = EnumHelper.addArmorMaterial(
			"SLIME", 23, new int[] { 3, 8, 6, 3 }, 25);
	public static ArmorMaterial armorSpider = EnumHelper.addArmorMaterial(
			"SPIDER", 23, new int[] { 3, 8, 6, 3 }, 25);

	// Armor Items
	public static Item soulHelmet = new ArmorSetSoul(armorSoul, 1, 0)
			.setUnlocalizedName("soulhelmet").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:soulhelmet");
	public static Item soulChest = new ArmorSetSoul(armorSoul, 2, 1)
			.setUnlocalizedName("soulchest").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:soulchestplate");
	public static Item soulLeggings = new ArmorSetSoul(armorSoul, 3, 2)
			.setUnlocalizedName("soulleggings").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:soulleggings");
	public static Item soulBoots = new ArmorSetSoul(armorSoul, 4, 3)
			.setUnlocalizedName("soulboots").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:soulboots");

	public static Item slimeBoots = new ArmorSetSlime(armorSlime, 4, 3)
			.setUnlocalizedName("slime").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:slimeboots");

	public static Item spiderHelmet = new ArmorSetSpider(armorSpider, 1, 0)
			.setUnlocalizedName("spiderhelmet").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:spiderhelmet");
	public static Item spiderChest = new ArmorSetSpider(armorSpider, 2, 1)
			.setUnlocalizedName("spiderchest").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:spiderchestplate");
	public static Item spiderLeggings = new ArmorSetSpider(armorSpider, 3, 2)
			.setUnlocalizedName("spiderleggings").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:spiderleggings");
	public static Item spiderBoots = new ArmorSetSpider(armorSpider, 4, 3)
			.setUnlocalizedName("spiderboots").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:spiderboots");

	public static Item soulHelmet2 = new ArmorSetSoul2(armorSoul2, 1, 0)
			.setUnlocalizedName("soulhelmetv2").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:soulhelmet2");
	public static Item soulChest2 = new ArmorSetSoul2(armorSoul2, 2, 1)
			.setUnlocalizedName("soulchestv2").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:soulchestplate2");
	public static Item soulLeggings2 = new ArmorSetSoul2(armorSoul2, 3, 2)
			.setUnlocalizedName("soulleggingsv2").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:soulleggings2");
	public static Item soulBoots2 = new ArmorSetSoul2(armorSoul2, 4, 3)
			.setUnlocalizedName("soulbootsv2").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:soulboots2");

	public static Item boneHelmet = new ArmorSetBone(armorBone, 1, 0)
			.setUnlocalizedName("bonehelmet").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:bonehelmet");
	public static Item boneChest = new ArmorSetBone(armorBone, 2, 1)
			.setUnlocalizedName("bonechest").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:bonechest");
	public static Item boneLeggings = new ArmorSetBone(armorBone, 3, 2)
			.setUnlocalizedName("boneleggings").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:boneleggings");
	public static Item boneBoots = new ArmorSetBone(armorBone, 4, 3)
			.setUnlocalizedName("boneboots").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:boneboots");

	public static Item lostHelmet = new ArmorSetLost(armorLostSoul, 1, 0)
			.setUnlocalizedName("losthelmet").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:losthelmet");
	public static Item lostChest = new ArmorSetLost(armorLostSoul, 2, 1)
			.setUnlocalizedName("lostchest").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:lostchestplate");
	public static Item lostLeggings = new ArmorSetLost(armorLostSoul, 3, 2)
			.setUnlocalizedName("lostleggings").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:lostleggings");
	public static Item lostBoots = new ArmorSetLost(armorLostSoul, 4, 3)
			.setUnlocalizedName("lostboots").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:lostboots");

	public static Item aquaHelmet = new ArmorSetAqua(armorAqua, 1, 0)
			.setUnlocalizedName("aquahelmet").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:aquahelmet");
	public static Item aquaChest = new ArmorSetAqua(armorAqua, 2, 1)
			.setUnlocalizedName("aquachest").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:aquachestplate");
	public static Item aquaLeggings = new ArmorSetAqua(armorAqua, 3, 2)
			.setUnlocalizedName("aqualeggings").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:aqualeggings");
	public static Item aquaBoots = new ArmorSetAqua(armorAqua, 4, 3)
			.setUnlocalizedName("aquaboots").setCreativeTab(tabSoul)
			.setTextureName("soulcraft:aquaboots");

	// Ore
	// generation-----------------------------------------------------------------------------
	public static WorldgenInfusedStone infusedStoneGen = new WorldgenInfusedStone();

	// public static WorldgenPureInfusedStone pureInfusedStoneGen = new
	// WorldgenPureInfusedStone();

	public SoulCraft() {

		// Crafting Recipes
		// ------------------------------------------------------

		// Bone Sword
		GameRegistry.addRecipe(new ItemStack(boneSword, 1), new Object[] {
				" x ", "XxX", " X ", 'x', Items.bone, 'X', stoneStick });

		// Bone Pick
		GameRegistry.addRecipe(new ItemStack(bonePickaxe, 1), new Object[] {
				"xxx", " X ", " X ", 'x', Items.bone, 'X', stoneStick });

		// Bone axe
		GameRegistry.addRecipe(new ItemStack(boneAxe, 1), new Object[] { " xx",
				" Xx", " X ", 'x', Items.bone, 'X', stoneStick });

		// Bone shovel
		GameRegistry.addRecipe(new ItemStack(boneShovel, 1), new Object[] {
				" x ", " X ", " X ", 'x', Items.bone, 'X', stoneStick });

		// Bone hoe
		GameRegistry.addRecipe(new ItemStack(boneHoe, 1), new Object[] { " xx",
				" X ", " X ", 'x', Items.bone, 'X', stoneStick });

		// Stone stick
		GameRegistry.addRecipe(new ItemStack(stoneStick, 1), new Object[] {
				"X ", "X ", 'X', Blocks.cobblestone });

		// Small soul fragment

		GameRegistry.addShapelessRecipe(new ItemStack(smallSoulFragment, 9),
				new Object[] { new ItemStack(soulFragment) });

		GameRegistry.addRecipe(new ItemStack(soulFragment, 1), new Object[] {
				"XXX", "XXX", "XXX", 'X', smallSoulFragment });

		// Soul bone

		GameRegistry.addRecipe(new ItemStack(soulBone, 1), new Object[] {
				"XXX", "XxX", "XXX", 'X', smallSoulFragment, 'x', Items.bone });

		// Soul sand
		GameRegistry.addRecipe(new ItemStack(Blocks.soul_sand, 4),
				new Object[] { "XXX", "XxX", "XXX", 'X', smallSoulFragment,
						'x', Blocks.sand });

		// soulblock

		GameRegistry.addRecipe(new ItemStack(soulBlock, 1), new Object[] {
				"xx", "xx", 'x', soulFragment });

		GameRegistry.addRecipe(new ItemStack(slimeBlock, 1), new Object[] {
				"xx", "xx", 'x', Items.slime_ball });

		GameRegistry.addRecipe(new ItemStack(enderBlock, 1), new Object[] {
				"XxX", "XEX", "XxX", 'X', Blocks.stone, 'x', smallSoulFragment,
				'E', Items.ender_pearl });
		
		GameRegistry.addRecipe(new ItemStack(zombieBlock, 1), new Object[] {
			"XxX", "XEX", "XxX", 'X', Blocks.stone, 'x', smallSoulFragment,
			'E', zombieEssence });
		
		GameRegistry.addRecipe(new ItemStack(blazeBlock, 1), new Object[] {
			"XxX", "XEX", "XxX", 'X', Blocks.stone, 'x', smallSoulFragment,
			'E', Items.blaze_rod });

		GameRegistry.addShapelessRecipe(new ItemStack(soulFragment, 4),
				new Object[] { new ItemStack(soulBlock) });

		// sool tools

		// soul sword
		GameRegistry.addRecipe(new ItemStack(soulSword, 1), new Object[] {
				" X ", " X ", " x ", 'X', soulFragment, 'x', soulBone });

		// soul pickaxe
		GameRegistry.addRecipe(new ItemStack(soulPickaxe, 1), new Object[] {
				"XXX", " x ", " x ", 'X', soulFragment, 'x', soulBone });

		// bone armor
		GameRegistry.addRecipe(new ItemStack(boneHelmet, 1), new Object[] {
				"XXX", "X X", 'X', Items.bone });

		GameRegistry.addRecipe(new ItemStack(boneChest, 1), new Object[] {
				"X X", "XXX", "XXX", 'X', Items.bone });

		GameRegistry.addRecipe(new ItemStack(boneLeggings, 1), new Object[] {
				"XXX", "X X", "X X", 'X', Items.bone });

		GameRegistry.addRecipe(new ItemStack(boneBoots, 1), new Object[] {
				"X X", "X X", 'X', Items.bone });

		// Soul tarp

		GameRegistry.addRecipe(new ItemStack(soulTrapEmpty, 1), new Object[] {
				"xxx", "XKX", "XXX", 'X', soulFragment, 'x', smallSoulFragment,
				'K', Items.bucket });

		// Soul armor

		GameRegistry.addRecipe(new ItemStack(soulHelmet, 1), new Object[] {
				"XXX", "X X", 'X', soulFragment });

		GameRegistry.addRecipe(new ItemStack(soulChest, 1), new Object[] {
				"X X", "XXX", "XXX", 'X', soulFragment });

		GameRegistry.addRecipe(new ItemStack(soulLeggings, 1), new Object[] {
				"XXX", "X X", "X X", 'X', soulFragment });

		GameRegistry.addRecipe(new ItemStack(soulBoots, 1), new Object[] {
				"X X", "X X", 'X', soulFragment });

		// Soul apples

		GameRegistry.addRecipe(new ItemStack(soulApple, 1), new Object[] {
				"xxx", "xXx", "xxx", 'X', Items.apple, 'x', soulFragment });

		GameRegistry.addRecipe(new ItemStack(soulApple2, 1), new Object[] {
				"xxx", "xXx", "xxx", 'X', soulApple, 'x', soulBlock });

		GameRegistry.addRecipe(new ItemStack(spiderEssence, 1), new Object[] {
				"XxX", "xkx", "XxX", 'X', Items.string, 'x', smallSoulFragment,
				'k', Items.spider_eye });

		GameRegistry.addRecipe(new ItemStack(spiderSword, 1), new Object[] {
				"XxX", 'X', spiderEssence, 'x', soulSword });

		GameRegistry.addRecipe(new ItemStack(spiderPickaxe, 1), new Object[] {
				"XxX", 'X', spiderEssence, 'x', soulPickaxe });
		
		GameRegistry.addRecipe(new ItemStack(spiderHelmet, 1), new Object[] {
			"XxX", 'X', spiderEssence, 'x', soulHelmet });
		
		GameRegistry.addRecipe(new ItemStack(spiderChest, 1), new Object[] {
			"XxX", 'X', spiderEssence, 'x', soulChest });
		
		GameRegistry.addRecipe(new ItemStack(spiderLeggings, 1), new Object[] {
			"XxX", 'X', spiderEssence, 'x', soulLeggings });
		
		GameRegistry.addRecipe(new ItemStack(spiderBoots, 1), new Object[] {
			"XxX", 'X', spiderEssence, 'x', soulBoots });
		
		GameRegistry.addRecipe(new ItemStack(slimeBoots, 1), new Object[] {
			"XxX", 'X', slimeBlock, 'x', soulBoots });

		GameRegistry.addRecipe(new ItemStack(blazeEssence, 1), new Object[] {
				"XxX", "xkx", "XxX", 'X', Items.blaze_powder, 'x',
				smallSoulFragment, 'k', Items.blaze_rod });

		GameRegistry.addRecipe(new ItemStack(blazeSword, 1), new Object[] {
				"XxX", 'X', blazeEssence, 'x', soulSword });

		GameRegistry.addRecipe(new ItemStack(blazePickaxe, 1), new Object[] {
				"XxX", 'X', blazeEssence, 'x', soulPickaxe });

		GameRegistry.addRecipe(new ItemStack(zombieEssence, 1), new Object[] {
				"XxX", "xXx", "XxX", 'X', soulFlesh, 'x', smallSoulFragment });

		GameRegistry.addRecipe(new ItemStack(creeperEssence, 1), new Object[] {
				"XxX", "xXx", "XxX", 'X', Items.gunpowder, 'x',
				soulFragment });
		
		GameRegistry.addRecipe(new ItemStack(explosiveArrow, 16), new Object[] {
			"XxX", "xXx", "XxX", 'X', Items.gunpowder, 'x',
			smallSoulFragment });

		GameRegistry.addRecipe(new ItemStack(zombiePickaxe, 1), new Object[] {
				"XxX", 'X', zombieEssence, 'x', soulPickaxe });

		GameRegistry.addRecipe(new ItemStack(zombieSword, 1), new Object[] {
				"XxX", 'X', zombieEssence, 'x', soulSword });

		GameRegistry.addRecipe(new ItemStack(enderEssence, 1),
				new Object[] { "XxX", "xXx", "XxX", 'X', Items.ender_pearl,
						'x', soulFragment });

		GameRegistry.addRecipe(new ItemStack(enderPickaxe, 1), new Object[] {
				"XxX", 'X', enderEssence, 'x', soulPickaxe });

		GameRegistry.addRecipe(new ItemStack(enderSword, 1), new Object[] {
				"XxX", 'X', enderEssence, 'x', soulSword });

		GameRegistry.addRecipe(new ItemStack(creeperBow, 1), new Object[] {
				"XxX", 'X', creeperEssence, 'x', Items.bow });

		GameRegistry.addRecipe(new ItemStack(blazeBow, 1), new Object[] {
				"XxX", 'X', blazeEssence, 'x', Items.bow });

		GameRegistry.addRecipe(new ItemStack(lostHelmet, 1), new Object[] {
				"x", "X", "k", 'x', soulFragment, 'X', soulHelmet, 'k',
				soulTrapLostSoul });

		GameRegistry.addRecipe(new ItemStack(lostChest, 1), new Object[] { "x",
				"X", "k", 'x', soulFragment, 'X', soulChest, 'k',
				soulTrapLostSoul });

		GameRegistry.addRecipe(new ItemStack(lostBoots, 1), new Object[] { "x",
				"X", "k", 'x', soulFragment, 'X', soulBoots, 'k',
				soulTrapLostSoul });

		GameRegistry.addRecipe(new ItemStack(lostLeggings, 1), new Object[] {
				"x", "X", "k", 'x', soulFragment, 'X', soulLeggings, 'k',
				soulTrapLostSoul });

		GameRegistry.addRecipe(new ItemStack(aquaEssence, 1), new Object[] {
				"XxX", "xkx", "XxX", 'X', Items.fish, 'x', smallSoulFragment,
				'k', new ItemStack(Items.dye, 1, 0) });

		GameRegistry.addRecipe(new ItemStack(aquaBoots, 1), new Object[] {
				"XxX", 'X', aquaEssence, 'x', soulBoots });

		GameRegistry.addRecipe(new ItemStack(aquaChest, 1), new Object[] {
				"XxX", 'X', aquaEssence, 'x', soulChest });

		GameRegistry.addRecipe(new ItemStack(aquaHelmet, 1), new Object[] {
				"XxX", 'X', aquaEssence, 'x', soulHelmet });

		GameRegistry.addRecipe(new ItemStack(aquaLeggings, 1), new Object[] {
				"XxX", 'X', aquaEssence, 'x', soulLeggings });

		GameRegistry.addRecipe(new ItemStack(soulFlesh, 1), new Object[] {
				"XXX", "XxX", "XXX", 'X', Items.rotten_flesh, 'x',
				smallSoulFragment });

		GameRegistry
				.addRecipe(new ItemStack(Items.spawn_egg, 1, 54), new Object[] {
						"XxX", "xkx", "XxX", 'X', SoulCraft.zombieEssence, 'x',
						soulBlock, 'k', soulFlesh });

		GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 58),
				new Object[] { "XxX", "xkx", "XxX", 'X',
						SoulCraft.enderEssence, 'x', soulBlock, 'k',
						Items.ender_eye });

		GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 94),
				new Object[] { "XxX", "xkx", "XxX", 'X', SoulCraft.aquaEssence,
						'x', soulBlock, 'k', Items.fish });

		GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 61),
				new Object[] { "XxX", "xkx", "XxX", 'X',
						SoulCraft.blazeEssence, 'x', soulBlock, 'k',
						Items.blaze_rod });

		GameRegistry.addRecipe(new ItemStack(ultimateSoul), new Object[] {
				"X1X", "2x3", "X4X", 'X', soulBlock, 'x', soulTrapLostSoul,
				'1', new ItemStack(Items.spawn_egg, 1, 54), '2',
				new ItemStack(Items.spawn_egg, 1, 58), '3',
				new ItemStack(Items.spawn_egg, 1, 94), '4',
				new ItemStack(Items.spawn_egg, 1, 61) });

		GameRegistry.addShapelessRecipe(new ItemStack(soulSword2, 1),
				new Object[] { ultimateSoul, soulSword });

		GameRegistry.addShapelessRecipe(new ItemStack(soulPickaxe2, 1),
				new Object[] { ultimateSoul, soulPickaxe });

		GameRegistry.addShapelessRecipe(new ItemStack(soulHelmet2, 1),
				new Object[] { ultimateSoul, soulHelmet });

		GameRegistry.addShapelessRecipe(new ItemStack(soulChest2, 1),
				new Object[] { ultimateSoul, soulChest });

		GameRegistry.addShapelessRecipe(new ItemStack(soulLeggings2, 1),
				new Object[] { ultimateSoul, soulLeggings });

		GameRegistry.addShapelessRecipe(new ItemStack(soulBoots2, 1),
				new Object[] { ultimateSoul, soulBoots });

		GameRegistry.addRecipe(new ItemStack(souleAxe, 1), new Object[] {
				" xx", " Xx", " X ", 'x', soulFragment, 'X', soulBone });

		GameRegistry.addRecipe(new ItemStack(soulShovel, 1), new Object[] {
				" x ", " X ", " X ", 'x', soulFragment, 'X', soulBone });

		GameRegistry.addRecipe(new ItemStack(SoulCraft.soulGlass, 4),
				new Object[] { "SXS", "XxX", "SXS", 'X', SoulCraft.clearGlass,
						'x', SoulCraft.soulTrapLostSoul, 'S',
						SoulCraft.soulFragment });

		GameRegistry.addRecipe(new ItemStack(SoulCraft.clearSoulGlass, 4),
				new Object[] { "SXS", "XxX", "SXS", 'X', SoulCraft.soulGlass,
						'x', SoulCraft.soulTrapLostSoul, 'S',
						SoulCraft.soulFragment });

		GameRegistry.addRecipe(new ItemStack(spiderAxe, 1), new Object[] {
				"XxX", 'X', spiderEssence, 'x', souleAxe });

		GameRegistry.addRecipe(new ItemStack(blazeAxe, 1), new Object[] {
				"XxX", 'X', blazeEssence, 'x', souleAxe });

		GameRegistry.addRecipe(new ItemStack(enderAxe, 1), new Object[] {
				"XxX", 'X', enderEssence, 'x', souleAxe });

		GameRegistry.addRecipe(new ItemStack(zombieAxe, 1), new Object[] {
				"XxX", 'X', zombieEssence, 'x', souleAxe });

		GameRegistry.addRecipe(new ItemStack(spiderShovel, 1), new Object[] {
				"XxX", 'X', spiderEssence, 'x', soulShovel });

		GameRegistry.addRecipe(new ItemStack(blazeShovel, 1), new Object[] {
				"XxX", 'X', blazeEssence, 'x', soulShovel });

		GameRegistry.addRecipe(new ItemStack(enderShovel, 1), new Object[] {
				"XxX", 'X', enderEssence, 'x', soulShovel });

		GameRegistry.addRecipe(new ItemStack(zombieShovel, 1), new Object[] {
				"XxX", 'X', zombieEssence, 'x', soulShovel });

		GameRegistry.addShapelessRecipe(new ItemStack(souleAxe2, 1),
				new Object[] { ultimateSoul, souleAxe });

		GameRegistry.addShapelessRecipe(new ItemStack(soulShovel2, 1),
				new Object[] { ultimateSoul, soulShovel });

		// Smelting Recipes
		// ----------------------------------------------------------
		GameRegistry.addSmelting(Blocks.soul_sand, new ItemStack(
				SoulCraft.clearGlass), 0.8f);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		EntityRegistry.addSpawn(EntityLostSoulMob.class, lostSoulSpawnRate, 2,
				5, EnumCreatureType.monster, BiomeGenBase.beach,
				BiomeGenBase.desert, BiomeGenBase.extremeHills,
				BiomeGenBase.forest, BiomeGenBase.jungle, BiomeGenBase.plains,
				BiomeGenBase.taiga, BiomeGenBase.taigaHills,
				BiomeGenBase.frozenRiver, BiomeGenBase.frozenOcean,
				BiomeGenBase.swampland, BiomeGenBase.extremeHillsEdge,
				BiomeGenBase.extremeHills, BiomeGenBase.forestHills,
				BiomeGenBase.hell, BiomeGenBase.sky, BiomeGenBase.icePlains,
				BiomeGenBase.mesaPlateau);
		// EntityRegistry.addSpawn(EntityWorg.class, worgSpawnrRate, 2, 5,
		// EnumCreatureType.monster,BiomeGenBase.beach, BiomeGenBase.desert,
		// BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.jungle,
		// BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.taigaHills,
		// BiomeGenBase.frozenRiver, BiomeGenBase.frozenOcean,
		// BiomeGenBase.swampland, BiomeGenBase.extremeHillsEdge,
		// BiomeGenBase.extremeHills,BiomeGenBase.forestHills,
		// BiomeGenBase.hell, BiomeGenBase.sky,
		// BiomeGenBase.icePlains,BiomeGenBase.mushroomIsland,
		// BiomeGenBase.mesaPlateau);

	}

}
