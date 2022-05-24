package me.yevgnenll.commons.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChecksTest {

    @Test
    @DisplayName(value = "not null test")
    void notNull() {
        String value = "value";

        assertThat(Checks.notNull(value, "message!!")).isEqualTo("value");

        assertThatThrownBy(() -> Checks.notNull(null, "message"))
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("message");

        assertThatThrownBy(() -> Checks.notNull(null, () -> "message"))
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("message");
    }

}