package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame {

  public boolean Play(Game a_game, IView a_view) {
    a_view.DisplayWelcomeMessage();
    
    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    if (a_game.IsGameOver())
    {
        a_view.DisplayGameOver(a_game.IsDealerWinner());
    }

    SelectedActionView input = a_view.GetSelectedActionView();
    
    if (input == SelectedActionView.Newgame)
    {
        a_game.NewGame();
    }
    else if (input == SelectedActionView.Hit)
    {
        a_game.Hit();
    }
    else if (input == SelectedActionView.Stand)
    {
        a_game.Stand();
    }
    else if (input == SelectedActionView.Default)
    {
      a_game.NewGame();
    }

    return input != SelectedActionView.Quit;
  }
}