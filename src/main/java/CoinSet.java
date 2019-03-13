import java.util.ArrayList;
import java.util.List;

public class CoinSet {

    List<Integer> coinSets = new ArrayList<>();

    public void add(int coin) {
        this.coinSets.add(coin);
    }

    @Override // 동치비교를 위해 equals 재정의
    public boolean equals(Object coinSet) {
        if(!(coinSet instanceof CoinSet)){
            return false;
        }
        return this.toString().equals(coinSet.toString());
    }

    @Override // 코인을 일렬로 늘어놓는 문자열을 만들기
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Integer coin:this.coinSets){
            builder.append(coin);
        }
        return builder.toString();
    }
}
