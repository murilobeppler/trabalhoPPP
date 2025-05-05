package freeze_monster.sprite;

import freeze_monster.Commons;
import spriteframework.sprite.BadSprite;

import javax.swing.ImageIcon;

public class Slime extends BadSprite {
    private int directionX;
    private int directionY;
    private boolean destroyed;

    public Slime(int x, int y, int directionX, int directionY) {
        initSlime(x, y, directionX, directionY);
    }

    private void initSlime(int x, int y, int dx, int dy) {
        var slimeImg = new ImageIcon("trabalho PPP/src/freezemonster/resources/images/slime.png");
        setImage(slimeImg.getImage());
        setX(x);
        setY(y);
        this.directionX = dx;
        this.directionY = dy;
        this.destroyed = false;
    }

    @Override
    public void act() {
        if (!isDestroyed()) {
            moveX(directionX);
            moveY(directionY);
        }
    }

    public void setDirection(int dx, int dy) {
        this.directionX = dx;
        this.directionY = dy;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}
