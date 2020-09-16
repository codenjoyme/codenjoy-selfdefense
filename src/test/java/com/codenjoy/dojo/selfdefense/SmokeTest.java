package com.codenjoy.dojo.selfdefense;

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


import com.codenjoy.dojo.client.ClientBoard;
import com.codenjoy.dojo.client.local.LocalGameRunner;
import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.selfdefense.client.Board;
import com.codenjoy.dojo.selfdefense.client.ai.AISolver;
import com.codenjoy.dojo.selfdefense.services.GameRunner;
import com.codenjoy.dojo.services.Dice;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SmokeTest {

    private Dice dice;

    @Test
    public void test() {
        // given
        List<String> messages = new LinkedList<>();

        LocalGameRunner.timeout = 0;
        LocalGameRunner.out = (e) -> messages.add(e);
        LocalGameRunner.countIterations = 10;

        Dice dice = LocalGameRunner.getDice(
                0, 1, 2, 3, 4, // random numbers
                0, 2, 2, 3, 1,
                0, 1, 4, 1, 2,
                1, 3, 2, 4, 1,
                1, 3, 0, 0, 1,
                0, 0, 1, 0, 2,
                1, 3, 2, 4, 1,
                0, 1, 1, 3, 3,
                0, 2, 0, 0, 2,
                0, 1, 2, 2, 1,
                1, 3, 4, 3, 4,
                1, 3, 2, 4, 1,
                0, 1, 3, 1, 1);

        GameRunner gameType = new GameRunner() {
            @Override
            public Dice getDice() {
                return dice;
            }

            @Override
            protected String getMap() {
                return  "X .   X , " +
                        " .      , " +
                        ". X . , X," +
                        "          " +
                        ". .    ,  " +
                        "          " +
                        "  .    ,  " +
                        " ===  --- " +
                        " +++  *** " +
                        " +☺+  *☻* ";
            }
        };

        // when
        LocalGameRunner.run(gameType,
                new LinkedList<Solver>(){{
                    add(new AISolver(dice));
                    add(new AISolver(dice));
                }},
                new LinkedList<ClientBoard>(){{
                    add(new Board());
                    add(new Board());
                }});

        // then
        assertEquals("1:Board:\n" +
                        "1:X .   X , \n" +
                        "1: .      , \n" +
                        "1:. X . , X,\n" +
                        "1:          \n" +
                        "1:. .    ,  \n" +
                        "1:          \n" +
                        "1:  .    ,  \n" +
                        "1: ===  --- \n" +
                        "1: +++  *** \n" +
                        "1: +☺+  *☻* \n" +
                        "1:\n" +
                        "1:Scores: 0\n" +
                        "1:Answer: \n" +
                        "2:Board:\n" +
                        "2:X ,   X . \n" +
                        "2: ,      . \n" +
                        "2:, X , . X.\n" +
                        "2:          \n" +
                        "2:, ,    .  \n" +
                        "2:          \n" +
                        "2:  ,    .  \n" +
                        "2: ---  === \n" +
                        "2: ***  +++ \n" +
                        "2: *☻*  +☺+ \n" +
                        "2:\n" +
                        "2:Scores: 0\n" +
                        "2:Answer: \n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:X .   X , \n" +
                        "1: .      , \n" +
                        "1:. X . , X,\n" +
                        "1:          \n" +
                        "1:. .    ,  \n" +
                        "1:          \n" +
                        "1:  .    ,  \n" +
                        "1: ===  --- \n" +
                        "1: +++  *** \n" +
                        "1: +☺+  *☻* \n" +
                        "1:\n" +
                        "1:Scores: 0\n" +
                        "1:Answer: \n" +
                        "2:Board:\n" +
                        "2:X ,   X . \n" +
                        "2: ,      . \n" +
                        "2:, X , . X.\n" +
                        "2:          \n" +
                        "2:, ,    .  \n" +
                        "2:          \n" +
                        "2:  ,    .  \n" +
                        "2: ---  === \n" +
                        "2: ***  +++ \n" +
                        "2: *☻*  +☺+ \n" +
                        "2:\n" +
                        "2:Scores: 0\n" +
                        "2:Answer: \n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:X .   X , \n" +
                        "1: .      , \n" +
                        "1:. X . , X,\n" +
                        "1:          \n" +
                        "1:. .    ,  \n" +
                        "1:          \n" +
                        "1:  .    ,  \n" +
                        "1: ===  --- \n" +
                        "1: +++  *** \n" +
                        "1: +☺+  *☻* \n" +
                        "1:\n" +
                        "1:Scores: 0\n" +
                        "1:Answer: \n" +
                        "2:Board:\n" +
                        "2:X ,   X . \n" +
                        "2: ,      . \n" +
                        "2:, X , . X.\n" +
                        "2:          \n" +
                        "2:, ,    .  \n" +
                        "2:          \n" +
                        "2:  ,    .  \n" +
                        "2: ---  === \n" +
                        "2: ***  +++ \n" +
                        "2: *☻*  +☺+ \n" +
                        "2:\n" +
                        "2:Scores: 0\n" +
                        "2:Answer: \n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:X .   X , \n" +
                        "1: .      , \n" +
                        "1:. X . , X,\n" +
                        "1:          \n" +
                        "1:. .    ,  \n" +
                        "1:          \n" +
                        "1:  .    ,  \n" +
                        "1: ===  --- \n" +
                        "1: +++  *** \n" +
                        "1: +☺+  *☻* \n" +
                        "1:\n" +
                        "1:Scores: 0\n" +
                        "1:Answer: \n" +
                        "2:Board:\n" +
                        "2:X ,   X . \n" +
                        "2: ,      . \n" +
                        "2:, X , . X.\n" +
                        "2:          \n" +
                        "2:, ,    .  \n" +
                        "2:          \n" +
                        "2:  ,    .  \n" +
                        "2: ---  === \n" +
                        "2: ***  +++ \n" +
                        "2: *☻*  +☺+ \n" +
                        "2:\n" +
                        "2:Scores: 0\n" +
                        "2:Answer: \n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:X .   X , \n" +
                        "1: .      , \n" +
                        "1:. X . , X,\n" +
                        "1:          \n" +
                        "1:. .    ,  \n" +
                        "1:          \n" +
                        "1:  .    ,  \n" +
                        "1: ===  --- \n" +
                        "1: +++  *** \n" +
                        "1: +☺+  *☻* \n" +
                        "1:\n" +
                        "1:Scores: 0\n" +
                        "1:Answer: \n" +
                        "2:Board:\n" +
                        "2:X ,   X . \n" +
                        "2: ,      . \n" +
                        "2:, X , . X.\n" +
                        "2:          \n" +
                        "2:, ,    .  \n" +
                        "2:          \n" +
                        "2:  ,    .  \n" +
                        "2: ---  === \n" +
                        "2: ***  +++ \n" +
                        "2: *☻*  +☺+ \n" +
                        "2:\n" +
                        "2:Scores: 0\n" +
                        "2:Answer: \n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:X .   X , \n" +
                        "1: .      , \n" +
                        "1:. X . , X,\n" +
                        "1:          \n" +
                        "1:. .    ,  \n" +
                        "1:          \n" +
                        "1:  .    ,  \n" +
                        "1: ===  --- \n" +
                        "1: +++  *** \n" +
                        "1: +☺+  *☻* \n" +
                        "1:\n" +
                        "1:Scores: 0\n" +
                        "1:Answer: \n" +
                        "2:Board:\n" +
                        "2:X ,   X . \n" +
                        "2: ,      . \n" +
                        "2:, X , . X.\n" +
                        "2:          \n" +
                        "2:, ,    .  \n" +
                        "2:          \n" +
                        "2:  ,    .  \n" +
                        "2: ---  === \n" +
                        "2: ***  +++ \n" +
                        "2: *☻*  +☺+ \n" +
                        "2:\n" +
                        "2:Scores: 0\n" +
                        "2:Answer: \n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:X .   X , \n" +
                        "1: .      , \n" +
                        "1:. X . , X,\n" +
                        "1:          \n" +
                        "1:. .    ,  \n" +
                        "1:          \n" +
                        "1:  .    ,  \n" +
                        "1: ===  --- \n" +
                        "1: +++  *** \n" +
                        "1: +☺+  *☻* \n" +
                        "1:\n" +
                        "1:Scores: 0\n" +
                        "1:Answer: \n" +
                        "2:Board:\n" +
                        "2:X ,   X . \n" +
                        "2: ,      . \n" +
                        "2:, X , . X.\n" +
                        "2:          \n" +
                        "2:, ,    .  \n" +
                        "2:          \n" +
                        "2:  ,    .  \n" +
                        "2: ---  === \n" +
                        "2: ***  +++ \n" +
                        "2: *☻*  +☺+ \n" +
                        "2:\n" +
                        "2:Scores: 0\n" +
                        "2:Answer: \n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:X .   X , \n" +
                        "1: .      , \n" +
                        "1:. X . , X,\n" +
                        "1:          \n" +
                        "1:. .    ,  \n" +
                        "1:          \n" +
                        "1:  .    ,  \n" +
                        "1: ===  --- \n" +
                        "1: +++  *** \n" +
                        "1: +☺+  *☻* \n" +
                        "1:\n" +
                        "1:Scores: 0\n" +
                        "1:Answer: \n" +
                        "2:Board:\n" +
                        "2:X ,   X . \n" +
                        "2: ,      . \n" +
                        "2:, X , . X.\n" +
                        "2:          \n" +
                        "2:, ,    .  \n" +
                        "2:          \n" +
                        "2:  ,    .  \n" +
                        "2: ---  === \n" +
                        "2: ***  +++ \n" +
                        "2: *☻*  +☺+ \n" +
                        "2:\n" +
                        "2:Scores: 0\n" +
                        "2:Answer: \n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:X .   X , \n" +
                        "1: .      , \n" +
                        "1:. X . , X,\n" +
                        "1:          \n" +
                        "1:. .    ,  \n" +
                        "1:          \n" +
                        "1:  .    ,  \n" +
                        "1: ===  --- \n" +
                        "1: +++  *** \n" +
                        "1: +☺+  *☻* \n" +
                        "1:\n" +
                        "1:Scores: 0\n" +
                        "1:Answer: \n" +
                        "2:Board:\n" +
                        "2:X ,   X . \n" +
                        "2: ,      . \n" +
                        "2:, X , . X.\n" +
                        "2:          \n" +
                        "2:, ,    .  \n" +
                        "2:          \n" +
                        "2:  ,    .  \n" +
                        "2: ---  === \n" +
                        "2: ***  +++ \n" +
                        "2: *☻*  +☺+ \n" +
                        "2:\n" +
                        "2:Scores: 0\n" +
                        "2:Answer: \n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:X .   X , \n" +
                        "1: .      , \n" +
                        "1:. X . , X,\n" +
                        "1:          \n" +
                        "1:. .    ,  \n" +
                        "1:          \n" +
                        "1:  .    ,  \n" +
                        "1: ===  --- \n" +
                        "1: +++  *** \n" +
                        "1: +☺+  *☻* \n" +
                        "1:\n" +
                        "1:Scores: 0\n" +
                        "1:Answer: \n" +
                        "2:Board:\n" +
                        "2:X ,   X . \n" +
                        "2: ,      . \n" +
                        "2:, X , . X.\n" +
                        "2:          \n" +
                        "2:, ,    .  \n" +
                        "2:          \n" +
                        "2:  ,    .  \n" +
                        "2: ---  === \n" +
                        "2: ***  +++ \n" +
                        "2: *☻*  +☺+ \n" +
                        "2:\n" +
                        "2:Scores: 0\n" +
                        "2:Answer: \n" +
                        "------------------------------------------",
                String.join("\n", messages));

    }
}
