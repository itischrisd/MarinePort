package lang;

public class Data {

    public static final String TITLE_DOCUMENT = "--- STAN PORTU ZAŁADUNKOWEGO ---";
    public static final String TITLE_WAREHOUSE = "- MAGAZYN -";
    public static final String TITLE_TRAIN = "- POCIĄG -";
    public static final String TITLE_SHIPS = "- STATKI -";
    public static final String TITLE_SENDERS = "- NADAWCY -";

    public static final String CONTAINER_COMMON = "Kontener podstawowy";
    public static final String CONTAINER_HEAVY = "Kontener ciężki";
    public static final String CONTAINER_REFRIGERATED = "Kontener chłodniczy";
    public static final String CONTAINER_LIQUID = "Kontener na materiały ciekłe";
    public static final String CONTAINER_EXPLOSIVE = "Kontener na materiały wybuchowe";
    public static final String CONTAINER_LOOSE_TOXIC = "Kontener na materiały toksyczne sypkie";
    public static final String CONTAINER_LIQUID_TOXIC = "Kontener na materiały toksyczne płynne";
    public static final String SHIP = "Statek";
    public static final String SENDER = "Nadawca";
    public static final String WARNING = "Ostrzeżenie";

    public static final String FIELD_LOCAL_DATE = "Data";
    public static final String FIELD_MAX_CONTAINERS = "Maksymalna ilość kontenerów";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_WEIGHT = "Waga";
    public static final String FIELD_SENDER_PESEL = "PESEL nadawcy";
    public static final String FIELD_TARE_WEIGHT = "Waga własna";
    public static final String FIELD_LIQUID_VOLUME = "Objętość cieczy";
    public static final String FIELD_ADDITIONAL_PROTECTION = "Dodatkowa ochrona";
    public static final String FIELD_CONNECTED_TO_POWER = "Podłączony do zasilania";
    public static final String FIELD_TOXICITY_LEVEL = "Poziom toksyczności";
    public static final String FIELD_LOOSE_TOXIC_CONTAINER_FEATURES = "Cechy kontenera na materiały toksyczne sypkie";
    public static final String FIELD_SHIP_NAME = "Nazwa";
    public static final String FIELD_ORIGIN_PORT = "Port pochodzenia";
    public static final String FIELD_CARGO_ORIGIN = "Pochodzenie ładunku";
    public static final String FIELD_CARGO_DESTINATION = "Przeznaczenie ładunku";
    public static final String FIELD_MAX_TOXIC_OR_EXPLOSIVE_CONTAINERS = "Maksymalna ilość kontenerów na materiały toksyczne lub wybuchowe";
    public static final String FIELD_MAX_CONTAINERS_REQUIRING_ELECTRICITY = "Maksymalna ilość kontenerów wymagających zasilania";
    public static final String FIELD_MAX_HEAVY_CONTAINERS = "Maksymalna ilość kontenerów ciężkich";
    public static final String FIELD_MAX_TOTAL_CONTAINERS = "Maksymalna ilość kontenerów";
    public static final String FIELD_MAX_CARGO_WEIGHT = "Maksymalna waga ładunku";
    public static final String FIELD_SENDER_NAME = "Imię";
    public static final String FIELD_SENDER_SURNAME = "Nazwisko";
    public static final String FIELD_ADDRESS = "Adres";
    public static final String FIELD_BIRTH_DATE = "Data urodzenia";
    public static final String FIELD_STORING_DATE = "Data zmagazynowania";
    public static final String FIELD_WARNING_COUNT = "Ilość ostrzeżeń";
    public static final String FIELD_ARRIVAL_DATE = "Data przybycia";
    public static final String FIELD_UTILIZATION_DATE = "Data wykorzystania";

    public static final String ENUM_NONE = "Brak";
    public static final String ENUM_REINFORCED_WALLS = "Wzmocnione ściany";
    public static final String ENUM_EXPLOSION_SUPPRESSORS = "Tłumiki eksplozji";
    public static final String ENUM_FIRE_RESISTANT_COATING = "Odporna na ogień powłoka";
    public static final String ENUM_TEMPERATURE_CONTROL = "Kontrola temperatury";
    public static final String ENUM_VENTILATION_SYSTEM = "System wentylacji";
    public static final String ENUM_LEAK_DETECTION_SYSTEM = "System wykrywania wycieków";
    public static final String ENUM_DUST_CONTROL_SYSTEM = "System kontroli pyłów";

    public static final String CLASS_NAME_DELIMITER = " - ";
    public static final String FIELD_NAME_DELIMITER = ": ";
    public static final String FIELD_VALUE_DELIMITER = ", ";
    public static final String FIELD_DELIMITER = "; ";
}
