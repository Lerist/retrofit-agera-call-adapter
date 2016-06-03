/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.drakeet.retrofit2.adapter.agera;

import retrofit2.Response;

/** Exception for an unexpected, non-2xx HTTP response. */
public final class HttpException extends Exception {

    private final int code;
    private final String message;
    private final transient Response<?> response;


    public HttpException(Response<?> response) {
        super("HTTP " + response.code() + " " + response.message());
        this.code = response.code();
        this.message = response.message();
        this.response = response;
    }


    /** HTTP status code. */
    public int code() {
        return code;
    }


    /** HTTP status message. */
    public String message() {
        return message;
    }


    /**
     * The full HTTP response. This may be null if the exception was serialized.
     */
    public Response<?> response() {
        return response;
    }
}
