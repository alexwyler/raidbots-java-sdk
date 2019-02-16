package raidbots.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.io.FileUtils;
import util.JacksonUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by alexwyler on 2/15/19.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SInstance {

    public Long              id;
    public String            name;
    public String            type;
    public List<SEncounter> encounters;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SEncounter {
        public Long              id;
        public String            name;
        public String            icon;
    }
}
