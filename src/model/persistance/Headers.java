package model.persistance;

public class Headers {

    protected static final String TITLE_DOCUMENT = "--- STAN PORTU ZAŁADUNKOWEGO ---";
    protected static final String TITLE_WAREHOUSE = "- MAGAZYN -";
    protected static final String TITLE_TRAIN = "- POCIĄG -";
    protected static final String TITLE_SHIPS = "- STATKI -";
    protected static final String TITLE_SENDERS = "- NADAWCY -";

    protected static final String CONTAINER_COMMON = "Kontener podstawowy";
    protected static final String CONTAINER_HEAVY = "Kontener ciężki";
    protected static final String CONTAINER_REFRIGERATED = "Kontener chłodniczy";
    protected static final String CONTAINER_LIQUID = "Kontener na materiały ciekłe";
    protected static final String CONTAINER_EXPLOSIVE = "Kontener na materiały wybuchowe";
    protected static final String CONTAINER_LOOSE_TOXIC = "Kontener na materiały toksyczne sypkie";
    protected static final String CONTAINER_LIQUID_TOXIC = "Kontener na materiały toksyczne płynne";
    protected static final String SHIP = "Statek";
    protected static final String SENDER = "Nadawca";
    protected static final String WARNING = "Ostrzeżenie";

    protected static final String FIELD_LOCAL_DATE = "Data";
    protected static final String FIELD_MAX_CONTAINERS = "Maksymalna ilość kontenerów";
    protected static final String FIELD_ID = "ID";
    protected static final String FIELD_WEIGHT = "Waga";
    protected static final String FIELD_SENDER_PESEL = "PESEL nadawcy";
    protected static final String FIELD_TARE_WEIGHT = "Waga własna";
    protected static final String FIELD_LIQUID_VOLUME = "Objętość cieczy";
    protected static final String FIELD_ADDITIONAL_PROTECTION = "Dodatkowa ochrona";
    protected static final String FIELD_CONNECTED_TO_POWER = "Podłączony do zasilania";
    protected static final String FIELD_TOXICITY_LEVEL = "Poziom toksyczności";
    protected static final String FIELD_LOOSE_TOXIC_CONTAINER_FEATURES = "Cechy kontenera na materiały toksyczne sypkie";
    protected static final String FIELD_SHIP_NAME = "Nazwa";
    protected static final String FIELD_ORIGIN_PORT = "Port pochodzenia";
    protected static final String FIELD_CARGO_ORIGIN = "Pochodzenie ładunku";
    protected static final String FIELD_CARGO_DESTINATION = "Przeznaczenie ładunku";
    protected static final String FIELD_MAX_TOXIC_OR_EXPLOSIVE_CONTAINERS = "Maksymalna ilość kontenerów na materiały toksyczne lub wybuchowe";
    protected static final String FIELD_MAX_CONTAINERS_REQUIRING_ELECTRICITY = "Maksymalna ilość kontenerów wymagających zasilania";
    protected static final String FIELD_MAX_HEAVY_CONTAINERS = "Maksymalna ilość kontenerów ciężkich";
    protected static final String FIELD_MAX_TOTAL_CONTAINERS = "Maksymalna ilość kontenerów";
    protected static final String FIELD_MAX_CARGO_WEIGHT = "Maksymalna waga ładunku";
    protected static final String FIELD_SENDER_NAME = "Imię";
    protected static final String FIELD_SENDER_SURNAME = "Nazwisko";
    protected static final String FIELD_ADDRESS = "Adres";
    protected static final String FIELD_BIRTH_DATE = "Data urodzenia";
    protected static final String FIELD_STORING_DATE = "Data zmagazynowania";
    protected static final String FIELD_WARNING_COUNT = "Ilość ostrzeżeń";
    protected static final String FIELD_ARRIVAL_DATE = "Data przybycia";
    protected static final String FIELD_UTILIZATION_DATE = "Data wykorzystania";

    protected static final String CLASS_NAME_DELIMITER = " - ";
    protected static final String FIELD_NAME_DELIMITER = ": ";
    protected static final String FIELD_VALUE_DELIMITER = ", ";
    protected static final String FIELD_DELIMITER = "; ";
}
