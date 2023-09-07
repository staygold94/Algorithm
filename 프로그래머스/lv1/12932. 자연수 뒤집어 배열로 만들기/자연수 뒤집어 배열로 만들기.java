import java.util.stream.IntStream;

class Solution {
    public int[] solution(long n) {
        
        // 인상 깊었던 풀이
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
}

/*
제시된 Java 함수는 주어진 `long` 값을 역순으로 배열로 변환하는 것을 목표로 하는 것으로 보입니다. 여기에서 `chars()` 메서드로 문자열로 변환한 후, `map(Character::getNumericValue)` 메서드를 사용한 후 `toArray()`로 배열로 변환하는 이유는 다음과 같습니다:

1. `chars()`: `chars()` 메서드를 사용하여 `long` 값을 문자열로 변환합니다. `StringBuilder`를 사용하여 숫자를 문자열로 변환하고, `chars()` 메서드를 호출하면 문자열의 각 문자가 순차적으로 처리 가능한 `IntStream`으로 반환됩니다.

2. `map(Character::getNumericValue)`: `map` 메서드는 각 문자를 숫자 값으로 변환하기 위해 `Character::getNumericValue` 함수를 적용합니다. 이 함수는 각 문자를 해당 숫자 값으로 변환합니다.

3. `toArray()`: `toArray()` 메서드는 `IntStream`의 결과를 배열로 변환합니다. 따라서 역순으로 변환된 숫자 값을 배열로 반환합니다.

전체 과정을 통해 `long` 값을 역순으로 된 숫자 배열로 변환하는 것입니다. 이 함수는 주어진 `long` 값을 역순으로 배열로 변환하기 위한 것으로 보입니다.
*/