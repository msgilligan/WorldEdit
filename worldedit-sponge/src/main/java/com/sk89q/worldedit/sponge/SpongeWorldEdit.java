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

import com.google.inject.Inject;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.regions.RegionSelector;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.world.World;

@Plugin(id = "worldedit-sponge", name = "WorldEdit", version = "%VERSION%")
public class SpongeWorldEdit {

    private SpongePlatform platform;
    @Inject private PluginContainer container;

    @Listener
    public void onInit(GameInitializationEvent e) {
        this.platform = new SpongePlatform(this);

        WorldEdit.getInstance().getPlatformManager().register(platform);
    }

    public SpongePlayer wrapPlayer(Player player) {
        return new SpongePlayer(this, player);
    }

    public LocalSession getSession(Player player) {
        return WorldEdit.getInstance().getSessionManager().get(wrapPlayer(player));
    }

    public com.sk89q.worldedit.world.World getWorld(World world) {
        return new SpongeWorld(world);
    }

    public RegionSelector getRegionSelection(Player player) {
        return getSession(player).getRegionSelector(getWorld(player.getWorld()));
    }

    public void setSelection(Player player, RegionSelector selection) {
        getSession(player).setRegionSelector(getWorld(player.getWorld()), selection);
    }

    public PluginContainer getContainer() {
        return container;
    }

    public String getVersion() {
        return this.getContainer().getVersion();
    }
}
