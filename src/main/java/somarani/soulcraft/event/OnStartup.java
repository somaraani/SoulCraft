package somarani.soulcraft.event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import somarani.soulcraft.common.SoulCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class OnStartup {

	@SubscribeEvent
	public void Event(PlayerLoggedInEvent event) {
		
		if(SoulCraft.checkUpdate){
		
		try {
			if (isUpdateAvailable()) {
				GuiNewChat chat = Minecraft.getMinecraft().ingameGUI
						.getChatGUI();
				chat.printChatMessage(new ChatComponentText(
						"An update is available for Soulcraft, get it at \u00a7bsoulcraftmod.tk"));
				
				System.out.println("An update is available for Soulcraft, get it at - www.soulcraftmod.tk");
			}

			else {
				GuiNewChat chat = Minecraft.getMinecraft().ingameGUI
						.getChatGUI();
				chat.printChatMessage(new ChatComponentText(
						"Soulcraft is up-to date!"));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

	}}

	public static boolean isUpdateAvailable() throws IOException,
			MalformedURLException {

		BufferedReader versionFile = new BufferedReader(new InputStreamReader(
				new URL("http://pastebin.com/raw.php?i=YX76ER6s").openStream()));
		String curVersion = versionFile.readLine();

		versionFile.close(); 

		System.out.println(curVersion);

		if (!curVersion.contains(SoulCraft.VERSION)) {
			return true;
		}

		return false;
	}

}
