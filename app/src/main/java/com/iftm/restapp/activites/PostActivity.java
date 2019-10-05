package com.iftm.restapp.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.iftm.restapp.R;
import com.iftm.restapp.entidades.Post;
import com.iftm.restapp.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    private static final String TAG = "PostActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        enviarConsultaRest();
    }

    private void enviarConsultaRest() {
        Post post = new Post(1,
                "Teste",
                "Many left work early to join the spontaneous demonstrations. Some furious protesters blocked roads, " +
                        "torched Chinese flags and vandalised stations and businesses, as police fired rounds of tear gas");
        RetrofitService.getServico().criarPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                int codigo = response.code();
                int id = response.body().getId();

                ((TextView)findViewById(R.id.textViewNovoIdCriado)).setText(""+id);
                ((TextView)findViewById(R.id.textViewCodigoDeRetorno)).setText(""+codigo);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
