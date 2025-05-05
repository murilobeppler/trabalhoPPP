package freeze_monster;

import java.awt.EventQueue;

import spriteframework.AbstractBoard;
import spriteframework.MainFrame;

public class FreezeMonster extends MainFrame {

    public FreezeMonster() {
        super("Freeze Monster");
    }

    @Override
    protected AbstractBoard createBoard() {
        return new FreezeMonsterBoard();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new FreezeMonster();
        });
    }
}
