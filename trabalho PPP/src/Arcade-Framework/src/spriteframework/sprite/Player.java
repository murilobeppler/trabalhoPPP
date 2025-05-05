package spriteframework.sprite;

import javax.swing.ImageIcon;
import spriteframework.Commons;

import java.awt.event.KeyEvent;
import java.net.URL;

public class Player extends Sprite {

    private int width;
    private int dy;
    private int lastDx = 1; // Direção padrão para o raio (direita)

    public Player() {
        loadImage();
		getImageDimensions();
		resetState();
    }

    protected void loadImage () {
        URL imageUrl = getClass().getResource("/images/player.png");

        if (imageUrl == null) {
            throw new IllegalStateException("Imagem do jogador não encontrada: /images/player.png");
        }

        ImageIcon ii = new ImageIcon(imageUrl);
        width = ii.getImage().getWidth(null);
        setImage(ii.getImage());
    }

    public void act() {

        x += dx;
        y += dy;

        if (x <= 2) {

            x = 2;
        }

        if (x >= Commons.BOARD_WIDTH - 2 * width) {

            x = Commons.BOARD_WIDTH - 2 * width;
        }
        if (y <= 2) {
            y = 2;
        }
        if (y >= Commons.BOARD_HEIGHT - 2 * getImage().getHeight(null)) {
            y = Commons.BOARD_HEIGHT - 2 * getImage().getHeight(null);
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = -2;
            lastDx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 2;
            lastDx = 1;
        }
        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
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
    private void resetState() {

        setX(Commons.INIT_PLAYER_X);
        setY(Commons.INIT_PLAYER_Y);
    }

}


