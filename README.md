# 女仆摇手柄 (MaidUseHandCrank) — Minecraft 1.21.11 Fabric

> [!IMPORTANT]
> 本仓库是 [sch246/MaidUseHandCrank](https://github.com/sch246/MaidUseHandCrank)（NeoForge 1.21.1）
> 的非官方 Fabric 移植，目标平台为 **Minecraft 1.21.11 + Fabric**，独立维护，
> 行为基准为上游 NeoForge 1.21.1 版本，本项目不代表原模组官方版本。
> 其他 Minecraft 版本请使用[上游发行版](https://github.com/sch246/MaidUseHandCrank/releases)。

<p align="center">
    <a href="README.md">简体中文</a> |
    <a href="README.en_us.md">English</a>
</p>

这是车万女仆（[Touhou Little Maid](https://github.com/TartaricAcid/TouhouLittleMaid)）和机械动力
（Create）的附属模组：让女仆能使用机械动力的手摇曲柄，并随着好感度提升增加工作能力。
将你的女仆从一名摇动单个手柄的新人，培养成能够同时操作多个曲柄、输出强大动力的王牌机师！

English: An unofficial Fabric 1.21.11 port of MaidUseHandCrank — let Touhou Little Maid operate
Create's hand cranks, with stress output scaling with favorability. See
[README.en_us.md](README.en_us.md).

![王牌机师](https://s2.loli.net/2025/09/23/uXP81c34Fn9VOQg.png)

## 关于本分支

上游本体是 NeoForge 1.21.1 模组。本分支做了「换加载器 + 跨版本」的双重移植，
对接的是本组织维护的女仆与机械动力 Fabric 移植版（见下方[安装](#安装)）。

- 玩法功能与上游 NeoForge 1.21.1 版一致；mod id、任务、配置文件名也保持一致，
  从 NeoForge 1.21.1 存档迁移过来时女仆的任务与曲柄状态不丢。
- 与上游的差异（依赖在 Fabric 侧不存在，非移植取舍）：
  - **Create Connected 的曲柄轮/大曲柄轮不支持**（该模组无 Fabric 版）；
  - **Sable 子维度内的曲柄不支持**（Sable 为 NeoForge 专属）。

## 从新人到大师：女仆的晋升之路

### 第一步：入职培训 (基础操作)
1.  **分配任务**：在女仆的GUI界面中，切换到新增的“手摇曲柄”任务。

![手摇曲柄图片](https://s2.loli.net/2025/09/13/icLEZt92NgwVqpA.png)

2.  **开始工作**：她会自动寻找并移动到附近手摇曲柄的最佳位置开始工作。恭喜，你的第一位员工已上岗！

![⑨摇曲柄图片](https://s2.loli.net/2025/09/13/yrZ3Yo1qBUazGIL.png)

### 第二步：晋升之路 (提升好感度)

员工能力将随着好感度的提升同步增强！

- **动力提升**: 女仆的基础应力(SU)和每次好感度升级带来的 **应力增量** 都是可以配置的。好感度越高，动力越强！
- **熟练工 (好感度过半)**: 解锁 **【耐久操作】** ，单次交互的曲柄持续时间翻倍，让她能腾出手来，同时操作 **两倍** 的曲柄！
- **王牌技师 (满好感度)**: 解锁 **【双手操作】** ，再次将同时操作的曲柄数量 **翻倍** （总计四倍效率）！

### 第三步：产线优化 (进阶技巧)
- **多任务处理**: 当女仆的交互速度有富余时，她会自动寻找附近**额外**的曲柄进行操作，绝不浪费一丝体力！
- **固定工位**: 想让她专心工作？**先让她开始工作，再让她坐下**。这会让她停止乱跑，并开始冒出充满智慧的“打工人语录”。
  - **请注意**: 随着工厂管理的规范化，女仆现在会在非工作时间主动下班了，即便她们被固定在工位上。
  - **已知问题**: 坐下的女仆不抗卸载，重新加载时将不会主动开始工作，可以通过设置家并关闭随机走动来实现固定工位。
- **改变旋转方向**: 在手摇曲柄的位置放置一个**物品展示框**，女仆就会反向摇动曲柄。

---

<details>
<summary>🔧 点击展开：工厂主配置手册 (详细设置)</summary>

所有配置项都在游戏中清晰地分为三类，方便你精细管理。

> 可以从 Touhou Little Maid 的配置界面中编辑；装了 Mod Menu 时也可以从模组列表进入。

### 通用

| 配置项   | 默认值 | 说明                        |
|:------|:---:|:--------------------------|
| 任务优先级 | `5` | 手摇曲柄任务的优先级。修改后需重新设置任务以生效。 |

### 行为

| 配置项           |   默认值    | 说明                                       |
|:--------------|:--------:|:-----------------------------------------|
| 中心搜索半径(block) | `0` (自动) | 以工作中心（玩家/家）为圆心的搜索半径。两个半径满足其一即可。          |
| 女仆搜索半径(block) | `0` (自动) | 以女仆自身为圆心的搜索半径。两个半径满足其一即可。                |
| 交互距离(block)   |   `4`    | 女仆与曲柄的最大交互距离。                            |
| 聪明女仆          |  `true`  | 女仆会在赶到手柄前锁定目标曲柄以防止争抢。                    |
| 随机走动          |  `true`  | 允许女仆“带薪摸鱼”。关闭可稳定生产线，但会增加女仆的“工作压力”（触发气泡）。 |
| 展示框反转         |  `true`  | 允许使用物品展示框反转女仆的操作方向。                      |

### 工作

| 配置项          |  默认值   | 说明                                 |
|:-------------|:------:|:-----------------------------------|
| 聊天气泡间隔(tick) | `600`  | “打工人语录”的平均出现间隔。                    |
| 交互间隔(tick)   |  `8`   | 摇动曲柄的频率。需要比持续时间小 1~2 tick 以维持持续转动。 |
| 持续时间(tick)   |  `10`  | 每次交互，曲柄能持续转动的时间。                   |
| 基础应力(su)     | `256`  | 女仆的初始动力水平。                         |
| 应力增量(su)     |  `10`  | 女仆的成长潜力。每增加一点好感度，应力增加的数值。          |
| 耐久操作         | `true` | 好感度过半时，单次交互的曲柄持续时间翻倍。              |
| 双手操作         | `true` | 好感度满级时，双手操作。                       |

</details>

---

## 兼容性

| 组件 | 要求 |
|---|---|
| Minecraft | 1.21.11 |
| Java | 21 |
| Fabric Loader | 0.16 或更高版本（0.19.3 为当前验证版本） |
| Fabric API | 任意 1.21.11 版本（0.141.4 为当前验证版本） |
| Touhou Little Maid: Tsumugi | 0.8.4+（**必装**） |
| Create Fly | 6.0.x（**必装**，6.0.9 为当前验证版本） |
| Forge Config API Port | 21.11.x（**必装**，21.11.1 为当前验证版本） |
| 安装位置 | 客户端与服务端 |

## 安装

1. 安装适用于 Minecraft 1.21.11 的 Fabric Loader。
2. 从 [Releases](../../releases) 下载 `MaidUseHandCrank_*-fabric-*.jar`。
3. 把本模组与全部必装依赖一起放入客户端和服务端的 `mods` 目录。

### 需要从本组织获取

**女仆本体的 Minecraft 1.21.11 Fabric 版本由本组织移植并维护**，上游没有对应版本，
请从下面的仓库下载：

| 模组 | 用途 | 下载 |
|---|---|---|
| **Touhou Little Maid: Tsumugi** | 女仆本体 | [gege-tlph/TouhouLittleMaid-Tsumugi](https://github.com/gege-tlph/TouhouLittleMaid-Tsumugi/releases) |

### 其余依赖

| 模组 | 用途 | 下载 |
|---|---|---|
| **Create Fly** | 机械动力的 Fabric 移植（ZurrTum 维护） | [Modrinth](https://modrinth.com/mod/create-fly) |
| **Fabric API** | 基础 API | [Modrinth](https://modrinth.com/mod/fabric-api) |
| **Forge Config API Port** | 配置系统 | [Modrinth](https://modrinth.com/mod/forge-config-api-port) |

推荐但非必需：[Mod Menu](https://modrinth.com/mod/modmenu) +
[Cloth Config API](https://modrinth.com/mod/cloth-config)（游戏内配置界面）。

表中版本是当前发布所验证的组合。使用其他兼容版本时若遇到问题，请先用这组版本复现。

## 已知问题

遇到问题请提交 [Issue](../../issues)，并附上 `logs/latest.log`、模组列表和复现步骤。
仅在上游 NeoForge 版出现的问题请报给[上游仓库](https://github.com/sch246/MaidUseHandCrank/issues)。

## 从源码构建

需要 JDK 21：

```bash
./gradlew build
```

Windows PowerShell 用 `.\gradlew.bat build`。产物在 `build/libs/`，使用 Mojang 官方映射。

## 来源与许可证

- 原模组：[sch246/MaidUseHandCrank](https://github.com/sch246/MaidUseHandCrank)（NeoForge 1.21.1）
- 本分支：[gege-tlph/MaidUseHandCrank](https://github.com/gege-tlph/MaidUseHandCrank)

致谢：

- 车万女仆模组：酒石酸菌等
- 机械动力模组：Simibuli 等；Fabric 移植 Create Fly：ZurrTum
- MaidAddition（Cirmuller）：灵感来源，参考了其消息气泡内容

代码采用 [MIT License](https://mit-license.org/)，美术与资源采用
[CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/deed.zh-hans)。
