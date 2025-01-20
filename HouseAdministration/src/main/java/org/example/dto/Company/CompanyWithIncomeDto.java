package org.example.dto.Company;

import java.time.LocalDate;

public class CompanyWithIncomeDto {
    private final String name;
    private final LocalDate foundationDate;
    private final double income;

    public CompanyWithIncomeDto(String name, LocalDate foundationDate, double income) {
        this.name = name;
        this.foundationDate = foundationDate;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public double getIncome() {
        return income;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Company Name: ").append(name).append("\n");
        sb.append("Foundation Date: ").append(foundationDate).append("\n");
        sb.append("Total Income: ").append(income).append("\n");

        return sb.toString();
    }
}
