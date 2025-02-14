package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new SoftHitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }

  public IWinGameStrategy GetWinnerRule(){
    return new OldWinnerStrategy();
  }
}