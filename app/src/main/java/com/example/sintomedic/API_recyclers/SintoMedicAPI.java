package com.example.sintomedic.API_recyclers;

        import com.example.sintomedic.Sintoma;
        import com.example.sintomedic.Usuario;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.*;


public interface SintoMedicAPI {
        //  ########################USUARIOS ########################

        @GET("usuarios/{id}")
        Call<Usuario> loginUser(String dni_nie, String pass);
        //@Query("DNI_NIE") String DNI_NIE;

        //SELECCIONAR UN USUARIO EN LOGIN



        // PACIENTES DE UN DOCTOR (es_doctor false y id_doctor el suyo)
        //FALTA CONSULTA SQL QUERY
        @GET("usuarios")
        Call<List<Usuario>> listUsers( @Field("id_lista_doctores") int id_lista_doctores);

        @GET("usuarios/{id}")
        Call<Usuario> listUser();

        //CREAR USUARIO DOCTOR
        @POST("usuarios")
        Call<Usuario> createUser2(Usuario doctor);

        @POST("usuarios")
        @FormUrlEncoded
        Call<Usuario> createUser(@Body Usuario user);

        @POST("usuarios")
        Call<Usuario> createUser();


        //cargar pacientes de X DOCTOR
        @GET("usuarios/{es_paciente}")
        Call<List<Usuario>> loadPacientesDoctor();
        //@Query("DNI_NIE") String DNI_NIE;



    // ################# PARA SINTOMAS##########################

    @POST("sintomas")// envia nuevo sintoma a base
    Call<Sintoma> createSintoma(Sintoma sintoma);

    @GET("sintomas")
    Call<List<Sintoma>> listSintomas();


}
