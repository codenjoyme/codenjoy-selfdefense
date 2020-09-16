package com.codenjoy.dojo.selfdefense.model.items;

import com.codenjoy.dojo.selfdefense.model.Elements;
import com.codenjoy.dojo.selfdefense.model.Hero;
import com.codenjoy.dojo.selfdefense.model.Player;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.PointImpl;
import com.codenjoy.dojo.services.State;

public abstract class Ownerable extends PointImpl implements State<Elements, Player> {

    private Hero owner;

    public Ownerable(Point point, Hero owner) {
        super(point);
        this.owner = owner;
    }

    public Hero getHero() {
        return owner;
    }
}
