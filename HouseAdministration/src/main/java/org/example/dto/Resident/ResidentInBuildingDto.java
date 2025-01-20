package org.example.dto.Resident;

public class ResidentInBuildingDto {
    private final String firstName;
    private final String lastName;
    private final int age;

    public ResidentInBuildingDto(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    @Override
    public String toString() {
        return "   First Name = '" + firstName + '\n' +
                "   Last Name = '" + lastName + '\n' +
                "   Age = " + age + '\n';
    }
}
