package freeze_monster.sprite;

import freeze_monster.Commons;
import spriteframework.sprite.Sprite;

import javax.swing.ImageIcon;

public class FreezeRay extends Sprite {

    private int dx;
    private int dy;

    public FreezeRay(int x, int y, int dx, int dy) {
        initFreezeRay(x, y, dx, dy);
    }

    private void initFreezeRay(int x, int y, int dx, int dy) {
        var rayImg = new ImageIcon("trabalho PPP/src/freezemonster/resources/images/freeze_ray.png").getImage();
        setImage(rayImg);
        setX(x);
        setY(y);
        this.dx = dx;
        this.dy = dy;
    }

    public void move() {
        x += dx;
        y += dy;
    }
    
    public boolean isOutOfBounds() {
        return x < 0 || x > Commons.BOARD_WIDTH || y < 0 || y > Commons.BOARD_HEIGHT;
    }
}