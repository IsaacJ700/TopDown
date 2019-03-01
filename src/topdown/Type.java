package topdown;

/**
 * Creates the different types of objects available to be made in the
 * game.
 * 
 * @author Issac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public enum Type {

    /**
     * The player type for the current player.
     */
    player(),

    /**
     * The bullet type for the shots being fired.
     */
    bullet(),

    /**
     * The shop type for the ability for players to shop.
     */
    shop(),

    /**
     * The wall type to create in-game barriers.
     */
    wall(),

    /**
     * The crate type to create barriers that can be broken.
     */
    crate(),

    /**
     * The small enemy type with lower health and smaller size.
     */
    smallEnemy(),

    /**
     * The medium enemy type with a little more health and increased
     * size.
     */
    mediumEnemy(),

    /**
     * The large enemy type with more health and increased size.
     */
    largeEnemy(),

    /**
     * The boss enemy type with much more health and much larger size.
     */
    bossEnemy(),

    /**
     * The zombie enemy type with random size and random amounts of
     * health.
     */
    zombieEnemy(),

    /**
     * The shooting enemy types that is nearly identical to the player.
     */
    shootingEnemy(),

    /**
     * The random enemy type that is used to randomly select an enemy
     * type.
     */
    randomEnemy()
}
