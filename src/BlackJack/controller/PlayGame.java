package BlackJack.controller;

import BlackJack.model.ICardDealedObserver;
import BlackJack.view.IView;
import BlackJack.model.Game;


public class PlayGame implements ICardDealedObserver {

    IView view;
    Game game;

    public PlayGame(Game a_game, IView a_view) {
        game = a_game;
        view = a_view;
    }

    public boolean Play() {
        game.Addsubscribers(this);

        IView.action input;
        view.DisplayWelcomeMessage();
        view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
        view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());

        while (true) {
            if (game.IsGameOver()) {
                view.DisplayGameOver(game.IsDealerWinner());
            }

            input = view.action();

            if (input == IView.action.PLAY) {
                game.NewGame();
            } else if (input == IView.action.HIT) {
                game.Hit();
            } else if (input == IView.action.STAND) {
                game.Stand();
            } else if (input == IView.action.QUIT)
                break;
        }
        return false;
    }


    public void CardDealt() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        view.DisplayWelcomeMessage();
        view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
        view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());
    }
}