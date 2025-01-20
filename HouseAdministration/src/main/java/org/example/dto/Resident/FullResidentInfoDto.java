package org.example.dto.Resident;

public class FullResidentInfoDto {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final boolean usesElevator;

    public FullResidentInfoDto(String firstName, String lastName, int age, boolean usesElevator) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.usesElevator = usesElevator;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean getUsesElevator() {
        return usesElevator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\t\tFull Name: ").append(firstName).append(" ").append(lastName).append("\n");
        sb.append("\t\tAge: ").append(age).append("\n");
        sb.append("\t\tUses Elevator: ").append(usesElevator).append("\n");

        return sb.toString();
    }
}
