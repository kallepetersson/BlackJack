package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {

    DealShowCardInternational(a_deck,a_player);
    DealShowCardInternational(a_deck,a_dealer);
    DealShowCardInternational(a_deck,a_player);

    return true;
  }

  public void DealShowCardInternational(Deck a_deck, Player a_player) {
    Card c = a_deck.GetCard();
    c.Show(true);
    a_player.DealCard(c);

  }

}