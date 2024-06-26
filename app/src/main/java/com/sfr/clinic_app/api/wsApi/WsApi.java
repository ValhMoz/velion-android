package com.sfr.clinic_app.api.wsApi;

import com.sfr.clinic_app.api.Models.Appointment;
import com.sfr.clinic_app.api.Models.Invoice;
import com.sfr.clinic_app.api.Models.MedicalReport;
import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.api.Models.User;
import com.sfr.clinic_app.utils.Constantes;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

public interface WsApi {
    @GET(Constantes.GET_USER_BY_USERID)
    Call<List<User>> getUserByUserId(@Path("usuario_id") String usuarioId);

    @GET(Constantes.GET_PRODUCTOS)
    Call<List<Product>> getAllProducts();

    @GET(Constantes.GET_INVOICES_BY_USERID)
    Call<List<Invoice>> getAllInvoicesByUserId(@Path("usuario_id") String usuarioId);

    @GET(Constantes.GET_INFORMES_BY_USERID)
    Call<List<MedicalReport>> getAllReportsByUserId(@Path("usuario_id") String usuarioId);

    @GET(Constantes.GET_CITAS_BY_USERID)
    Call<List<Appointment>> getAllAppoinmentsByUserId(@Path("usuario_id") String usuarioId);

    @FormUrlEncoded
    @POST(Constantes.REGISTER)
    Call<ResponseBody> register(
            @Field("nombre") String nombre,
            @Field("apellidos") String apellidos,
            @Field("usuario_id") String usuario_id,
            @Field("fecha_nacimiento") String fecha_nacimiento,
            //@Field("genero") String genero,
            @Field("direccion") String direccion,
            @Field("provincia") String provincia,
            @Field("municipio") String municipio,
            @Field("cp") String cp,
            @Field("telefono") String phone,
            @Field("email") String email,
            @Field("pass") String password);

    @FormUrlEncoded
    @POST(Constantes.UPDATE_USER_DATA)
    Call<ResponseBody> updateUserData(
            @Field("usuario_id") String userId,
            @Field("email") String email,
            @Field("pass") String password);

    @FormUrlEncoded
    @POST(Constantes.CONFIRM_PURCHASE)
    Call<ResponseBody> confirmPurchase(
            @Field("usuario_id") String userId,
            @Field("producto_id") String producto_id,
            @Field("fecha_emision") String fecha_emision,
            @Field("estado") String estado);


    @GET(Constantes.RESETPASS)
    Call<ResponseBody> resetPass(@Path("email") String email);

    @FormUrlEncoded
    @POST(Constantes.LOGIN_URL)
    Call<User> login(@Field("email") String email, @Field("pass") String password);

    @GET(Constantes.GET_INFORME_BY_CITAID)
    @Streaming
    Call<ResponseBody> downloadFile(@Path("cita_id") int fileId);

}
