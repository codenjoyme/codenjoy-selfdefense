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


import com.codenjoy.dojo.selfdefense.services.GameSettings;
import com.codenjoy.dojo.services.EventListener;
import com.codenjoy.dojo.services.Game;
import com.codenjoy.dojo.services.dice.MockDice;
import com.codenjoy.dojo.services.multiplayer.Single;
import com.codenjoy.dojo.services.printer.PrinterFactory;
import com.codenjoy.dojo.services.printer.PrinterFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import static com.codenjoy.dojo.selfdefense.services.GameSettings.Keys.LEVEL_MAP;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class MultiplayerTest {

    private EventListener listener1;
    private EventListener listener2;
    private EventListener listener3;
    private Game game1;
    private Game game2;
    private Game game3;
    private MockDice dice;
    private Selfdefense field;
    private GameSettings settings;

    // появляется другие игроки, игра становится мультипользовательской
    @Before
    public void setup() {
        settings = new GameSettings()
            .string(LEVEL_MAP,
                "           " +
                "           " +
                "           " +
                "           " +
                "           " +
                "           " +
                "           " +
                "           " +
                "           " +
                "=+= -*- -*-" +
                "+☺+ *☻* *☻*");

        dice = new MockDice();
        field = new Selfdefense(settings.level(), dice, settings);
        PrinterFactory factory = new PrinterFactoryImpl();

        listener1 = mock(EventListener.class);
        game1 = new Single(new Player(listener1, settings), factory);
        game1.on(field);

        listener2 = mock(EventListener.class);
        game2 = new Single(new Player(listener2, settings), factory);
        game2.on(field);

        listener3 = mock(EventListener.class);
        game3 = new Single(new Player(listener3, settings), factory);
        game3.on(field);

        dice(1, 4);
        game1.newGame();

        dice(2, 2);
        game2.newGame();

        dice(3, 4);
        game3.newGame();
    }

    private void dice(Integer... next) {
        dice.then(next);
    }

    private void asrtFl1(String expected) {
        assertEquals(expected, game1.getBoardAsString());
    }

    private void asrtFl2(String expected) {
        assertEquals(expected, game2.getBoardAsString());
    }

    private void asrtFl3(String expected) {
        assertEquals(expected, game3.getBoardAsString());
    }

    @Test
    public void shouldPrintAllBoards() {
        asrtFl1("           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "=+= -*- -*-\n" +
                "+☺+ *☻* *☻*\n");

        asrtFl2("           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "-*- =+= -*-\n" +
                "*☻* +☺+ *☻*\n");

        asrtFl3("           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "-*- -*- =+=\n" +
                "*☻* *☻* +☺+\n");
    }

    @Test
    public void shouldRemove() {
        game3.close();

        field.tick();

        asrtFl1("           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "=+= -*-    \n" +
                "+☺+ *☻*    \n");

        asrtFl2("           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "           \n" +
                "-*- =+=    \n" +
                "*☻* +☺+    \n");
    }

    // ушел юзер, и снова вернулся что будет?
}
