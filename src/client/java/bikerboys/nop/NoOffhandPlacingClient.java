package bikerboys.nop;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class NoOffhandPlacingClient implements ClientModInitializer {

	// public static KeyBinding enableKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("Disable Off Hand", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Y, "Disable off Hand"));
	public static boolean enabled = false;



	@Override
	public void onInitializeClient() {
		ClientTickEvents.START_CLIENT_TICK.register(this::onClientTick);
	}



	private void onClientTick(MinecraftClient minecraftClient) {
		PlayerEntity player = minecraftClient.player;
		if(player == null) return;

		enabled = true;
		
		// if(enableKey.wasPressed()) {
		// 	minecraftClient.world.playSound(player, player.getBlockPos(), SoundEvents.UI_BUTTON_CLICK.value(), SoundCategory.MASTER, 0.7f, 1f);

		// 	enabled = !enabled;
		// 	if(enabled) {
		// 		player.sendMessage(Text.of("Off Hand Disabled"), true);
		// 	} else {
		// 		player.sendMessage(Text.of("Off Hand Enabled"), true);
		// 	}
		// }
	}


}