package com.mtbp.db;

public final class LogMessages {
    public static String DOC_DELETION_EXCEPTION = "Exception occurred while trying to delete document with id: {}";

    private LogMessages() throws IllegalAccessException {
        throw new IllegalAccessException("Cannot instantiate the class");
    }
}