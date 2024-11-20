package lang;

public class ErrorMessage {

    public static final String WAREHOUSE_ALREADY_BUILT = "Magazyn został już stworzony!";
    public static final String TRAIN_ALREADY_BUILT = "Pociąg został już stworzony!";
    public static final String CONTAINER_ALREADY_BUILT = "Kontener został już stworzony!";
    public static final String SHIP_ALREADY_BUILT = "Statek został już stworzony!";
    public static final String SENDER_ALREADY_BUILT = "Nadawca został już stworzony!";
    public static final String EXCEPTION_ALREADY_BUILT = "Ostrzeżenie zostało już stworzone!";

    public static final String INVALID_WAREHOUSE = "Niepoprawny stan tworzonego magazynu!";
    public static final String INVALID_TRAIN = "Niepoprawny stan tworzonego pociągu!";
    public static final String INVALID_CONTAINER = "Niepoprawny stan tworzonego kontenera!";
    public static final String INVALID_SHIP = "Niepoprawny stan tworzonego statku!";
    public static final String INVALID_SENDER = "Niepoprawny stan tworzonego nadawcy!";
    public static final String INVALID_EXCEPTION = "Niepoprawny stan tworzonego ostrzeżenia!";

    public static final String SHIP_NOT_FOUND = "Nie znaleziono statku o podanym numerze!";
    public static final String CONTAINER_NOT_FOUND = "Nie znaleziono kontenera o podanym numerze!";

    public static final String TOO_HEAVY_CONTAINER = "Kontener jest zbyt ciężki!";
    public static final String TOO_MANY_CONTAINERS_ON_TRAIN = "Za dużo kontenerów na pociągu!";
    public static final String TOO_MANY_CONTAINERS_ON_SHIP = "Za dużo kontenerów na statku!";
    public static final String TOO_MANY_CONTAINERS_IN_WAREHOUSE = "Za dużo kontenerów w magazynie!";
    public static final String TOO_MANY_ELECTRIC_CONTAINERS = "Za dużo kontenerów wymagających zasilania!";
    public static final String TOO_MANY_HEAVY_CONTAINERS = "Za dużo kontenerów ciężkich!";
    public static final String TOO_MANY_TOXIC_OR_EXPLOSIVE_CONTAINERS = "Za dużo kontenerów na materiały toksyczne lub wybuchowe!";
    public static final String CONTAINER_LOADING_EXCEPTION = "Błąd podczas załadunku kontenera!";

    public static final String TARE_WEIGHT_HEAVY_CONTAINER_EXCLUSIVE = "Waga własna może być ustawiona tylko dla kontenerów ciężkich!";
    public static final String LIQUID_VOLUME_LIQUID_CONTAINER_EXCLUSIVE = "Objętość cieczy może być ustawiona tylko dla kontenerów na materiały ciekłe!";
    public static final String ADDITIONAL_PROTECTION_EXPLOSIVE_CONTAINER_EXCLUSIVE = "Dodatkowa ochrona może być ustawiona tylko dla kontenerów na materiały wybuchowe!";
    public static final String CONNECTED_TO_POWER_REFRIGERATED_CONTAINER_EXCLUSIVE = "Podłączenie do zasilania może być ustawione tylko dla kontenerów chłodniczych!";
    public static final String TOXICITY_LEVEL_TOXIC_CONTAINER_EXCLUSIVE = "Poziom toksyczności może być ustawiony tylko dla kontenerów na materiały toksyczne!";
    public static final String LOOSE_TOXIC_CONTAINER_FEATURES_LOOSE_TOXIC_CONTAINER_EXCLUSIVE = "Cechy kontenera na materiały toksyczne sypkie mogą być ustawione tylko dla kontenerów na materiały toksyczne sypkie!";

    public static final String ADDITIONAL_PROTECTION_INVALID_NAME = "Brak dodatkowej ochrony o nazwie ";
    public static final String LOOSE_TOXIC_CONTAINER_FEATURES_INVALID_NAME = "Brak cechy kontenera na materiały toksyczne sypkie o nazwie ";

    public static final String READING_FILE = "Błąd odczytu pliku!";
    public static final String WRITING_FILE = "Błąd zapisu pliku!";
    public static final String ERROR_DETAILS = "Szczegóły błędu: ";
}
