package com.example.sintomedic.API_recyclers;

        import com.example.sintomedic.Paciente;
        import com.example.sintomedic.Sintoma;
        import com.example.sintomedic.Usuario;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.GET;

public interface SintoMedicAPI {

    @GET("usuarios")
    Call<Usuario> loadUsuario();

    @GET("pacientes")
    Call<List<Paciente>> loadPacientes();

    @GET("sintomas")
    Call<List<Sintoma>> loadSintomas();
}
