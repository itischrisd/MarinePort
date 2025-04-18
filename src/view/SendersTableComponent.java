package view;

import model.sender.Sender;
import ui.component.TableComponent;

import java.util.List;

import static lang.Data.*;

public class SendersTableComponent extends TableComponent<Sender> {

    private static final List<ColumnDefinition<Sender>> COLUMNS = List.of(
            new ColumnDefinition<>(FIELD_SENDER_NAME, Sender::getName),
            new ColumnDefinition<>(FIELD_SENDER_SURNAME, Sender::getSurname),
            new ColumnDefinition<>(FIELD_SENDER_PESEL, Sender::getPesel),
            new ColumnDefinition<>(FIELD_BIRTH_DATE, Sender::getBirthDate),
            new ColumnDefinition<>(FIELD_ADDRESS, Sender::getAddress),
            new ColumnDefinition<>(FIELD_WARNING_COUNT, Sender::getWarningsCount)
    );

    public SendersTableComponent(List<Sender> items) {
        super(COLUMNS, items);
    }
}
