package com.codenjoy.dojo.selfdefense.client;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.client.AbstractBoard;

public class Board extends AbstractBoard<Element> {

    @Override
    public Element valueOf(char ch) {
        return Element.valueOf(ch);
    }

        // TODO

//    public boolean isBarrierAt(int x, int y) {
//        return isAt(x, y, Elements.WALL, Elements.OTHER_HERO);
//    }
//
//    public Point getMe() {
//        return get(Elements.DEAD_HERO,
//                Elements.HERO).get(0);
//    }
//
//    public boolean isGameOver() {
//        return !get(Elements.DEAD_HERO).isEmpty();
//    }
//
//    public boolean isBombAt(int x, int y) {
//        return isAt(x, y, Elements.BOMB);
//    }
}
