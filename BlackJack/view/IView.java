package BlackJack.view;

public interface IView
{
  void DisplayWelcomeMessage();
  SelectedActionView GetSelectedActionView();
  void DisplayCard(BlackJack.model.Card a_card);
  void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);
  void DisplayPauseMessage();
}