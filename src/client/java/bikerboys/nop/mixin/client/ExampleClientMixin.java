package bikerboys.nop.mixin.client;

import bikerboys.nop.NoOffhandPlacingClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ClientPlayerInteractionManager.class)
@Debug(export = true)
public abstract class ExampleClientMixin {
	@Shadow @Final private ClientPlayNetworkHandler networkHandler;

	@Shadow protected abstract void syncSelectedSlot();

	@Shadow @Final private MinecraftClient client;


	@Inject(method = "interactBlock", at = @At(value = "HEAD"), cancellable = true)
	private void method(ClientPlayerEntity player, Hand hand, BlockHitResult hitResult, CallbackInfoReturnable<ActionResult> cir){
		if (hand == Hand.OFF_HAND && NoOffhandPlacingClient.enabeled) {
			// Return a custom result without executing the rest of the method.
			cir.setReturnValue(ActionResult.FAIL);
		}

	}
}