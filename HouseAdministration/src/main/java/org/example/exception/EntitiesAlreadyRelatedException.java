package org.example.exception;

public class EntitiesAlreadyRelatedException extends Exception {
    private long entityId1;
    private long entityId2;

    public EntitiesAlreadyRelatedException(long entityId1, long entityId2) {
        super("Entities " + entityId1 + " and " + entityId2 + " are already related.");
        this.entityId1 = entityId1;
        this.entityId2 = entityId2;
    }

    @Override
    public String toString() {
        return "AlreadyRelatedEntitiesException{" +
                "entityId1=" + entityId1 +
                ", entityId2=" + entityId2 +
                '}';
    }
}
