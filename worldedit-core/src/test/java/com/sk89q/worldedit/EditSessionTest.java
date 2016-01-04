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

package com.sk89q.worldedit;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 */
public class EditSessionTest {
    @Test
    public void slopeTest() {
        assertEquals(22, EditSession.sizeAtHeight(22, 22, 0));
        assertEquals(21, EditSession.sizeAtHeight(22, 22, 1));
        assertEquals(20, EditSession.sizeAtHeight(22, 22, 2));
        assertEquals(19, EditSession.sizeAtHeight(22, 22, 3));
        assertEquals(19, EditSession.sizeAtHeight(22, 22, 4));
        assertEquals(18, EditSession.sizeAtHeight(22, 22, 5));
        assertEquals(1, EditSession.sizeAtHeight(22, 22, 27));
    }
}