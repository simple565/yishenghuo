package com.yishenghuo.yishenghuo;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class NetWork {
    public static OkHttpClient iniClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder ().addInterceptor ( new Interceptor () {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request ()
                        .newBuilder ()
                        .addHeader ( "Content-Type", "application/x-www-form-urlencoded" )
                        .addHeader ( "Accept", "text/plain" )
                        .build ();
                return chain.proceed ( request );
            }
        } ).build ();
        return okHttpClient;
    }

    public static RequestBody getRequestBody(String string) {
        return RequestBody.create ( MediaType.parse ( "application/json; charset=utf-8" ), string );
    }
}
