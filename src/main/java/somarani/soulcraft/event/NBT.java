package somarani.soulcraft.event;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.text.html.HTML.Tag;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class NBT {

	@SubscribeEvent
	public void Event(PlayerLoggedInEvent event) {

		NBTTagCompound tag = event.player.getEntityData();

		NBTBase modeTag = tag.getTag("MyInteger");

		tag.setInteger("MyInteger", 5);

	}

	public static void incrementTag(EntityPlayer player) {
		
		 if(player != null){

		NBTTagCompound tag = player.getEntityData();

		NBTBase modeTag = tag.getTag("MyInteger");

		tag.setInteger("MyInteger", tag.getInteger("MyInteger") + 1);}
	}

	public static void setTag(int num, EntityPlayer player) {
		
		if(player != null){

		NBTTagCompound tag = player.getEntityData();

		NBTBase modeTag = tag.getTag("MyInteger");

		tag.setInteger("MyInteger", num);}
	}

	public static int getTag(EntityPlayer player) {
		
		if(player != null){
		
		NBTTagCompound tag = player.getEntityData();

		NBTBase modeTag = tag.getTag("MyInteger");

		return tag.getInteger("MyInteger");
		}
		
		return 0;

	}

}
