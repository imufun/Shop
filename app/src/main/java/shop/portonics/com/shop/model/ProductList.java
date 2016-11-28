package shop.portonics.com.shop.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import shop.portonics.com.shop.R;
import shop.portonics.com.shop.adapter.ProductAdapter;
import shop.portonics.com.shop.utils.AppController;

public class ProductList extends AppCompatActivity {
    private List<Product> productList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    RequestQueue mRequestQueue;
    private String product_url = "http://localhost:8080/AndroidApi/ProdictList.php";

    Product product;


    TextView productId, productName, catID, brandID, body, price, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        mRequestQueue = Volley.newRequestQueue(this);

        productId = (TextView) findViewById(R.id.productId);
        productName = (TextView) findViewById(R.id.productName);
        catID = (TextView) findViewById(R.id.CatId);
        brandID = (TextView) findViewById(R.id.BrandName);
        body = (TextView) findViewById(R.id.BodyText);
        price = (TextView) findViewById(R.id.Price);
        //image = (ImageView) itemView.findViewById(R.id.imageView);
        type = (TextView) findViewById(R.id.Type);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        productAdapter = new ProductAdapter(getApplicationContext(), productList);
        recyclerView = new RecyclerView(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(productAdapter);


        product = new Product();
        ProductShow();

    }

    private void ProductShow() {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, product_url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // mTxtDisplay.setText("Response: " + response.toString());
                        try {


                            product.setProductID(response.getInt("productId"));
                            product.setProductName(response.getString("productName"));
                            product.setCatId(response.getInt("catID"));
                            product.setBrandId(response.getInt("brandID"));
                            product.setBodyText(response.getString("body"));
                            product.setPrice(response.getDouble("price"));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();

                    }
                });

        //Access the RequestQueue through your singleton class.
        AppController.getInstance().addToRequestQueue(jsObjRequest);
    }
}
