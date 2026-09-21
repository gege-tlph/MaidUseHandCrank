# MaidUseHandCrank — Minecraft 1.21.11 Fabric

> [!IMPORTANT]
> This repository is an unofficial **Fabric 1.21.11** port of
> [sch246/MaidUseHandCrank](https://github.com/sch246/MaidUseHandCrank) (NeoForge 1.21.1),
> independently maintained. The upstream NeoForge 1.21.1 version is the behavior baseline;
> this project does not represent the original mod. For other Minecraft versions, use the
> [upstream releases](https://github.com/sch246/MaidUseHandCrank/releases).

<p align="center">
    <a href="README.md">简体中文</a> |
    <a href="README.en_us.md">English</a>
</p>

## Summary

This mod is an addon for Touhou Little Maid and Create. It allows maids to use Create's hand
cranks, and their working capacity increases with favorability.

Train your maid from a rookie operating a single crank into an Ace Mechanist capable of
simultaneously operating multiple cranks and outputting powerful rotational force!

![Ace Mechanist](https://s2.loli.net/2025/09/23/FjGfo6ESyCtLJlB.png)

## About This Branch

The upstream mod targets NeoForge 1.21.1. This branch is a loader + version double port,
built against the Fabric ports of both dependencies (see [Installation](#installation)).

- Gameplay matches the upstream NeoForge 1.21.1 version; mod id, task id and config file
  names are kept identical, so worlds migrated from NeoForge 1.21.1 keep maid tasks and
  crank states.
- Differences from upstream (dependencies that do not exist on Fabric):
  - **Create Connected crank wheels are not supported** (no Fabric version of that mod);
  - **Cranks inside Sable sub-dimensions are not supported** (Sable is NeoForge-only).

## From Rookie to Ace: The Maid's Promotion Path

### Step One: Onboarding Training (Basic Operation)
1.  **Assign Task**: In the maid's GUI, switch to the newly added "Hand Crank" task.

![Hand Crank Image](https://s2.loli.net/2025/09/13/jtRoi6OU2cumlfG.png)

2.  **Start Working**: She will automatically find and move to the best position near a hand crank to begin working. Congratulations, your first employee is on duty!

![⑨ Using Hand Crank Image](https://s2.loli.net/2025/09/13/IJG8MVOjoeByRca.png)

### Step Two: Path to Promotion (Increasing Favorability)

Employee capabilities will enhance synchronously with increased favorability!

-   **Power Boost**: The maid's base Stress Unit (SU) and the **Stress Increment** gained with each favorability level increase are configurable. Higher favorability means stronger power!
-   **Skilled Worker (Favorability > Half)**: Unlocks **[Endurance Operation]**, doubling the duration of each crank interaction. This allows her to free her hands and simultaneously operate **twice** the number of cranks!
-   **Ace Mechanist (Max Favorability)**: Unlocks **[Ambidextrous Operation]**, again **doubling** the number of cranks she can operate simultaneously (four times the efficiency overall)!

### Step Three: Production Line Optimization (Advanced Techniques)
-   **Multitasking**: When the maid has a surplus of interaction speed, she will automatically seek out nearby **additional** cranks to operate, never wasting a single bit of energy!
-   **Fixed Workstation**: Want her to focus on work? **Have her start working, then make her sit down**. This will stop her from wandering and cause her to start spouting insightful "worker quotes".
  -   **Please note**: With the standardization of factory management, maids will now voluntarily go off duty during non-working hours, even if they are fixed at a workstation.
  -   **Known Issue**: Maids that are sitting down are not resistant to unloading. They will not automatically resume work upon reloading. A fixed workstation can be achieved by setting their home and disabling random walking.
-   **Change Direction**: Place an **item frame** at the hand crank's position, and the maid will crank in the reverse direction.

---

<details>
<summary>🔧 Click to Expand: Factory Owner's Configuration Manual (Detailed Settings)</summary>

all configuration items are clearly divided into three categories in-game, allowing for precise management.

> You can edit from Touhou Little Maid's configuration interface; with Mod Menu installed,
> the config screen is also available from the mods list.

### General

| Config Item   | Default | Description                                                                                     |
|:--------------|:-------:|:------------------------------------------------------------------------------------------------|
| Task Priority |   `5`   | The priority of hand crank tasks. The task needs to be reset to take effect after modification. |

### Behavior

| Config Item                 |  Default   | Description                                                                                                                               |
|:----------------------------|:----------:|:------------------------------------------------------------------------------------------------------------------------------------------|
| Center Search Radius(block) | `0` (auto) | Search radius for hand cranks centered around the work center (player/home). Meeting either radius is sufficient. 0 is auto.              |
| Maid Search Radius(block)   | `0` (auto) | Search radius for hand cranks centered around the maid herself. Meeting either radius is sufficient. 0 is auto.                           |
| Reach Radius(block)         |    `4`     | Maximum interaction distance between the maid and the crank.                                                                              |
| Smarter Maid                |   `true`   | The maid will lock on to the target crank before she gets to it to prevent a scramble.                                                    |
| Random Walk                 |   `true`   | Allow maids to "fish with pay". Turning off stabilizes the production line, but increases "work pressure" on employees (trigger bubbles). |
| ItemFrame Interaction       |   `true`   | Allow using the Item Frame to reverse the direction of the maid's operation.                                                              |

### Work

| Config Item                | Default | Description                                                                                                        |
|:---------------------------|:-------:|:-------------------------------------------------------------------------------------------------------------------|
| Chat Bubble Interval(tick) |  `600`  | Average interval for "worker quotes" to appear.                                                                    |
| Operation Interval(tick)   |   `8`   | Determine the frequency of cranking. Needs to be 1~2 ticks less than the duration to maintain continuous rotation. |
| Operation Duration(ticks)  |  `10`   | The amount of time the crank can continue to rotate with each interaction.                                         |
| Base Stress(su)            |  `256`  | Base stress generated when shaking the handle with a maid at zero favorability.                                    |
| Stress Increment(su)       |  `10`   | Additional stress gained per favorability point increase for the maid.                                             |
| Extended Operation         | `true`  | When maid's favorability reaches half level, doubled the duration of crank operation per interaction.              |
| Two-Handed Operation       | `true`  | When maid's favorability reaches maximum level, the maid can operate with both hands.                              |

</details>

---

## Compatibility

| Component | Requirement |
|---|---|
| Minecraft | 1.21.11 |
| Java | 21 |
| Fabric Loader | 0.16 or newer (0.19.3 is the currently verified version) |
| Fabric API | any 1.21.11 build (0.141.4 is the currently verified version) |
| Touhou Little Maid: Tsumugi | 0.8.4+ (**required**, 0.8.8 is the currently verified version) |
| Create Fly | 6.0.x (**required**, 6.0.9 is the currently verified version) |
| Forge Config API Port | 21.11.x (**required**, 21.11.1 is the currently verified version) |
| Installation side | client and server |

## Installation

1. Install Fabric Loader for Minecraft 1.21.11.
2. Download `MaidUseHandCrank_*-fabric-*.jar` from [Releases](../../releases).
3. Put this mod together with all required dependencies into the `mods` folder on both
   client and server.

### Maintained by this organization

**The Minecraft 1.21.11 Fabric build of Touhou Little Maid is ported and maintained by this
organization** — there is no upstream release for it:

| Mod | Purpose | Download |
|---|---|---|
| **Touhou Little Maid: Tsumugi** | the maid mod itself | [gege-tlph/TouhouLittleMaid-Tsumugi](https://github.com/gege-tlph/TouhouLittleMaid-Tsumugi/releases) |

### Other dependencies

| Mod | Purpose | Download |
|---|---|---|
| **Create Fly** | Fabric port of Create (by ZurrTum) | [Modrinth](https://modrinth.com/mod/create-fly) |
| **Fabric API** | base API | [Modrinth](https://modrinth.com/mod/fabric-api) |
| **Forge Config API Port** | config system | [Modrinth](https://modrinth.com/mod/forge-config-api-port) |

Recommended but optional: [Mod Menu](https://modrinth.com/mod/modmenu) +
[Cloth Config API](https://modrinth.com/mod/cloth-config) (in-game config screen).

The versions in the table are the combination the current release was verified with. If you
hit problems on other compatible versions, please reproduce with this combination first.

## Issues

Please open an [Issue](../../issues) with `logs/latest.log`, your mod list and reproduction
steps. Problems that also occur on the upstream NeoForge version belong to the
[upstream tracker](https://github.com/sch246/MaidUseHandCrank/issues).

## Building from Source

Requires JDK 21:

```bash
./gradlew build
```

On Windows PowerShell use `.\gradlew.bat build`. Artifacts are in `build/libs/`, built with
official Mojang mappings.

## Origin & License

- Original mod: [sch246/MaidUseHandCrank](https://github.com/sch246/MaidUseHandCrank) (NeoForge 1.21.1)
- This branch: [gege-tlph/MaidUseHandCrank](https://github.com/gege-tlph/MaidUseHandCrank)

Thanks:

- Touhou Little Maid: TartaricAcid and others
- Create: Simibuli and others; Create Fly (Fabric port): ZurrTum
- MaidAddition (Cirmuller): inspiration, and the source of the chat bubble quotes

Code: [MIT](https://mit-license.org/) · Assets:
[CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/)
