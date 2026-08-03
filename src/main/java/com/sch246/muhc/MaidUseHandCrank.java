package com.sch246.muhc;

import com.mojang.logging.LogUtils;
import com.sch246.muhc.create.InitPoi;
import fuzs.forgeconfigapiport.fabric.api.v5.ConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

public class MaidUseHandCrank implements ModInitializer {
    public static final String MODID = "muhc";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        InitPoi.init();
        // Forge Config API Port：文件名与 NeoForge 版一致（muhc-common.toml）
        ConfigRegistry.INSTANCE.register(MODID, ModConfig.Type.COMMON, Config.SPEC);
    }
}
