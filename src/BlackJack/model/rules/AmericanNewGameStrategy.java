package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {

    DealShowCardAmerican(a_deck,a_player,true);
    DealShowCardAmerican(a_deck,a_dealer,true);
    DealShowCardAmerican(a_deck,a_player,true);
    DealShowCardAmerican(a_deck,a_dealer,false);

    return true;
  }

  public void DealShowCardAmerican(Deck a_deck, Player a_player, Boolean show) {
  Card c = a_deck.GetCard();
  c.Show(show);
  a_player.DealCard(c);
}

}