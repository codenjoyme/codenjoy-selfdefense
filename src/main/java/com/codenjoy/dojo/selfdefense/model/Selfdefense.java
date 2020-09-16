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
import com.codenjoy.dojo.selfdefense.services.Events;
import com.codenjoy.dojo.services.BoardUtils;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.printer.BoardReader;

import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Selfdefense implements Field {

    private List<Guard> guards;
    private List<Platform> platforms;
    private List<Spaceship> spaceships;
    private List<Enemy> enemies;
    private List<Hero> bases;

    private List<Player> players;

    private final int size;
    private Dice dice;

    public Selfdefense(Level level, Dice dice) {
        this.dice = dice;
        bases = level.getBases();
        platforms = level.getPlatforms(bases);
        spaceships = level.getSpaceships(bases);
        guards = level.getGuards(bases);
        enemies = level.getEnemies();
        size = level.getSize();
        players = new LinkedList<>();
    }

    @Override
    public void tick() {
        for (Player player : players) {
            Hero hero = player.getHero();

            hero.tick();

//            if (spaceships.contains(hero)) {
//                spaceships.remove(hero);
//                player.event(Events.WIN);
//
//                Point pos = getFreeBase();
//                spaceships.add(new Spaceship(pos));
//            }
        }

        for (Player player : players) {
            Hero hero = player.getHero();

            if (!hero.isAlive()) {
                player.event(Events.LOOSE);
            }
        }
    }

    public int size() {
        return size;
    }

    @Override
    public boolean isBarrier(Point pt) {
        int x = pt.getX();
        int y = pt.getY();

        return x > size - 1
                || x < 0
                || y < 0
                || y > size - 1
                || platforms.contains(pt)
                || getHeroes().contains(pt);
    }

    @Override
    public Hero getFreeBase() {
        return bases.stream()
                .filter(hero -> hero.field() == null)
                .findFirst()
                .get();
    }

    public List<Spaceship> getSpaceships() {
        return spaceships;
    }

    public List<Hero> getHeroes() {
        return players.stream()
                .map(Player::getHero)
                .collect(toList());
    }

    @Override
    public void newGame(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
        player.newHero(this);
    }

    @Override
    public void remove(Player player) {
        players.remove(player);
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Guard> getGuards() {
        return guards;
    }

    @Override
    public BoardReader reader() {
        return new BoardReader() {
            private int size = Selfdefense.this.size;

            @Override
            public int size() {
                return size;
            }

            @Override
            public Iterable<? extends Point> elements() {
                return new LinkedList<Point>(){{
                    addAll(Selfdefense.this.getPlatforms());
                    addAll(Selfdefense.this.getGuards());
                    addAll(Selfdefense.this.getHeroes());
                    addAll(Selfdefense.this.getSpaceships());
                    addAll(Selfdefense.this.getEnemies());
                }};
            }
        };
    }
}
