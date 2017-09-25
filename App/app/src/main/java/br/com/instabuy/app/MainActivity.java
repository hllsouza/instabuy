package br.com.instabuy.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.instabuy.app.Adapter.ProductAdapter;
import br.com.instabuy.app.Entity.ProductEntity;
import br.com.instabuy.app.Entity.ProductResponse;
import br.com.instabuy.app.Infra.RetrofitBootstrap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<ProductEntity> mProducts = new ArrayList<>();
    private ProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        mAdapter = new ProductAdapter(mProducts, this);
        mListView.setAdapter(mAdapter);

        requestProductsByCategory("57eec92f072d415b67c24175");

    }

    private void requestProductsByCategory(String cateogry) {
        Call<ProductResponse> call = new RetrofitBootstrap()
                .getProductService()
                .all(cateogry);

        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                //mItens.addAll(response.body());
                mProducts.addAll(response.body().data);
                mAdapter.notifyDataSetChanged();
                Log.i("Request:", response.body().toString());

                //mList.setVisibility(View.VISIBLE);
                //mProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Log.i("Erro", t.toString() + call.toString());
            }
        });
    }
}
