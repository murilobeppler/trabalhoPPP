package freeze_monster;

public interface Commons {
    int BOARD_WIDTH = 800;
    int BOARD_HEIGHT = 600;
    int GROUND = 580;
    int DELAY = 17;
    int PLAYER_WIDTH = 32;
    int PLAYER_HEIGHT = 32;
    int MONSTER_WIDTH = 32;
    int MONSTER_HEIGHT = 32;
    int MONSTER_INIT_X = 150;
    int MONSTER_INIT_Y = 100;
    int FREEZERAY_SPEED = 4;
    int SLIME_SPEED = 2;
    int BORDER_LEFT = 10;
    int BORDER_RIGHT = 30;
    int CHANCE_OF_SLIME = 10; // Chance out of 1000 for a monster to fire slime
    int NUMBER_OF_MONSTERS = 10;
    int GO_DOWN = 15;
    int NUMBER_OF_MONSTERS_TO_FREEZE = 10; // When game is won
} 