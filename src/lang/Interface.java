package lang;

public class Interface {

    public static final String MENU_TITLE = "--- Aplikacja portowa ---";
    public static final String MENU_ITEM_CREATE_SHIP = "Stwórz nowy statek.";
    public static final String MENU_ITEM_CREATE_CONTAINER = "Stwórz nowy kontener.";
    public static final String MENU_ITEM_DISPLAY_SHIPS = "Wyświetl listę statków.";
    public static final String MENU_ITEM_DISPLAY_CONTAINERS_IN_SHIP = "Wyświetl kontenery na statku.";
    public static final String MENU_ITEM_DISPLAY_WAREHOUSE = "Wyświetl stan magazynu.";
    public static final String MENU_ITEM_DISPLAY_TRAIN = "Wyświetl stan pociągu.";
    public static final String MENU_ITEM_DISPLAY_SENDERS = "Wyświetl listę nadawców.";
    public static final String MENU_ITEM_UTILIZE_CONTAINER = "Zutylizuj kontener z magazynu.";
    public static final String MENU_ITEM_SEND_SHIP = "Wyślij statek w rejs.";
    public static final String MENU_ITEM_SAVE = "Zapisz stan portu.";
    public static final String MENU_ITEM_LOAD = "Wczytaj stan portu.";
    public static final String MENU_ITEM_EXIT = "Zakończ program.";

    public static final String PROMPT = "Wybierz opcję:";
    public static final String UTILIZATION_PROMPT = "Podaj ID kontenera do utylizacji:";
    public static final String SAVE_FILE_NAME_PROMPT = "Podaj nazwę pliku do zapisu (puste aby pozostać przy domyślnej):";
    public static final String LOAD_FILE_NAME_PROMPT = "Podaj nazwę pliku do wczytania:";
    public static final String DEPARTURE_PROMPT = "Podaj ID statku do wypłynięcia:";
    public static final String SHIP_NAME_PROMPT = "Podaj nazwę statku:";
    public static final String ORIGIN_PORT_PROMPT = "Podaj port pochodzenia:";
    public static final String CARGO_ORIGIN_PROMPT = "Podaj pochodzenie ładunku:";
    public static final String CARGO_DESTINATION_PROMPT = "Podaj cel ładunku:";
    public static final String MAX_CONTAINERS_PROMPT = "Podaj maksymalną liczbę kontenerów:";
    public static final String MAX_CARGO_WEIGHT_PROMPT = "Podaj maksymalną wagę ładunku:";
    public static final String MAX_HEAVY_CONTAINERS_PROMPT = "Podaj maksymalną liczbę ciężkich kontenerów";
    public static final String MAX_CONTAINERS_REQUIRING_ELECTRICITY_PROMPT = "Podaj maksymalną liczbę kontenerów wymagających prądu:";
    public static final String MAX_TOXIC_OR_EXPLOSIVE_CONTAINERS_PROMPT = "Podaj maksymalną liczbę kontenerów toksycznych lub wybuchowych:";
    public static final String CONTAINER_TYPE_PROMPT = "Wybierz typ kontenera:";
    public static final String CONTAINER_WEIGHT_PROMPT = "Podaj wagę kontenera:";
    public static final String SENDER_PROMPT = "Wybierz numer nadawcy:";
    public static final String CONNECTED_TO_POWER_PROMPT = "Podaj czy kontener jest podłączony do prądu:";
    public static final String LIQUID_VOLUME_PROMPT = "Podaj objętość cieczy:";
    public static final String ADDITIONAL_PROTECTION_TYPE_PROMPT = "Wybierz dodatkową ochronę:";
    public static final String TOXICITY_LEVEL_PROMPT = "Podaj poziom toksyczności:";
    public static final String CONTAINER_FEATURES_PROMPT = "Podaj numery cech oddzielone spacjami:";
    public static final String TARE_WEIGHT_PROMPT = "Podaj wagę tara:";


    public static final String INVALID_OPTION = "Niepoprawna opcja!";
    public static final String INVALID_VALUE = "Niepoprawna wartość!";
    public static final String INVALID_CONTAINER_ID = "Niepoprawny numer kontenera!";
    public static final String INVALID_FILE_NAME_CANNOT_BE_EMPTY = "Nazwa pliku nie może być pusta!";
    public static final String INVALID_FILE_DOES_NOT_EXIST = "Plik o podanej nazwie nie istnieje!";
    public static final String INVALID_SHIP_ID = "Niepoprawny numer statku!";
    public static final String INVALID_SHIP_NAME = "Nazwa statku nie może być pusta!";
    public static final String INVALID_ORIGIN_PORT = "Port pochodzenia nie może być pusty!";
    public static final String INVALID_CARGO_ORIGIN = "Pochodzenie ładunku nie może być puste!";
    public static final String INVALID_CARGO_DESTINATION = "Cel ładunku nie może być pusty!";
    public static final String INVALID_MAX_CONTAINERS = "Maksymalna liczba kontenerów musi być większa od 0!";
    public static final String INVALID_MAX_CARGO_WEIGHT = "Maksymalna waga ładunku musi być większa od 0!";
    public static final String INVALID_MAX_HEAVY_CONTAINERS = "Maksymalna liczba ciężkich kontenerów musi być z przedziału od 0 do maksymalnej liczby kontenerów!";
    public static final String INVALID_MAX_CONTAINERS_REQUIRING_ELECTRICITY = "Maksymalna liczba kontenerów wymagających prądu musi być z przedziału od 0 do maksymalnej liczby ciężkich kontenerów!";
    public static final String INVALID_MAX_TOXIC_OR_EXPLOSIVE_CONTAINERS = "Maksymalna liczba kontenerów toksycznych lub wybuchowych musi być z przedziału od 0 do maksymalnej liczby kontenerów ciężkich wyłączając kontenery wymagające prądu!";
    public static final String INVALID_CONTAINER_TYPE = "Niepoprawny numer typu kontenera!";
    public static final String INVALID_CONTAINER_WEIGHT = "Waga kontenera musi być większa od 0!";
    public static final String INVALID_SENDER_INDEX = "Niepoprawny numer nadawcy!";
    public static final String INVALID_LIQUID_VOLUME = "Objętość cieczy musi być większa od 0!";
    public static final String INVALID_ADDITIONAL_PROTECTION = "Niepoprawny numer dodatkowej ochrony!";
    public static final String INVALID_TOXICITY_LEVEL = "Poziom toksyczności musi być większy lub równy 0!";
    public static final String INVALID_FEATURES = "Niepoprawne numery cech!";
    public static final String INVALID_TARE_WEIGHT = "Waga tara musi być z przedziału od 0 do wagi kontenera!";

    public static final String WAREHOUSE_CONTAINERS_HEADER = "Lista kontenerów w magazynie";
    public static final String CONTAINER_TYPES_HEADER = "Typy kontenerów";
    public static final String SENDERS_HEADER = "Nadawcy";
    public static final String ADDITIONAL_PROTECTION_HEADER = "Dodatkowa ochrona";
    public static final String CONTAINER_FEATURES_HEADER = "Cechy kontenera";

    public static final String SENDER_LIST_FORMAT = "%s %s, ostrzeżeń: %d";
}
