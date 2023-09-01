package ru.legilimens.game.ui.action;

public interface IAction {
    void pressUp();
    void pressDown();
    void slide(float amountX, float amountY);
    void click();
    void input(String text);
}
