package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class EqualScoresDealerWinnerStrategy implements IWinGameStrategy {

    @Override
    public boolean isDealerWinner(Player a_player, Dealer a_dealer) {
        if (a_player.CalcScore() == a_dealer.GetMaxScore()) {
            return true;
        }
        else if (a_player.CalcScore() > a_dealer.GetMaxScore()) {
            return true;
        } else if (a_dealer.CalcScore() > a_dealer.GetMaxScore()) {
            return false;
        }
        return a_dealer.CalcScore() >= a_player.CalcScore();
    }
}
