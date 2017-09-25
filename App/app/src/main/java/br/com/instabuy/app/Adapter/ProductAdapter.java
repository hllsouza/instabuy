package br.com.instabuy.app.Adapter;

import android.app.Activity;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.instabuy.app.Entity.Price;
import br.com.instabuy.app.Entity.ProductEntity;
import br.com.instabuy.app.R;



public class ProductAdapter extends BaseAdapter {
    private final List<ProductEntity> mProducts;
    private final Activity mActivity;
    private final String imageUrl = "https://s3-us-west-2.amazonaws.com/ib.image.small/s-";

    public ProductAdapter(List<ProductEntity> products, Activity activity) {
        this.mProducts = products;
        this.mActivity = activity;

    }

    @Override
    public int getCount() {
        return mProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return mProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mActivity.getLayoutInflater()
                .inflate(R.layout.list_view_product, parent, false);

        ProductEntity product = mProducts.get(position);

        TextView productName = (TextView)view.findViewById(R.id.product_name);
        TextView productBrand = (TextView)view.findViewById(R.id.product_brand);
        TextView productPrice = (TextView)view.findViewById(R.id.product_price);
        ImageView thumb = (ImageView) view.findViewById(R.id.thumb);

        productName.setText(product.name);
        productBrand.setText(product.brand);

        String price = setPrice(product.pc);

        productPrice.setText(price);

        Picasso.with(mActivity)
                .load(imageUrl + product.thumb)
                .placeholder(R.drawable.loading)
                .into(thumb);
        
        return view;
    }

    public String setPrice(List<Price> price) {
        if(price.get(0) == null){
            return "";
        }

        String formatPrice = price.get(0).price + "";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
            formatPrice = numberFormat.format(price.get(0).price);
        }

        return formatPrice;
    }
}
