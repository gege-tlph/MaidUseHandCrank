package com.sch246.muhc.event;

import com.github.tartaricacid.touhoulittlemaid.api.event.client.AddClothConfigEvent;
import com.sch246.muhc.config.ClothConfigScreen;

public class ClothConfigEvent {
    /**
     * 注册到 TLM 的 Fabric 事件（NeoForge 版走 NeoForge.EVENT_BUS）。
     * lambda 体只在事件触发（cloth-config 存在）时才会加载 cloth 类。
     */
    public static void register() {
        AddClothConfigEvent.CALLBACK.register(event ->
                ClothConfigScreen.init(event.getRoot(), event.getEntryBuilder()));
    }
}
