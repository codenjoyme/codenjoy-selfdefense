package com.codenjoy.dojo.selfdefense.services;

import com.codenjoy.dojo.selfdefense.model.Level;
import com.codenjoy.dojo.selfdefense.model.LevelImpl;
import com.codenjoy.dojo.services.settings.SettingsImpl;
import com.codenjoy.dojo.services.settings.SettingsReader;

import static com.codenjoy.dojo.selfdefense.services.GameSettings.Keys.*;

public class GameSettings extends SettingsImpl implements SettingsReader<GameSettings> {

    public enum Keys implements Key {

        WIN_SCORE("Win score"),
        LOOSE_PENALTY("Loose penalty"),
        LEVEL_MAP("Level map");

        private String key;

        Keys(String key) {
            this.key = key;
        }

        @Override
        public String key() {
            return key;
        }
    }

    public GameSettings() {
        integer(WIN_SCORE, 30);
        integer(LOOSE_PENALTY, 100);

        multiline(LEVEL_MAP,
                "            " +
                "  X .   X , " +
                "  .      ,  " +
                " . X . , X, " +
                "            " +
                " . .    ,   " +
                "            " +
                "   .    ,   " +
                "            " +
                " =+++=-***- " +
                "  +☺+  *☻*  " +
                "            ");
    }

    public Level level() {
        return new LevelImpl(string(LEVEL_MAP));
    }
}
