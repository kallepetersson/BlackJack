package BlackJack;

import BlackJack.model.Game;
import BlackJack.controller.*;
import BlackJack.view.IView;
import BlackJack.view.SimpleView;

public class Program {

    public static void main(String[] a_args) {

        Game g = new Game();
        IView v = new SimpleView();
        PlayGame ctrl = new PlayGame(g, v);

        while (ctrl.Play()) ;
    }
}