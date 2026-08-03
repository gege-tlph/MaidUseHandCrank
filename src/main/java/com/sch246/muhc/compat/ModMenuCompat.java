package com.sch246.muhc.compat;

import com.sch246.muhc.config.ClothConfigScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.loader.api.FabricLoader;

/**
 * ModMenu 配置入口，替代 NeoForge 原生 ConfigurationScreen 通道。
 * 只在 cloth-config 存在时提供屏幕工厂。
 */
public class ModMenuCompat implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if (FabricLoader.getInstance().isModLoaded("cloth-config")) {
            return ClothConfigScreen::createScreen;
        }
        return null;
    }
}
