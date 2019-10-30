package BlackJack;

import BlackJack.model.Game;
import BlackJack.model.GameEventPublisher;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program
{

  public static void main(String[] a_args)
  {
    GameEventPublisher eventPublisher = new GameEventPublisher();

    Game g = new Game(eventPublisher);
    IView v = new SimpleView(); //new SwedishView();
    PlayGame ctrl = new PlayGame(g, v);
    eventPublisher.Add(ctrl);
    
    while (ctrl.Play());
  }
}