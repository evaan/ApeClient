package com.obamabob.apeclient;

import com.obamabob.apeclient.modules.AntiKnockBack;
import com.obamabob.apeclient.modules.BunnyHop;
import net.minecraftforge.common.MinecraftForge;

public class ModuleManager {
    public ModuleManager() {
        MinecraftForge.EVENT_BUS.register(new BunnyHop());
    }
}
