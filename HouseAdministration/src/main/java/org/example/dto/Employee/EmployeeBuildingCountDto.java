package org.example.dto.Employee;

public class EmployeeBuildingCountDto {
    private final String firstName;
    private final String lastName;
    private final int buildingCount;

    public EmployeeBuildingCountDto(String firstName, String lastName, int buildingCount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.buildingCount = buildingCount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBuildingCount() {
        return buildingCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("    Full Name: ").append(this.getFirstName()).append(" ").append(this.getLastName()).append("\n");
        sb.append("    Buildings: ").append(this.getBuildingCount());

        return sb.toString();
    }
}
