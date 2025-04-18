package model.sender;

import model.exception.IrresponsibleSenderWithDangerousGoods;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sender {
    private String name;
    private String surname;
    private String pesel;
    private String address;
    private List<IrresponsibleSenderWithDangerousGoods> warnings;

    protected Sender() {
        warnings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    protected void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    protected void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAddress() {
        return address;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        int year = Integer.parseInt(pesel.substring(0, 2));
        int month = Integer.parseInt(pesel.substring(2, 4));
        int day = Integer.parseInt(pesel.substring(4, 6));

        if (month > 80) {
            year += 1800;
            month -= 80;
        } else if (month > 60) {
            year += 2200;
            month -= 60;
        } else if (month > 40) {
            year += 2100;
            month -= 40;
        } else if (month > 20) {
            year += 2000;
            month -= 20;
        } else {
            year += 1900;
        }

        return LocalDate.of(year, month, day);
    }

    public List<IrresponsibleSenderWithDangerousGoods> getWarnings() {
        return Collections.unmodifiableList(warnings);
    }

    protected void setWarnings(List<IrresponsibleSenderWithDangerousGoods> warnings) {
        this.warnings = new ArrayList<>(warnings);
    }

    public void addWarning(IrresponsibleSenderWithDangerousGoods warning) {
        warnings.add(warning);
    }

    public int getWarningsCount() {
        return warnings.size();
    }
}
