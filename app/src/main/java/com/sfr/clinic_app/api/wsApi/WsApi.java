package com.sfr.clinic_app.api.wsApi;

import com.sfr.clinic_app.api.Models.Appointment;
import com.sfr.clinic_app.api.Models.MedicalReport;
import com.sfr.clinic_app.api.Models.Product;
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
    Call<User> getAllUsers();

    @GET(Constantes.GET_PRODUCTOS)
    Call<List<Product>> getAllProducts();

    @GET(Constantes.GET_INFORMES)
    Call<List<MedicalReport>> getAllReports();

    @GET(Constantes.GET_CITAS)
    Call<List<Appointment>> getAllAppoinments();

    @FormUrlEncoded
    @POST(Constantes.LOGIN_URL)
    Call<List<User>> login(@Field("email") String email, @Field("pass") String password);

}
