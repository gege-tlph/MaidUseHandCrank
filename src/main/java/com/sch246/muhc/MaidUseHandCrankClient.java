package com.sch246.muhc;

import net.fabricmc.api.ClientModInitializer;

public class MaidUseHandCrankClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // NeoForge 原生 ConfigurationScreen 无 Fabric 对应物；
        // 配置界面走 ModMenu entrypoint（compat/ModMenuCompat）与 TLM 配置界面（event/ClothConfigEvent）两条通道
    }
}
