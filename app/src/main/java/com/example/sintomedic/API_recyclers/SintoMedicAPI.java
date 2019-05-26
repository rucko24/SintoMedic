package com.example.sintomedic.API_recyclers;

        import com.example.sintomedic.Paciente;
        import com.example.sintomedic.Sintoma;
        import com.example.sintomedic.Usuario;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.POST;
        import retrofit2.http.Query;

public interface SintoMedicAPI {

    @GET("usuarios")
    Call<Usuario> loadUsuario();
        //@Query("DNI_NIE") String DNI_NIE;

    @GET("pacientes")
    Call<List<Paciente>> loadPacientes();

    @GET("sintomas")
    Call<List<Sintoma>> downloadSintomas();

    @POST("sintomas")// envia nuevo sintoma a base
    Call<List<Sintoma>> loadSintomas();

}
