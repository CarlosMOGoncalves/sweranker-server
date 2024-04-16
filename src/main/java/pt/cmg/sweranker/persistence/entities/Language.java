/*
 * Copyright (c) 2019
 *
 * Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 *
 * All rights reserved.
 */
package pt.cmg.sweranker.persistence.entities;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Carlos Gonçalves
 */
public enum Language {

    PT_PT,
    EN_UK,
    ES_ES;

    public static final Language DEFAULT_LANGUAGE = PT_PT;

    private static final Map<String, Language> map = new HashMap<>();

    static {
        Language[] values = Language.values();
        for (Language value : values) {
            map.put(value.name().toLowerCase(Locale.ROOT), value);
        }
    }

    public static Language fromString(String name) {
        if (name == null) {
            return DEFAULT_LANGUAGE;
        }
        return map.getOrDefault(name.toLowerCase(Locale.ROOT), DEFAULT_LANGUAGE);
    }
}
