/*
 * Copyright (C) 2016 drakeet.
 *     http://drakeet.me
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

import android.support.annotation.NonNull;
import com.google.android.agera.Result;
import com.google.android.agera.Supplier;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

import static com.google.android.agera.Preconditions.checkNotNull;

/**
 * @author drakeet
 */
class CallSupplier<T> implements Supplier<Result<T>> {

    private final Call<T> call;


    CallSupplier(@NonNull final Call<T> call) {
        this.call = checkNotNull(call);
    }


    @NonNull @Override public Result<T> get() {
        Result<T> result;
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                result = Result.success(response.body());
            } else {
                result = Result.failure(new HttpException(response));
            }
        } catch (IOException e) {
            e.printStackTrace();
            result = Result.failure(e);
        }
        return result;
    }
}
