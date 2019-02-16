package raidbots;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import raidbots.objects.RBCharacterInfo;
import raidbots.objects.SInstance;
import raidbots.objects.SItem;
import util.JacksonUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Helper functions for dealing with Raidbots' core data javascript files
 * Created by alexwyler on 2/16/19.
 */
public class CoreData {

    public static List<SInstance> instances;
    static {
        try {
            instances = JacksonUtil.readList(FileUtils.readFileToString(new File("data/instances-live.json")), SInstance.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static SInstance.SEncounter getEncounter(long id) {
        for (SInstance instance : instances) {
            for (SInstance.SEncounter encounter : instance.encounters) {
                if (encounter.id == id) {
                    return encounter;
                }
            }
        }
        return null;
    }

    public static SInstance.SEncounter getEncounter(SItem item) {
        for (SItem.SItemSource source : item.sources) {
            SInstance.SEncounter encounter = getEncounter(source.encounterId);
            if (encounter != null) {
                return encounter;
            }
        }
        return null;
    }

    public static SInstance getInstanceForName(String name) {
        for (SInstance instance : instances) {
            if (instance.name.equals(name)) {
                return instance;
            }
        }
        return null;
    }


    public static RBCharacterInfo info;
    static {
        try {
            info = JacksonUtil.read(FileUtils.readFileToString(new File("data/raidbots-character.json")), RBCharacterInfo.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long specIdForName(String _class, String name) {
        return info.specInfo.get(_class).get(StringUtils.lowerCase(name).replaceAll("\\s", "_")).id;
    }

    public static String classNameForId(long id) {
        for (RBCharacterInfo.RBClassInfo classInfo : info.classes) {
            if (classInfo.id == id) {
                return classInfo.name;
            }
        }
        return null;
    }

    public static List<SItem> items;
    static {
        try {
            items = JacksonUtil.readList(FileUtils.readFileToString(new File("data/encounter-items-live.json")), SItem.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SItem getItem(long itemId) {
        for (SItem item : items) {
            if (item.id == itemId) {
                return item;
            }
        }
        return null;
    }

}
