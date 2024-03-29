package com.codenjoy.dojo.selfdefense.model.items;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2012 - 2022 Codenjoy
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


import com.codenjoy.dojo.games.selfdefense.Element;
import com.codenjoy.dojo.selfdefense.model.Hero;
import com.codenjoy.dojo.selfdefense.model.Player;
import com.codenjoy.dojo.services.Point;

public class Spaceship extends Ownerable {

    public Spaceship(Point point, Hero owner) {
        super(point, owner);
    }

    @Override
    public Element state(Player player, Object... alsoAtPoint) {
        if (player.getHero() == getHero()) {
            return Element.SPACESHIP;
        } else {
            return Element.OTHER_SPACESHIP;
        }
    }
}
