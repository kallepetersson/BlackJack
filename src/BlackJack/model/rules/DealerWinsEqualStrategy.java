package BlackJack.model.rules;

import BlackJack.model.Player;

public class DealerWinsEqualStrategy implements IWinStrategy{

    private final int g_maxScore = 21;

    public boolean IsDealerWinner(Player a_dealer, Player a_player) {


        if (a_player.CalcScore() > g_maxScore) {
            return true;
        } else if (a_dealer.CalcScore() > g_maxScore) {
            return false;
        }
        return a_dealer.CalcScore() >= a_player.CalcScore();
    }
}
