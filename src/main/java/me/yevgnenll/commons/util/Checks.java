package me.yevgnenll.commons.util;

import java.util.function.Supplier;

import lombok.NonNull;

public final class Checks {

    private Checks() {}

    public static <T extends @NonNull Object> T notNull(T object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
        return object;
    }

    public static <T extends @NonNull Object> T notNull(T object, Supplier<String> message) {
        if (object == null) {
            throw new NullPointerException(safeGet(message));
        }
        return object;
    }

    private static String safeGet(Supplier<String> messageSupplier) {
        return messageSupplier != null ? messageSupplier.get() : null;
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isTrue(boolean expression, Supplier<String> message) {
        if (!expression) {
            throw new IllegalArgumentException(safeGet(message));
        }
    }

}
