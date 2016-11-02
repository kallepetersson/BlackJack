package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;

public class Soft17HitStrategy implements IHitStrategy{

    private final int g_hitLimit = 17;

    /**
     * Returns true if the score is less than @g_hitLimit
     * Returns true if the ace is worth 11, returns false if it's worth 1.
     *
     * @param a_dealer
     * @return
     */
    public boolean DoHit(Player a_dealer) {

        if(a_dealer.CalcScore()<g_hitLimit)
            return true;

        else if (a_dealer.CalcScore()==17){
            Iterable<Card> itr = a_dealer.GetHand();
            Player tempHand = new Player();
            for(Card c : itr) {
                if((c.GetValue() != Card.Value.Ace)) {
                    tempHand.DealCard(c);
                    break;
                }
            }

            if(a_dealer.CalcScore()-tempHand.CalcScore() == 11){
                return true;
            }
        }
        return false;
    }
}
