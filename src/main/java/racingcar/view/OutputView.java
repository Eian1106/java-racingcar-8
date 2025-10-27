package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        String result = String.join(", ", winners);
        System.out.println(result);
    }

    public void printRoundResult(Map<String, Integer> result) {
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            String name = entry.getKey();
            int position = entry.getValue();

            String sb = name + " : " + "-".repeat(Math.max(0, position));
            System.out.println(sb);
        }
        System.out.println();
    }
}
