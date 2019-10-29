package BlackJack.model;

import BlackJack.controller.GameEventPublisher;
import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinGameStrategy m_winRule;
  private GameEventPublisher m_eventPublisher;

  public Dealer(RulesFactory a_rulesFactory, GameEventPublisher eventPublisher) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_winRule = a_rulesFactory.GetWinnerRule();
    m_eventPublisher = eventPublisher;
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame( this, a_player);
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < GetMaxScore() && !IsGameOver()) {
      Card c;
      HandInCard(a_player, true);

      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {
    return m_winRule.isDealerWinner(a_player, this);
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }

  public boolean Stand(){
    if(m_deck != null){
      ShowHand();
      while (m_hitRule.DoHit(this)){
        HandInCard(this, true);
      }
    }
    return true;
  }

  public void HandInCard(Player a_player, boolean isCardShown){
    Card c = m_deck.GetCard();
    c.Show(isCardShown);
    a_player.DealCard(c);
    triggerHandInCardEvent();
  }

  public void triggerHandInCardEvent(){
    m_eventPublisher.Notify();
  }
}