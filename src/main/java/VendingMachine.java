public class VendingMachine {
    private int changeAmount;

    public void putCoin(int coin) {
        this.changeAmount+=coin;
    }

    public int getChangeAmount() {
        return this.changeAmount;
    }

    public void selectDrink(Drink drink) {
        this.changeAmount-=drink.getPrice();
    }

    public CoinSet getChangeCoinSet() {
        ChangeModule changeModule = new ChangeModule();
        return changeModule.getChangeCoinSet(this.changeAmount);
    }
}
