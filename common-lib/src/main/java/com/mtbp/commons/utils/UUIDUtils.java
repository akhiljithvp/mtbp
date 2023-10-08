package com.mtbp.commons.utils;

import java.util.UUID;

public final class UUIDUtils {

    private UUIDUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Cannot instantiate a utils class!");
    }

    public static String UUID() {
        return UUID.randomUUID().toString();
    }

    public static String createUUID() {
        return UUID().replace("-", "");
    }
}