package com.codenjoy.dojo.selfdefense.model;

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


import com.codenjoy.dojo.selfdefense.model.items.*;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.field.AbstractLevel;

import java.util.Comparator;
import java.util.List;

import static com.codenjoy.dojo.games.selfdefense.Element.*;

public class Level extends AbstractLevel {

    public Level(String map) {
        super(map);
    }

    public List<Hero> bases() {
        return find(Hero::new,
                BASE, OTHER_BASE);
    }

    public List<Enemy> enemies() {
        return find(Enemy::new,
                ENEMY);
    }

    public List<Platform> platforms(List<Hero> bases) {
        return find((pt, el) -> new Platform(pt, nearest(bases, pt)),
                PLATFORM, OTHER_PLATFORM);
    }

    private Hero nearest(List<Hero> bases, Point point) {
        return bases.stream()
                .sorted(Comparator.comparingDouble(base -> base.distance(point)))
                .findFirst()
                .get();
    }

    public List<Spaceship> spaceships(List<Hero> bases) {
        return find((pt, el) -> new Spaceship(pt, nearest(bases, pt)),
                SPACESHIP, OTHER_SPACESHIP);
    }

    public List<Guard> guards(List<Hero> bases) {
        return find((pt, el) -> new Guard(pt, nearest(bases, pt)),
                GUARD, OTHER_GUARD);
    }
}