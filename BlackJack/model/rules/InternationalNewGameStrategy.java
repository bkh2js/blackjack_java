package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Dealer a_dealer, Player a_player) {
    a_dealer.HandInCard(a_player,true);
    a_dealer.HandInCard(a_dealer,true);
    a_dealer.HandInCard(a_player,true);
  
    return true;
  }
}