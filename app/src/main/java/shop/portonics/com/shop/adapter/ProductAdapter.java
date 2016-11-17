package shop.portonics.com.shop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import shop.portonics.com.shop.R;
import shop.portonics.com.shop.model.Product;

/**
 * Created by imran on 11/13/2016.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> productList;

    public Context context;


    public ProductAdapter(Context applicationContext, List<Product> productList) {
        this.context = applicationContext;
        this.productList = productList;
    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);

        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        Product product = productList.get(position);
        holder.productId.setText(product.getProductID());
        holder.productName.setText(product.getProductName());
        holder.catID.setText(product.getCatId());
        holder.brandID.setText(product.getBrandId());
        holder.body.setText(product.getBodyText());
        holder.price.setText((int) product.getPrice());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        public TextView productId, productName, catID, brandID, body, price, type;
        ImageView image;

        public ProductViewHolder(View itemView) {
            super(itemView);
            productId = (TextView) itemView.findViewById(R.id.productId);
            productName = (TextView) itemView.findViewById(R.id.productName);
            catID = (TextView) itemView.findViewById(R.id.CatId);
            brandID = (TextView) itemView.findViewById(R.id.BrandName);
            body = (TextView) itemView.findViewById(R.id.BodyText);
            price = (TextView) itemView.findViewById(R.id.Price);
            //image = (ImageView) itemView.findViewById(R.id.imageView);
            type = (TextView) itemView.findViewById(R.id.Type);
        }
    }
}
