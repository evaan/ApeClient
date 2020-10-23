package com.obamabob.apeclient.module;

import com.obamabob.apeclient.module.modules.*;
import net.minecraftforge.common.MinecraftForge;

public class ModuleManager {
    public ModuleManager() {
        MinecraftForge.EVENT_BUS.register(new AntiKnockBack());
        MinecraftForge.EVENT_BUS.register(new BunnyHop());
        MinecraftForge.EVENT_BUS.register(new ESP());
        MinecraftForge.EVENT_BUS.register(new KillAura());
        MinecraftForge.EVENT_BUS.register(new Sprint());
    }
}
