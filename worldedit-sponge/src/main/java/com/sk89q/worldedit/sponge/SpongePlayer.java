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

import com.sk89q.worldedit.LocalPlayer;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldVector;
import com.sk89q.worldedit.entity.BaseEntity;
import com.sk89q.worldedit.extent.inventory.BlockBag;
import com.sk89q.worldedit.session.SessionKey;
import com.sk89q.worldedit.util.Location;
import com.sk89q.worldedit.world.World;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;

import javax.annotation.Nullable;
import java.util.UUID;

public class SpongePlayer extends LocalPlayer {

    private SpongeWorldEdit we;
    private Player player;

    public SpongePlayer(SpongeWorldEdit we, Player player) {
        this.we = we;
        this.player = player;
    }

    @Override
    public World getWorld() {
        return we.getWorld(player.getWorld());
    }

    @Override
    public int getItemInHand() {
        return 0;
    }

    @Override
    public void giveItem(int type, int amount) {

    }

    @Override
    public BlockBag getInventoryBlockBag() {
        return null;
    }

    @Override
    public WorldVector getPosition() {
        return null;
    }

    @Override
    public double getPitch() {
        return 0;
    }

    @Override
    public double getYaw() {
        return 0;
    }

    @Override
    public void setPosition(Vector pos, float pitch, float yaw) {

    }

    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public void printRaw(String msg) {
        player.sendMessage(Texts.of(msg));
    }

    @Override
    public void printDebug(String msg) {
        player.sendMessage(Texts.of(TextColors.GRAY, msg));
    }

    @Override
    public void print(String msg) {
        player.sendMessage(Texts.of(TextColors.YELLOW, msg));
    }

    @Override
    public void printError(String msg) {
        player.sendMessage(Texts.of(TextColors.RED, msg));
    }

    @Nullable
    @Override
    public BaseEntity getState() {
        return null;
    }

    @Override
    public Location getLocation() {
        return null;
    }

    @Nullable
    @Override
    public <T> T getFacet(Class<? extends T> cls) {
        return null;
    }

    @Override
    public UUID getUniqueId() {
        return player.getUniqueId();
    }

    @Override
    public SessionKey getSessionKey() {
        return new SessionKeyImpl(getUniqueId(), getName());
    }

    @Override
    public String[] getGroups() {
        return new String[0];
    }

    @Override
    public boolean hasPermission(String permission) {
        return false;
    }

    private static class SessionKeyImpl implements SessionKey {
        // If not static, this will leak a reference

        private final UUID uuid;
        private final String name;

        private SessionKeyImpl(UUID uuid, String name) {
            this.uuid = uuid;
            this.name = name;
        }

        @Override
        public UUID getUniqueId() {
            return uuid;
        }

        @Nullable
        @Override
        public String getName() {
            return name;
        }

        @Override
        public boolean isActive() {
            return false;
        }

        @Override
        public boolean isPersistent() {
            return true;
        }

    }
}
