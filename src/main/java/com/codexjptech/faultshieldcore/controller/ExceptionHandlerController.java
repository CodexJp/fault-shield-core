package com.codexjptech.faultshieldcore.controller;

import com.codexjptech.faultshieldcore.enums.app.ControllerErrorCodeEnum;
import com.codexjptech.faultshieldcore.exception.app.ExceptionHandlerControllerEx;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de ejemplo que ilustra como utilizar e invocar
 * nuestro Exception Handler para interceptar y dar formato a
 * nuestras excepciones de aplicación personalizadas
 * <br/><br/>
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
@RestController
public class ExceptionHandlerController {

    @GetMapping("/ping")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> ping(){

        throw new ExceptionHandlerControllerEx(
        "This is a custom exception example",
                ControllerErrorCodeEnum.ERROR_EXAMPLE
        );
    }
}
