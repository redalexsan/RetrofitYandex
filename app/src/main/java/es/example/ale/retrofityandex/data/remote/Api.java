package es.example.ale.retrofityandex.data.remote;

import retrofit2.Call;
import es.example.ale.retrofityandex.data.models.YandexResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("translate")
    Call<YandexResponse> getTranslation(
            @Query("key") String key,
            @Query("text") String text,
            @Query("lang") String lang);
}
