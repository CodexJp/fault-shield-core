package com.codexjptech.faultshieldcore.util;

import com.codexjptech.faultshieldcore.config.AppConfig;
import com.codexjptech.faultshieldcore.model.constant.ApplicationConstants;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Class used to build a custom error code for each runtime exception
 * <b>Convention Name Exception Code:<b/>
 * <br/><br/>
 *
 * <table>
 *   <tr>
 *     <th>Argument</th>
 *     <th>Identifier</th>
 *     <th>Description</th>
 *     <th>Size</th>
 *   </tr>
 *   <tr>
 *     <td>Application Prefix</td>
 *     <td>N/A</td>
 *     <td>Application Name</td>
 *     <td>≤40</td>
 *   </tr>
 *   <tr>
 *     <td>Issue Classification</td>
 *     <td>E</td>
 *     <td>Error</td>
 *     <td>1</td>
 *   </tr>
 *   <tr>
 *     <td>Issue Classification</td>
 *     <td>W</td>
 *     <td>Warning</td>
 *     <td>1</td>
 *   </tr>
 *   <tr>
 *     <td>Application Layer</td>
 *     <td>C</td>
 *     <td>Controller</td>
 *     <td>1</td>
 *   </tr>
 *   <tr>
 *     <td>Application Layer</td>
 *     <td>S</td>
 *     <td>Service</td>
 *     <td>1</td>
 *   </tr>
 *   <tr>
 *     <td>Application Layer</td>
 *     <td>R</td>
 *     <td>Repository</td>
 *     <td>1</td>
 *   </tr>
 *   <tr>
 *     <td>Application Layer</td>
 *     <td>D</td>
 *     <td>Datasource</td>
 *     <td>1</td>
 *   </tr>
 *   <tr>
 *     <td>Application Layer</td>
 *     <td>C</td>
 *     <td>Use Case</td>
 *     <td>1</td>
 *   </tr>
 *   <tr>
 *     <td>Application Layer</td>
 *     <td>T</td>
 *     <td>Utility</td>
 *     <td>1</td>
 *   </tr>
 *   <tr>
 *     <td>Application Layer</td>
 *     <td>G</td>
 *     <td>Global</td>
 *     <td>1</td>
 *   </tr>
 *   <tr>
 *     <td>Issue Sequence</td>
 *     <td>N/A</td>
 *     <td>Issue Sequence</td>
 *     <td>4</td>
 *   </tr>
 * </table>
 *
 * <br/>
 * Copyright 2023 Jairo Polo <contacto.jairopolo@gmail.com>
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
 * <br/><br/>
 *
 * @author  Jairo Polo
 * @since 0.0.1
 */
@Component
public class GlobalErrorCodeManagerPrefixUtil {

    private static String applicationName;
    private static String applicationNamePrefix;

    // ISSUE CLASSIFICATION
    private static final String ISSUE_CLASSIFICATION_ERROR_PREFIX = "E" + ApplicationConstants.HYPHEN_CHAR;
    private static final String ISSUE_CLASSIFICATION_WARNING_PREFIX = "W" + ApplicationConstants.HYPHEN_CHAR;

    // APPLICATION LAYER
    private static final String APPLICATION_LAYER_CONTROLLER_PREFIX = "C" + ApplicationConstants.HYPHEN_CHAR;
    private static final String APPLICATION_LAYER_SERVICE_PREFIX = "S" + ApplicationConstants.HYPHEN_CHAR;
    private static final String APPLICATION_LAYER_REPOSITORY_PREFIX = "R" + ApplicationConstants.HYPHEN_CHAR;
    private static final String APPLICATION_LAYER_DATASOURCE_PREFIX = "D" + ApplicationConstants.HYPHEN_CHAR;
    private static final String APPLICATION_LAYER_USE_CASE_PREFIX = "U" + ApplicationConstants.HYPHEN_CHAR;
    private static final String APPLICATION_LAYER_UTILITY_PREFIX = "T" + ApplicationConstants.HYPHEN_CHAR;
    private static final String APPLICATION_LAYER_GLOBAL_PREFIX = "G" + ApplicationConstants.HYPHEN_CHAR;

    @SuppressWarnings({"squid:S3010"})
    private GlobalErrorCodeManagerPrefixUtil(AppConfig appConfig){
        applicationName = appConfig.getApplicationName();
        applicationNamePrefix = applicationName.toUpperCase(Locale.ROOT) + ApplicationConstants.HYPHEN_CHAR;
    }

    // Error
    public static String getIssueClassificationErrorPrefix(){
        return ISSUE_CLASSIFICATION_ERROR_PREFIX;
    }

    // Warning
    public static String getIssueClassificationWarningPrefix(){
        return ISSUE_CLASSIFICATION_WARNING_PREFIX;
    }

    public static String getApplicationLayerControllerPrefix(){
        return APPLICATION_LAYER_CONTROLLER_PREFIX;
    }

    public static String getApplicationLayerServicePrefix(){
        return APPLICATION_LAYER_SERVICE_PREFIX;
    }

    public static String getApplicationLayerRepositoryPrefix(){
        return APPLICATION_LAYER_REPOSITORY_PREFIX;
    }

    public static String getApplicationLayerDatasourcePrefix(){
        return APPLICATION_LAYER_DATASOURCE_PREFIX;
    }

    public static String getApplicationLayerUseCasePrefix(){
        return APPLICATION_LAYER_USE_CASE_PREFIX;
    }

    public static String getApplicationLayerUtilityPrefix(){
        return APPLICATION_LAYER_UTILITY_PREFIX;
    }

    public static String getApplicationLayerGlobalPrefix(){
        return APPLICATION_LAYER_GLOBAL_PREFIX;
    }

    public static String getApplicationName(){
        return applicationName;
    }

    public static String getApplicationNamePrefix(){
        return applicationNamePrefix;
    }
}
