package me.yevgnenll.commons.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    @DisplayName(value = "email 포맷이면 true 아니면 false")
    void isEmailFormat() {
        String email = "test@gmail.com";
        String partner = "test@partner.gmail.com";
        String dotdot = "test.test@gmail.com";
        String notEmail = "name";

        assertThat(StringUtil.isEmailFormat(email)).isTrue();
        assertThat(StringUtil.isEmailFormat(partner)).isTrue();
        assertThat(StringUtil.isEmailFormat(dotdot)).isTrue();
        assertThat(StringUtil.isEmailFormat(notEmail)).isFalse();
    }

    @Test
    @DisplayName(value = "email 에 null 이 들어가면 exception 을 일으킨다")
    void paramMustNotBeNull() {
        assertThatThrownBy(() -> StringUtil.isEmailFormat(null))
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("must not be null");
    }

}