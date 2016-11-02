package BlackJack.model.rules;

public class RulesFactory {

    public IHitStrategy GetHitRule() {
        return new Soft17HitStrategy();
    }

    public INewGameStrategy GetNewGameRule() {
        return new InternationalNewGameStrategy();
    }

    public IWinStrategy GetWinEqualRule() {
        return new DealerWinsEqualStrategy();
    }

}