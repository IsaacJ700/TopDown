package topdown;

/**
 * Creates the different states available to be used to say what state
 * the game currently is in.
 *
 * @author Issac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public enum State {

    /**
     * The gme is in the menu state.
     */
    Menu(),

    /**
     * The game is in the game state.
     */
    Game(),

    /**
     * The game is in the options menu state.
     */
    OptionsMenu(),

    /**
     * The game is currently paused state.
     */
    PauseMenu(),

    /**
     * The game is showing a menu state.
     */
    ControlsMenu(),

    /**
     * The game is showing credits state.
     */
    Credits(),

    /**
     * The game has been lost state.
     */
    GameOver(),

    /**
     * The game has been won state.
     */
    GameWon()
}
