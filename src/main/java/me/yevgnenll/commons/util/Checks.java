package me.yevgnenll.commons.util;

import lombok.NonNull;

public final class Checks {

    private Checks() {}

    public static <T extends @NonNull Object> T notNull(T object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
        return object;
    }

}
