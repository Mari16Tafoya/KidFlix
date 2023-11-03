package com.example.kidflix.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCliente {
    //FUNCIONA COMO UN CONTROLADOR
    //ESTABLECER LLAMADO A LA API
    //PASAR LOS DATOS DEL JSON A UN OBJETO

    private static Retrofit retrofit;
    public static Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.133.96.171/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
