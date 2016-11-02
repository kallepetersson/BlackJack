package BlackJack.model.rules;

import BlackJack.model.Player;

public class PlayerWinsEqualStrategy implements IWinStrategy{

    private final int g_maxScore = 21;

    @Override
    public boolean IsDealerWinner(Player a_dealer, Player a_player) {

        if (a_player.CalcScore() > g_maxScore) {
            return true;
        } else if (a_dealer.CalcScore() > g_maxScore) {
            return false;
        }
        return a_dealer.CalcScore() > a_player.CalcScore();
    }
}
