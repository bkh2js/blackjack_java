package BlackJack.model.rules;

import BlackJack.model.Player;

public class SoftHitStrategy implements IHitStrategy {

    private final int g_hitLimit = 17;

    @Override
    public boolean DoHit(Player a_dealer) {
        if (a_dealer.CalcScore() == 17 && a_dealer.hasAce())
            {
                return true;
            }

        return a_dealer.CalcScore() < g_hitLimit;
    }
}
