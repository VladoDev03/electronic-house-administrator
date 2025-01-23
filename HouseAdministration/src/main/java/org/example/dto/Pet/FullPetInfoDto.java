package org.example.dto.Pet;

public class FullPetInfoDto {
    private final long id;
    private final boolean usesCommonArea;

    public FullPetInfoDto(long id, boolean usesCommonArea) {
        this.id = id;
        this.usesCommonArea = usesCommonArea;
    }

    public long getId() {
        return id;
    }

    public boolean getUsesCommonArea() {
        return usesCommonArea;
    }
}
