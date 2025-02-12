package view;

import model.sender.Sender;
import ui.component.TableComponent;

import java.util.List;

public class SendersView extends TableComponent<Sender> {

    private static final List<ColumnDefinition<Sender>> COLUMNS = List.of(
            new ColumnDefinition<>("Imię", Sender::getName),
            new ColumnDefinition<>("Nazwisko", Sender::getSurname),
            new ColumnDefinition<>("PESEL", Sender::getPesel),
            new ColumnDefinition<>("Adres", Sender::getAddress),
            new ColumnDefinition<>("Liczba ostrzeżeń", Sender::getWarningsCount)
    );

    public SendersView(List<Sender> items) {
        super(COLUMNS, items);
    }
}
