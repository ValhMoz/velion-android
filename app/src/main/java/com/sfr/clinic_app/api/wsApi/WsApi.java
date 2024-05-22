package com.sfr.clinic_app.api.wsApi;

import com.sfr.clinic_app.api.Models.User;
import com.sfr.clinic_app.utils.Constantes;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WsApi {
    @GET(Constantes.GET_USERS)
    Call<List<User>> getAllUsers();


}
