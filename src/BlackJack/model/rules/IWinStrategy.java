package BlackJack.model.rules;

import BlackJack.model.Player;

/**
 * Created by ChristofferTronje on 2016-10-27.
 */
public interface IWinStrategy {

    boolean IsDealerWinner(Player a_dealer, Player a_player);

}
