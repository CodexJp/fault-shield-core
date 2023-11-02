package com.codexjptech.faultshieldcore.util;

/**
 * Establece funciones para la construcción de códigos
 * de error personalizados
 *
 * <ul><li>
 * La generación de estos códigos se gestiona de forma implícita, el dev no tiene que hacer más que
 * crear las excepciones personalizadas vinculadas a las enumeraciones de excepción correspondientes
 * </li><li>
 * Es importante entender que esta clase reacciona en dirección a la capa de la aplicación desde donde
 * queremos lanzar nuestra excepción personalizada. Por tal razón, es importante identificar la capa o
 * componente a tratar. Esto, con el fin de acceder a los métodos correspondientes para la
 * generación de dichos códigos
 * </li><li>
 * Format -> [application-prefix]-[issue-classification]-[application-layer]-[issue-sequence]
 * </li></ul>
 *
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
public class GlobalErrorCodeManagerImpl implements IGlobalErrorCodeManager{

    private static final GlobalErrorCodeManagerImpl INSTANCE = new GlobalErrorCodeManagerImpl();
    private int nextIssueSequence = 1;

    // Constructor privado para evitar instanciación directa
    private GlobalErrorCodeManagerImpl() { }

    public static GlobalErrorCodeManagerImpl getInstance() {
        return INSTANCE;
    }

    // {APP}_E_C_0XXX
    @Override
    public String generateControllerErrorCode() {
        return GlobalErrorCodeManagerPrefixUtil.getApplicationNamePrefix() +
                GlobalErrorCodeManagerPrefixUtil.getIssueClassificationErrorPrefix() +
                GlobalErrorCodeManagerPrefixUtil.getApplicationLayerControllerPrefix() +
                getNextIssueSequence();
    }

    // {APP}_E_S_0XXX
    @Override
    public String generateServiceErrorCode() {
        return GlobalErrorCodeManagerPrefixUtil.getApplicationNamePrefix() +
                GlobalErrorCodeManagerPrefixUtil.getIssueClassificationErrorPrefix() +
                GlobalErrorCodeManagerPrefixUtil.getApplicationLayerServicePrefix() +
                getNextIssueSequence();
    }

    // {APP}_W_S_0XXX
    @Override
    public String generateServiceWarningCode() {
        return GlobalErrorCodeManagerPrefixUtil.getApplicationNamePrefix() +
                GlobalErrorCodeManagerPrefixUtil.getIssueClassificationWarningPrefix() +
                GlobalErrorCodeManagerPrefixUtil.getApplicationLayerServicePrefix() +
                getNextIssueSequence();
    }

    // {APP}_E_R_0XXX
    @Override
    public String generateRepositoryErrorCode() {
        return GlobalErrorCodeManagerPrefixUtil.getApplicationNamePrefix() +
                GlobalErrorCodeManagerPrefixUtil.getIssueClassificationErrorPrefix() +
                GlobalErrorCodeManagerPrefixUtil.getApplicationLayerRepositoryPrefix() +
                getNextIssueSequence();
    }

    // {APP}_E_D_0XXX
    @Override
    public String generateDatasourceErrorCode() {
        return GlobalErrorCodeManagerPrefixUtil.getApplicationNamePrefix() +
                GlobalErrorCodeManagerPrefixUtil.getIssueClassificationErrorPrefix() +
                GlobalErrorCodeManagerPrefixUtil.getApplicationLayerDatasourcePrefix() +
                getNextIssueSequence();
    }

    // {APP}_E_C_0XXX
    @Override
    public String generateUseCaseErrorCode() {
        return GlobalErrorCodeManagerPrefixUtil.getApplicationNamePrefix() +
                GlobalErrorCodeManagerPrefixUtil.getIssueClassificationErrorPrefix() +
                GlobalErrorCodeManagerPrefixUtil.getApplicationLayerUseCasePrefix() +
                getNextIssueSequence();
    }

    // {APP}_E_T_0XXX
    @Override
    public String generateUtilityErrorCode() {
        return GlobalErrorCodeManagerPrefixUtil.getApplicationNamePrefix() +
                GlobalErrorCodeManagerPrefixUtil.getIssueClassificationErrorPrefix() +
                GlobalErrorCodeManagerPrefixUtil.getApplicationLayerUtilityPrefix() +
                getNextIssueSequence();
    }

    // {APP}_E_G_0XXX
    @Override
    public String generateGlobalErrorCode() {
        return GlobalErrorCodeManagerPrefixUtil.getApplicationNamePrefix() +
                GlobalErrorCodeManagerPrefixUtil.getIssueClassificationErrorPrefix() +
                GlobalErrorCodeManagerPrefixUtil.getApplicationLayerGlobalPrefix() +
                getNextIssueSequence();
    }

    public String getApplicationName(){
        return GlobalErrorCodeManagerPrefixUtil.getApplicationName();
    }

    protected String getNextIssueSequence() {
        return String.format("%04d", nextIssueSequence++);
    }
}
