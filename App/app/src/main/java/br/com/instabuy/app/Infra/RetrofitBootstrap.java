package br.com.instabuy.app.Infra;



import br.com.instabuy.app.Service.ProductService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitBootstrap {
    private final Retrofit retrofit;
    public RetrofitBootstrap(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://instabuy.com.br/apiv2_2/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public ProductService getProductService() {
        return retrofit.create(ProductService.class);
    }


}
