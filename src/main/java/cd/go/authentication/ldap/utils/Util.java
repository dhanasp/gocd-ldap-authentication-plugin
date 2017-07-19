/*
 * Copyright 2017 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cd.go.authentication.ldap.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Util {
    public static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public static String readResource(String resourceFile) {
        return new String(readResourceBytes(resourceFile), StandardCharsets.UTF_8);
    }

    public static byte[] readResourceBytes(String resourceFile) {
        try {
            Path path = Paths.get(Util.class.getResource(resourceFile).toURI());
            return Files.readAllBytes(path);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException("Could not find resource " + resourceFile, e);
        }
    }

    public static String pluginId() {
        String s = readResource("/plugin.properties");
        try {
            Properties properties = new Properties();
            properties.load(new StringReader(s));
            return (String) properties.get("pluginId");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String pluginVersion() {
        String s = readResource("/plugin.properties");
        try {
            Properties properties = new Properties();
            properties.load(new StringReader(s));
            return (String) properties.get("version");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> listFromCommaSeparatedString(String str) {
        if (isBlank(str)) {
            return Collections.emptyList();
        }
        return Arrays.asList(str.split("\\s*,\\s*"));
    }

    public static List<String> splitIntoLinesAndTrimSpaces(String lines) {
        if (isBlank(lines)) {
            return Collections.emptyList();
        }

        return Arrays.asList(lines.split("\\s*[\r\n]+\\s*"));
    }

    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

}
