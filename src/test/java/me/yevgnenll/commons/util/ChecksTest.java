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

    @Test
    @DisplayName(value = "is true expression")
    void isTrueTest() {
        String value = "value";

        assertThatCode(() -> Checks.isTrue(!value.isEmpty(), "value must not be null"))
            .doesNotThrowAnyException();

        assertThatThrownBy(() -> Checks.isTrue(false, "test"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("test");

        assertThatThrownBy(() -> Checks.isTrue(false, () -> "test"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("test");
    }

}