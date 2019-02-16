package raidbots.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import util.JacksonUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by alexwyler on 2/14/19.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RBCharacterInfo {

    public List<RBClassInfo>                    classes;
    public Map<String, Map<String, RBSpecInfo>> specInfo;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RBSpecInfo {
        public String name;
        public Long id;
        public String mainStat;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RBClassInfo {
        public long id;
        public String name;
    }

}
