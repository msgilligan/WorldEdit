/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.sk89q.worldedit.sponge;

import com.google.common.collect.ImmutableMap;
import com.sk89q.worldedit.LocalConfiguration;
import com.sk89q.worldedit.entity.Player;
import com.sk89q.worldedit.extension.platform.Capability;
import com.sk89q.worldedit.extension.platform.Platform;
import com.sk89q.worldedit.extension.platform.Preference;
import com.sk89q.worldedit.util.command.Dispatcher;
import com.sk89q.worldedit.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class SpongePlatform implements Platform {

    private SpongeWorldEdit worldedit;


    public SpongePlatform(SpongeWorldEdit spongeWorldEdit) {
        this.worldedit = spongeWorldEdit;
    }

    @Override
    public int resolveItem(String name) {
        return 0;
    }

    @Override
    public boolean isValidMobType(String type) {
        return false;
    }

    @Override
    public void reload() {

    }

    @Override
    public int schedule(long delay, long period, Runnable task) {
        return 0;
    }

    @Override
    public List<? extends World> getWorlds() {
        return null;
    }

    @Nullable
    @Override
    public Player matchPlayer(Player player) {
        return null;
    }

    @Nullable
    @Override
    public World matchWorld(World world) {
        return null;
    }

    @Override
    public void registerCommands(Dispatcher dispatcher) {

    }

    @Override
    public void registerGameHooks() {

    }

    @Override
    public LocalConfiguration getConfiguration() {
        return null;
    }

    @Override
    public String getVersion() {
        return worldedit.getContainer().getVersion();
    }

    @Override
    public String getPlatformName() {
        return "Sponge-Official-Shim";
    }

    @Override
    public String getPlatformVersion() {
        return worldedit.getContainer().getVersion();
    }

    private static final Map<Capability, Preference> capabilities = ImmutableMap.<Capability, Preference>builder()
            .put(Capability.CONFIGURATION, Preference.PREFER_OTHERS)
            .put(Capability.WORLDEDIT_CUI, Preference.PREFER_OTHERS)
            .put(Capability.GAME_HOOKS, Preference.PREFER_OTHERS)
            .put(Capability.PERMISSIONS, Preference.PREFER_OTHERS)
            .put(Capability.USER_COMMANDS, Preference.PREFER_OTHERS)
            .put(Capability.WORLD_EDITING, Preference.PREFER_OTHERS)
            .build();

    @Override
    public Map<Capability, Preference> getCapabilities() {
        return capabilities;
    }
}
