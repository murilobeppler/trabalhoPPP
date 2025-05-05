package freeze_monster.sprite;

import freeze_monster.Commons;
import spriteframework.sprite.BadSprite;

import javax.swing.ImageIcon;
import java.util.LinkedList;
import java.util.Random;

public class Monster extends BadSprite {
    private Random rand = new Random();
    private int directionX;
    private int directionY;
    private boolean isFrozen = false;
    private Slime slime;

    public Monster(int x, int y) {
        initMonster(x, y);
    }

    private void initMonster(int x, int y) {
        var monsterImg = new ImageIcon("trabalho PPP/src/freezemonster/resources/images/monster.png");
        setImage(monsterImg.getImage());
        setX(x);
        setY(y);
        directionX = rand.nextBoolean() ? 1 : -1;
        directionY = rand.nextBoolean() ? 1 : -1;
        slime = new Slime(x, y, 0, 0);
        slime.setDestroyed(true);
    }

    @Override
    public void act() {
        if (!isFrozen) {
            moveX(directionX);
            moveY(directionY);

            // Change direction randomly
            if (rand.nextInt(100) < 5) {
                directionX *= -1;
            }
            if (rand.nextInt(100) < 5) {
                directionY *= -1;
            }
            
            // Check boundaries
            if (x <= Commons.BORDER_LEFT) {
                directionX = 1;
            }
            if (x >= Commons.BOARD_WIDTH - Commons.MONSTER_WIDTH - Commons.BORDER_RIGHT) {
                directionX = -1;
            }
            if (y <= Commons.BORDER_LEFT) {
                directionY = 1;
            }
            if (y >= Commons.BOARD_HEIGHT - Commons.MONSTER_HEIGHT - Commons.BORDER_RIGHT) {
                directionY = -1;
            }
        }
    }

    public void freeze() {
        isFrozen = true;
        var frozenImg = new ImageIcon("trabalho PPP/src/freezemonster/resources/images/monster_frozen.png");
        setImage(frozenImg.getImage());
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    @Override
    public LinkedList<BadSprite> getBadnesses() {
        LinkedList<BadSprite> badnesses = new LinkedList<>();
        badnesses.add(slime);
        return badnesses;
    }

    public Slime getSlime() {
        return slime;
    }

    public Slime fireSlime() {
        if (!isFrozen && slime.isDestroyed()) {
            slime.setDestroyed(false);
            slime.setX(x + Commons.MONSTER_WIDTH / 2);
            slime.setY(y + Commons.MONSTER_HEIGHT);
            int slimeDirectionX = rand.nextBoolean() ? 1 : -1;
            int slimeDirectionY = rand.nextBoolean() ? 1 : -1;
            slime.setDirection(slimeDirectionX, slimeDirectionY);
            return slime;
        }
        return null;
    }
}
