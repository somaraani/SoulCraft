package somarani.soulcraft.event;
import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class KeyBindings {
    public static KeyBinding space;
    public static KeyBinding shift;

    public static void init() {

        space = new KeyBinding("key.space", Keyboard.KEY_SPACE, "key.categories.mymod");
        shift = new KeyBinding("key.shift", Keyboard.KEY_LSHIFT, "key.categories.mymod");
        
        ClientRegistry.registerKeyBinding(space);
        ClientRegistry.registerKeyBinding(shift);
    }

}