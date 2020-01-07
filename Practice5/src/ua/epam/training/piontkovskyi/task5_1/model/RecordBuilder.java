package ua.epam.training.piontkovskyi.task5_1.model;

public class RecordBuilder {
    private Record record;

    public RecordBuilder() {
        record = new Record();
    }

    public RecordBuilder withFirstName(String firstName) {
        record.setFirstName(firstName);
        return this;
    }

    public RecordBuilder withLastName(String lastName) {
        record.setLastName(lastName);
        return this;
    }

    public RecordBuilder withAddress(String address) {
        record.setAddress(address);
        return this;
    }

    public RecordBuilder withDateOfBirth(String dateOfBirth) {
        record.setDateOfBirth(dateOfBirth);
        return this;
    }

    public RecordBuilder withPhoneNumber(String phoneNumber) {
        record.setPhoneNumber(phoneNumber);
        return this;
    }

    public Record build() {
        return record;
    }
}
