package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface IWinGameStrategy {
    boolean isDealerWinner(Player a_player, Dealer a_dealer);
}
