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

import java.util.LinkedList;
import java.util.List;

import static com.codenjoy.dojo.selfdefense.model.Elements.*;
import static java.util.stream.Collectors.toList;

public class LevelImpl implements Level {

    private final LengthToXY xy;
    private String map;

    public LevelImpl(String map) {
        this.map = map;
        xy = new LengthToXY(getSize());
    }

    @Override
    public int getSize() {
        return (int) Math.sqrt(map.length());
    }

    @Override
    public List<Hero> getBases() {
        return pointsOf(BASE, OTHER_BASE).stream()
                .map(pair -> new Hero(pair.point))
                .collect(toList());
    }

    @Override
    public List<Enemy> getEnemies() {
        return pointsOf(ENEMY).stream()
                .map(pair -> new Enemy(pair.point))
                .collect(toList());
    }

    @Override
    public List<Platform> getPlatforms(List<Hero> bases) {
        return pointsOf(PLATFORM, OTHER_PLATFORM).stream()
                .map(pair -> new Platform(pair.point, bases.get(pair.index)))
                .collect(toList());
    }

    @Override
    public List<Spaceship> getSpaceships(List<Hero> bases) {
        return pointsOf(SPACESHIP, OTHER_SPACESHIP).stream()
                .map(pair -> new Spaceship(pair.point, bases.get(pair.index)))
                .collect(toList());
    }

    @Override
    public List<Guard> getGuards(List<Hero> bases) {
        return pointsOf(GUARD, OTHER_GUARD).stream()
                .map(pair -> new Guard(pair.point, bases.get(pair.index)))
                .collect(toList());
    }

    private static class Pair {
        Point point;
        int index;

        public Pair(Point point, int index) {
            this.point = point;
            this.index = index;
        }
    }

    private List<Pair> pointsOf(Elements... elements) {
        List<Pair> result = new LinkedList<>();
        for (int index = 0; index < map.length(); index++) {
            for (Elements el : elements) {
                if (el.ch == map.charAt(index)) {
                    result.add(new Pair(xy.getXY(index), index));
                }
            }
        }
        return result;
    }
}
