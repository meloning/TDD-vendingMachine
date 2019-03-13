/*
[TODO]:
    - 최소 개수의 동전으로 잔돈을 돌려준다.
        Ex> 1000원 넣고 650원짜리 음료를 선택했다면, 잔돈은 100,100,100,100,50원으로 반환
    - 지폐를 잔돈으로 반환하는 경우는 없다고 가정.
[TODO]:
    [업무 시나리오]
    - 돈을 넣는다.(사람)
      -> 투입한 금액에 표시된다.(하드웨어+소프트웨어)
      -> 투입한 금액 내에서 선택 가능한 음료가 있다면 해당 버튼에 불이 들어온다.(하드웨어)
      -> 음료를 선택한다.(사람)
      -> 음료가 나온다.(하드웨어)
      -> 투입금액 표시화면에는 선택한 음료 가격만큼 제외된 가격만 표시된다.(하드웨어+소프트웨어)
      -> 만일 표시된 남은 금액이 다른 음료를 선택할 수 있는 금액 이하라면, 바로 잔돈으로 반환한다.(소프트웨어)
      -> 다른 음료를 선택할 수 있는 금액이 남아 있다면 최초 동전을 넣었을 때와 동일하게 동작한다.(소프트웨어)
      -> 반환 버튼을 눌렀을 경우 상황에 관계없이 표시되어 있는 금액을 최소 잔동으로 반환한다.(사람)

[TODO]:
    - 음료수 가격 확인
    - 잔액 확인
    - 잔돈 반환
*/

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    @Test // 잔액확인
    public void testGetChangeAmount() throws Exception{
        VendingMachine machine = new VendingMachine();
        machine.putCoin(100);
        assertEquals("투입금액 100원",100,machine.getChangeAmount());

        machine.putCoin(500);
        assertEquals("추가 투입금액 500원",600,machine.getChangeAmount());
    }

    @Test // 거스름돈 50원
    public void testReturnChangeCoinSet_oneCoin_50() throws Exception{
        VendingMachine machine = new VendingMachine();
        machine.putCoin(100);
        machine.putCoin(100);
        machine.putCoin(500);
        machine.selectDrink(new Drink("Cola",650));

        CoinSet expectedCoinSet = new CoinSet(); // 코인 컨테이너 클래스
        expectedCoinSet.add(50);
        assertEquals("700원 투입후 650원 음료 선택",expectedCoinSet,machine.getChangeCoinSet());
    }

    @Test
    public void testReturnChangeCoinSet_coins_180() throws Exception{
        VendingMachine machine = new VendingMachine();
        machine.putCoin(100);
        machine.putCoin(100);
        machine.putCoin(500);
        machine.selectDrink(new Drink("Soda",520));

        CoinSet expectedCoinSet = new CoinSet();
        expectedCoinSet.add(100);
        expectedCoinSet.add(50);
        expectedCoinSet.add(10);
        expectedCoinSet.add(10);
        expectedCoinSet.add(10);
        assertEquals("700원 투입 후 520원 음료선택",expectedCoinSet,machine.getChangeCoinSet());
    }
}
