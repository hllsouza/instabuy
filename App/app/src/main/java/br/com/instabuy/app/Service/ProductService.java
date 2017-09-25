package br.com.instabuy.app.Service;

import java.util.List;


import br.com.instabuy.app.Entity.ProductResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductService {

    @GET("product.json")
    Call<ProductResponse> all(@Query("subcategory_id") String id);

}
