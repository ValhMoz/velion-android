package com.sfr.clinic_app.inicio.interactor;

import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;

import com.sfr.clinic_app.api.Models.MedicalReport;
import com.sfr.clinic_app.api.wsApi.WsApi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InicioInteractorImpl implements InicioInteractor{

    @Inject
    public InicioInteractorImpl() {}

    @Inject
    WsApi wsApi;

    @Inject
    SharedPreferences sharedPreferences;


    @Override
    public void getReportsFromApi(InicioInteractor.OnGetProductsCallBacks callBack, InicioInteractor.OnErrorServer errorServer) {
        String userid = sharedPreferences.getString("usuario_id", null);

        wsApi.getAllReportsByUserId(userid).enqueue(new Callback<List<MedicalReport>>() {

            @Override
            public void onResponse(Call<List<MedicalReport>> call, Response<List<MedicalReport>> response) {
                if(response.isSuccessful()){
                    callBack.onSuccessCallBacks(new ArrayList<MedicalReport>(response.body()));
                }else{
                    callBack.onErrorCallBacks(response.code());
                }
            }

            @Override
            public void onFailure(Call<List<MedicalReport>> call, Throwable t) {
                errorServer.errorServerMessage(Arrays.toString(t.getStackTrace()));
            }
        });
    }

    public void downloadAndSaveFile(int fileId) {
        Call<ResponseBody> call = wsApi.downloadFile(fileId);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    boolean writtenToDisk = writeResponseBodyToDisk(response.body());
                    Log.d("File Download", "file download was a success? " + writtenToDisk);
                } else {
                    Log.e("File Download", "server contact failed");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("File Download", "error");
            }
        });
    }

    private boolean writeResponseBodyToDisk(ResponseBody body) {
        try {
            // Path to save the file
            File futureStudioIconFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "downloadedFile.pdf");

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);
                }

                outputStream.flush();

                return true;
            } catch (Exception e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (Exception e) {
            return false;
        }
    }
}
