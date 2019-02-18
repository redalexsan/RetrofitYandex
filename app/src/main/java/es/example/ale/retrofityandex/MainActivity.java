package es.example.ale.retrofityandex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import es.example.ale.retrofityandex.data.models.YandexResponse;
import es.example.ale.retrofityandex.data.remote.Api;
import es.example.ale.retrofityandex.data.remote.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String KEY="trnsl.1.1.20190215T125657Z.4fbe4c65c6b3f20a.68870d51cbf9ad795f5381708cb580639f8c51bd";
    TextView txtTranslated,textToTranslate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        textToTranslate = ActivityCompat.requireViewById(this,R.id.txtToTranslate);
        Button btnTranslate = ActivityCompat.requireViewById(this,R.id.btnTranslate);
        txtTranslated = ActivityCompat.requireViewById(this,R.id.txtTranslated);

        btnTranslate.setOnClickListener(v -> translateText());
    }

    private void translateText() {
        Api api = ApiService.newInstance().getApi();
        Call<YandexResponse> response = api.getTranslation(KEY,textToTranslate.getText().toString(),"en-es");

        response.enqueue(new Callback<YandexResponse>() {
            @Override
            public void onResponse(Call<YandexResponse> call, Response<YandexResponse> response) {
                if(response.body() != null && response.isSuccessful())
                    txtTranslated.setText(response.body().getText().get(0));
            }

            @Override
            public void onFailure(Call<YandexResponse> call, Throwable t) {

            }
        });
    }
}
