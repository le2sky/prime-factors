import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class PrimeFactorsTest {

    @Test
    void prime_factors() {
        assertFactors(1, Arrays.asList());
        assertFactors(2, Arrays.asList(2));
        assertFactors(3, Arrays.asList(3));
        assertFactors(4, Arrays.asList(2, 2));
        assertFactors(5, Arrays.asList(5));
        assertFactors(6, Arrays.asList(2, 3));
        assertFactors(7, Arrays.asList(7));
        assertFactors(8, Arrays.asList(2, 2, 2));
        assertFactors(9, Arrays.asList(3, 3));
        assertFactors(2 * 2 * 3 * 3 * 3 * 7 * 7 * 11 * 11 * 13, Arrays.asList(2, 2, 3, 3, 3, 7, 7, 11, 11, 13));
    }

    private void assertFactors(int n, List<Integer> list) {
        assertThat(factors(n)).isEqualTo(list);
    }

    private List<Integer> factors(int n) {
        List<Integer> factors = new ArrayList<>();

        for (int divisor = 2; n > 1; divisor++) {
            for (; n % divisor == 0; n /= divisor) {
                factors.add(divisor);
            }
        }

        return factors;
    }
}
