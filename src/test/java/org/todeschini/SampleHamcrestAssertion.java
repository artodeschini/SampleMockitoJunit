package org.todeschini;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.emptyOrNullString;

public class SampleHamcrestAssertion {

    @Test
    void assertWithHamcrestMatcher() {
        assertThat(2 + 1, is(equalTo(3)));
    }

    @Test
    void assertSampleHamcrestMacherUtils() {
        List<Integer> numeros = Arrays.asList(99, 100, 101, 105);

        assertThat(numeros, hasSize(4));
        assertThat(numeros, hasItems(99, 100));
        assertThat(numeros, everyItem(greaterThan(90)));
        assertThat(numeros, everyItem(lessThan(200)));

        assertThat("", emptyString());
        assertThat(null, emptyOrNullString());
    }

}
