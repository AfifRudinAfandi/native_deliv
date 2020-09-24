package com.build.delivery.conn;

import com.build.delivery.pojoauth.AuthBody;
import com.build.delivery.pojoauth.AuthResponse;
import com.build.delivery.pojophone.PhoneBody;
import com.build.delivery.pojophone.PhoneResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MainInterface {
    // TODO Melakukan Register & Login
    @POST("api/phone")
    Call<PhoneResponse> postLogin(@Body PhoneBody bodyLogin);
    @POST("api/login")
    Call<AuthResponse> postAuth(@Body AuthBody authBody);
}
