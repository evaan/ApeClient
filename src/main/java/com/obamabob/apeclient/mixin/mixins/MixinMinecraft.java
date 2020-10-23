package com.obamabob.apeclient.mixin.mixins;

import com.obamabob.apeclient.KeyBindHandler;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;dispatchKeypresses()V", shift = At.Shift.AFTER))
    private void onKeyboard(CallbackInfo callbackInfo) {
        if (Keyboard.getEventKeyState()) {
            KeyBindHandler.registerKey(Keyboard.getEventKey());
        }
    }
}
