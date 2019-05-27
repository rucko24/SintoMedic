package com.example.sintomedic.API_recyclers;

        import com.example.sintomedic.Sintoma;
        import com.example.sintomedic.Usuario;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.Field;
        import retrofit2.http.FormUrlEncoded;
        import retrofit2.http.GET;
        import retrofit2.http.POST;

public interface SintoMedicAPI {

    @GET("usuarios")
    Call<Usuario> listUsers();
        //@Query("DNI_NIE") String DNI_NIE;

    @GET("usuarios/{id}")
    Call<Usuario> listUser();


    @POST("usuarios")
    @FormUrlEncoded
    Call<Usuario> createUser(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);

    // PARA SINTOMAS

    @POST("sintomas")// envia nuevo sintoma a base
    Call<List<Sintoma>> createSintoma();

    @GET("sintomas")
    Call<List<Sintoma>> listSintomas();



}
