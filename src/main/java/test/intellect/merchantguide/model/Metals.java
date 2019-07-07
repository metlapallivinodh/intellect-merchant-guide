package test.intellect.merchantguide.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Metals {

    private Metals() {}

    private static final Map<String, Double> METALS = new HashMap<>();

    public static void add(String name, Double unitValue) {
        METALS.put(name, unitValue);
    }

    public static Double getUnitValue(String metalName) {
        return METALS.get(metalName);
    }

    public static void clearAll() {
        METALS.clear();
    }

    public static Map<String, Double> getAvailableMetals() {
        return Collections.unmodifiableMap(METALS);
    }
}
