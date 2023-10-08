package com.mtbp.db.exceptions;

public class DocumentNotFoundException extends RuntimeException {
    public DocumentNotFoundException(String id) {
        super(String.format("Document with the id %s not found!", id));
    }
}
