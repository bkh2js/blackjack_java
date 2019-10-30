package BlackJack.controller;

import BlackJack.model.IGameEventSubscriber;
import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.view.SelectedActionView;

public class PlayGame implements IGameEventSubscriber {

  private Game m_game;
  private IView m_view;

  public PlayGame(Game a_game, IView a_view){
    m_game = a_game;
    m_view = a_view;
  }

  public boolean Play() {
    m_view.DisplayWelcomeMessage();
    displayPlayersHand();

    if (m_game.IsGameOver())
    {
        m_view.DisplayGameOver(m_game.IsDealerWinner());
    }

    SelectedActionView input = m_view.GetSelectedActionView();
    
    if (input == SelectedActionView.Newgame)
    {
        m_game.NewGame();
    }
    else if (input == SelectedActionView.Hit)
    {
        m_game.Hit();
    }
    else if (input == SelectedActionView.Stand)
    {
        m_game.Stand();
    }
    else if (input == SelectedActionView.Default)
    {
      m_game.NewGame();
    }

    return input != SelectedActionView.Quit;
  }

  @Override
  public void OnEvent() {
    m_view.DisplayPauseMessage();
    sleep2Seconds();
    displayPlayersHand();
  }

  private void displayPlayersHand(){
    m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
    m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
  }

  private void sleep2Seconds(){
    try {
      Thread.sleep(4000);
    } catch (Exception e){

    }

  }
}