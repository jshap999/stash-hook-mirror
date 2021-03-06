package com.englishtown.stash.hook;

import com.atlassian.stash.internal.setting.MapSettingsBuilder;
import com.atlassian.stash.setting.Settings;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Unit tests for {@link DefaultSettingsReflectionHelper}
 */
public class DefaultSettingsReflectionHelperTest {

    @Test
    public void testSet() throws Exception {

        DefaultSettingsReflectionHelper helper = new DefaultSettingsReflectionHelper();
        MapSettingsBuilder builder = new MapSettingsBuilder();
        Map<String, Object> values = new HashMap<String, Object>();

        builder.add("old", "old");
        values.put("new", "new");

        Settings settings = builder.build();
        helper.set(values, settings);

        assertNull(settings.getString("old"));
        assertEquals("new", settings.getString("new"));

    }

}
