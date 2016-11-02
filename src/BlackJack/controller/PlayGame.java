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
        game.Addsubscribers(this);

    }

    public boolean Play() {

        IView.action input;
        view.DisplayWelcomeMessage();
        view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
        view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());

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
            return false;
        return true;
    }

    /**
     * Delay every time a card is dealt
     */
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