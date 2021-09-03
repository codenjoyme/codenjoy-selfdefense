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


import com.codenjoy.dojo.selfdefense.model.items.*;
import com.codenjoy.dojo.services.LengthToXY;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.field.AbstractLevel;
import com.codenjoy.dojo.utils.LevelUtils;

import java.util.Comparator;
import java.util.List;

import static com.codenjoy.dojo.games.selfdefense.Element.*;

public class Level extends AbstractLevel {

    public Level(String map) {
        super(map);
    }

    public List<Hero> getBases() {
        return find(Hero::new,
                BASE, OTHER_BASE);
    }

    public List<Enemy> getEnemies() {
        return find(Enemy::new,
                ENEMY);
    }

    public List<Platform> getPlatforms(List<Hero> bases) {
        return find((pt, el) -> new Platform(pt, getNearest(bases, pt)),
                PLATFORM, OTHER_PLATFORM);
    }

    private Hero getNearest(List<Hero> bases, Point point) {
        return bases.stream()
                .sorted(Comparator.comparingDouble(base -> base.distance(point)))
                .findFirst()
                .get();
    }

    public List<Spaceship> getSpaceships(List<Hero> bases) {
        return find((pt, el) -> new Spaceship(pt, getNearest(bases, pt)),
                SPACESHIP, OTHER_SPACESHIP);
    }

    public List<Guard> getGuards(List<Hero> bases) {
        return find((pt, el) -> new Guard(pt, getNearest(bases, pt)),
                GUARD, OTHER_GUARD);
    }
}