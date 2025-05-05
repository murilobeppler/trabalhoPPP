package freeze_monster.sprite;

import freeze_monster.Commons;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player extends spriteframework.sprite.Player {

    private int width;
    private int height;
    private int dx;
    private int dy;
    private String lastDirection;

    public Player() {
        initPlayer();
    }

    private void initPlayer() {
        ImageIcon ii = new ImageIcon("/images/woody.png");
        width = ii.getImage().getWidth(null);
        height = ii.getImage().getHeight(null);

        setImage(ii.getImage());

        // Initial position
        setX(Commons.BOARD_WIDTH / 2);
        setY(Commons.BOARD_HEIGHT - 100);

        // Initial direction (for the freeze ray)
        lastDirection = "UP";
    }

    @Override
    public void act() {
        x += dx;
        y += dy;

        // Screen boundaries
        if (x < Commons.BORDER_LEFT) {
            x = Commons.BORDER_LEFT;
        }

        if (y < Commons.BORDER_LEFT) {
            y = Commons.BORDER_LEFT;
        }

        if (x > Commons.BOARD_WIDTH - width - Commons.BORDER_RIGHT) {
            x = Commons.BOARD_WIDTH - width - Commons.BORDER_RIGHT;
        }

        if (y > Commons.BOARD_HEIGHT - height - Commons.BORDER_RIGHT) {
            y = Commons.BOARD_HEIGHT - height - Commons.BORDER_RIGHT;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
            lastDirection = "LEFT";
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
            lastDirection = "RIGHT";
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
            lastDirection = "UP";
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
            lastDirection = "DOWN";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public FreezeRay fire() {
        int rayX = x + width / 2;
        int rayY = y + height / 2;
        int direction = 0;
        int speed = Commons.FREEZERAY_SPEED;
        
        switch (lastDirection) {
            case "UP":
                return new FreezeRay(rayX, rayY, 0, -speed);
            case "DOWN":
                return new FreezeRay(rayX, rayY, 0, speed);
            case "LEFT":
                return new FreezeRay(rayX, rayY, -speed, 0);
            case "RIGHT":
                return new FreezeRay(rayX, rayY, speed, 0);
            default:
                return new FreezeRay(rayX, rayY, 0, -speed);
        }
    }
}
