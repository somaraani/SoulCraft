package somarani.soulcraft.worldgeneration;

import java.util.Random;

import somarani.soulcraft.common.SoulCraft;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldgenPureInfusedStone implements IWorldGenerator {

	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		/*switch (world.provider.dimensionId) {
		
		case -1 : generateNether(world, random, chunkX * 16, chunkZ * 16);  
		case 0 : generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1 : generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
		
	}
		private void generateSurface(World world, Random random, int blockX, int blockZ) {
			
			for(int i = 0; i < SoulCraft.pureSoulSpawnRate; i++ ){
				
				int Xcoord =  blockX + random.nextInt(16);
				int Ycoord = random.nextInt(62);
				int Zcoord = blockZ + random.nextInt(16);
				
				(new WorldGenMinable(SoulCraft.pureInfusedStone, 4)).generate(world, random, Xcoord, Ycoord, Zcoord);
			
		}
		}


		private void generateNether(World world, Random random, int i, int j) {
			
			
				
				
			}
		private void generateEnd(World world, Random random, int i, int j) {
			
			
			
			
		}*/

}
}
