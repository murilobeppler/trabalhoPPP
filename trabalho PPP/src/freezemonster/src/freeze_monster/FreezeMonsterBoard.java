package freeze_monster;

import freeze_monster.sprite.FreezeRay;
import freeze_monster.sprite.Monster;
import freeze_monster.sprite.Slime;
import spriteframework.AbstractBoard;
import spriteframework.sprite.Player;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FreezeMonsterBoard extends AbstractBoard {
    private Player woody;
    private List<Monster> monsters = new ArrayList<>();
    private List<Slime> slimes = new ArrayList<>();
    private List<FreezeRay> freezeRays = new ArrayList<>();

    @Override
    protected void createBadSprites() {
        // Adiciona monstros inimigos
        for (int i = 0; i < 5; i++) {
            monsters.add(new Monster(100 + i * 80, 100));
        }
    }

    @Override
    protected void createOtherSprites() {
        woody = new Player();
    }

    @Override
    protected void drawOtherSprites(Graphics g) {
        for (Monster m : monsters) {
            g.drawImage(m.getImage(), m.getX(), m.getY(), this);
        }

        for (Slime s : slimes) {
            g.drawImage(s.getImage(), s.getX(), s.getY(), this);
        }

        for (FreezeRay ray : freezeRays) {
            g.drawImage(ray.getImage(), ray.getX(), ray.getY(), this);
        }
    }

    @Override
    protected void update() {
        for (Monster m : monsters) {
            m.move();

            if (Math.random() < 0.01) { // chance de lançar slime
                slimes.add(m.fireSlime());
            }
        }

        Iterator<Slime> it = slimes.iterator();
        while (it.hasNext()) {
            Slime s = it.next();
            s.move();

            if (isOutOfBounds(s)) {
                it.remove();
            }
        }

        Iterator<FreezeRay> rayIt = freezeRays.iterator();
        while (rayIt.hasNext()) {
            FreezeRay ray = rayIt.next();
            ray.move();
            if (isOutOfBounds(ray)) {
                rayIt.remove();
            }
        }
    }

    private boolean isOutOfBounds(Slime s) {
        return s.getX() < 0 || s.getX() > getWidth() || s.getY() < 0 || s.getY() > getHeight();
    }

    private boolean isOutOfBounds(FreezeRay r) {
        return r.getX() < 0 || r.getX() > getWidth() || r.getY() < 0 || r.getY() > getHeight();
    }

    @Override
    protected void processOtherSprites(Player player, KeyEvent e) {
        player.keyPressed(e);
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            freezeRays.add(woody.fire());
        }
    }
}
