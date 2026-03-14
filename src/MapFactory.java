import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {

    public static Map<String, String> createMap(int opcion) {

        switch (opcion) {

            case 1:
                return new HashMap<>();

            case 2:
                return new TreeMap<>();

            case 3:
                return new LinkedHashMap<>();

            default:
                System.out.println("Opcion invalida, usando HashMap");
                return new HashMap<>();
        }
    }
}
