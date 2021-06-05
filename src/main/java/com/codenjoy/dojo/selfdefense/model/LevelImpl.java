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
import com.codenjoy.dojo.utils.LevelUtils;

import java.util.Comparator;
import java.util.List;

import static com.codenjoy.dojo.selfdefense.client.Element.*;

public class LevelImpl implements Level {

    private LengthToXY xy;
    private String map;

    public LevelImpl(String map) {
        this.map = LevelUtils.clear(map);
        xy = new LengthToXY(getSize());
    }

    @Override
    public int getSize() {
        return (int) Math.sqrt(map.length());
    }

    @Override
    public List<Hero> getBases() {
        return LevelUtils.getObjects(xy, map,
                (pt, el) -> new Hero(pt),
                BASE, OTHER_BASE);
    }

    @Override
    public List<Enemy> getEnemies() {
        return LevelUtils.getObjects(xy, map,
                (pt, el) -> new Enemy(pt),
                ENEMY);
    }

    @Override
    public List<Platform> getPlatforms(List<Hero> bases) {
        return LevelUtils.getObjects(xy, map,
                (pt, el) -> new Platform(pt, getNearest(bases, pt)),
                PLATFORM, OTHER_PLATFORM);
    }

    private Hero getNearest(List<Hero> bases, Point point) {
        return bases.stream()
                .sorted(Comparator.comparingDouble(base -> base.distance(point)))
                .findFirst()
                .get();
    }

    @Override
    public List<Spaceship> getSpaceships(List<Hero> bases) {
        return LevelUtils.getObjects(xy, map,
                (pt, el) -> new Spaceship(pt, getNearest(bases, pt)),
                SPACESHIP, OTHER_SPACESHIP);
    }

    @Override
    public List<Guard> getGuards(List<Hero> bases) {
        return LevelUtils.getObjects(xy, map,
                (pt, el) -> new Guard(pt, getNearest(bases, pt)),
                GUARD, OTHER_GUARD);
    }
}
