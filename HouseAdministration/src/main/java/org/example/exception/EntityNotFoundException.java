package org.example.exception;

public class EntityNotFoundException extends Exception {
    private long entityId;

    public EntityNotFoundException(long entityId) {
        super("Entity " + entityId + " is not found.");
        this.entityId = entityId;
    }

    @Override
    public String toString() {
        return "EntityNotFoundException{" +
                "entityId=" + entityId +
                '}';
    }
}
