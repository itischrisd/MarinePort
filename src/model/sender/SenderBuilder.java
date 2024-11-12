package model.sender;

import model.exception.IrresponsibleSenderWithDangerousGoods;

import java.util.List;

public class SenderBuilder {

    private Sender sender;

    private SenderBuilder() {
        this.sender = new Sender();
    }

    public static SenderBuilder sender() {
        return new SenderBuilder();
    }

    public SenderBuilder withName(String name) {
        sender.setName(name);
        return this;
    }

    public SenderBuilder withSurname(String surname) {
        sender.setSurname(surname);
        return this;
    }

    public SenderBuilder withPesel(String pesel) {
        sender.setPesel(pesel);
        return this;
    }

    public SenderBuilder withAddress(String address) {
        sender.setAddress(address);
        return this;
    }

    public SenderBuilder withWarnings(List<IrresponsibleSenderWithDangerousGoods> warnings) {
        sender.setWarnings(warnings);
        return this;
    }

    public Sender build() {
        if (this.sender == null) {
            throw new IllegalStateException("This builder has already built a sender.");
        }
        Sender builtSender = this.sender;
        this.sender = null;
        return builtSender;
    }
}
