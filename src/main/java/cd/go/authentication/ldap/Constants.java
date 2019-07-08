/*
 * Copyright 2019 ThoughtWorks, Inc.
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

package cd.go.authentication.ldap;

import com.thoughtworks.go.plugin.api.GoPluginIdentifier;

import java.util.Arrays;

public interface Constants {
    // The type of this extension
    String EXTENSION_TYPE = "authorization";

    // The extension point API version that this plugin understands
    String API_VERSION = "1.0";
    String NEW_API_VERSION = "2.0";

    // the identifier of this plugin
    GoPluginIdentifier PLUGIN_IDENTIFIER = new GoPluginIdentifier(EXTENSION_TYPE, Arrays.asList(API_VERSION, NEW_API_VERSION));

    // requests that the plugin makes to the server
    String REQUEST_SERVER_PREFIX = "go.processor";
}
