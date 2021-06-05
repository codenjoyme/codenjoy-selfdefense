package com.codenjoy.dojo.selfdefense.model;

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


import com.codenjoy.dojo.selfdefense.client.Element;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.State;
import com.codenjoy.dojo.services.joystick.NoDirectionJoystick;
import com.codenjoy.dojo.services.multiplayer.PlayerHero;

public class Hero extends PlayerHero<Field> implements State<Element, Player>, NoDirectionJoystick {

    private boolean alive;
    private Direction direction;

    public Hero(Point xy) {
        super(xy);
        alive = true;
    }

    @Override
    public void init(Field field) {
        this.field = field;
    }

    @Override
    public void act(int... p) {
        if (!alive) return;

        // TODO продолжить тут
    }

    @Override
    public void tick() {
        if (!alive) return;

        // TODO продолжить тут
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public Element state(Player player, Object... alsoAtPoint) {
        if (player.getHero() == this) {
            return Element.BASE;
        } else {
            return Element.OTHER_BASE;
        }
    }
}
