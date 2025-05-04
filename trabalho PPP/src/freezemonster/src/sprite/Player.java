package freeze_monster.sprite;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import spriteframework.sprite.Sprite;

public class Player extends Sprite {

    private int width;
    private int height;
    private int dx;
    private int dy;
    private String lastDirection;

    public Player() {
        initPlayer();
    }

    private void initPlayer() {
        ImageIcon ii = new ImageIcon(getClass().getResource("/images/woody.png"));
        width = ii.getImage().getWidth(null);
        height = ii.getImage().getHeight(null);

        setImage(ii.getImage());

        // Posição inicial do Woody
        setX(400);
        setY(300);

        // Direção inicial (para o raio congelante)
        lastDirection = "UP";
    }

    public void move() {
        x += dx;
        y += dy;

        // Limites da tela
        if (x < 0) {
            x = 0;
        }

        if (y < 0) {
            y = 0;
        }

        if (x > 800 - width) {
            x = 800 - width;
        }

        if (y > 600 - height) {
            y = 600 - height;
        }
    }

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

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public String getLastDirection() {
        return lastDirection;
    }

    private void fire() {
        // Será implementado no Board
    }
}
