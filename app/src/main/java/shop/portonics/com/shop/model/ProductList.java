package shop.portonics.com.shop.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);


        mRequestQueue = Volley.newRequestQueue(this);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        productAdapter = new ProductAdapter(getApplicationContext(), productList);
        recyclerView = new RecyclerView(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(productAdapter);


        ProductShow();

    }

    private void ProductShow() {


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, product_url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", "Response " + response);

                        try {

//                           int pro = response.getInt("productId");
//                            String name = response.getString("productName");
//                            int catId = response.getInt("catID");
//                            int brand = response.getInt("brandID");
//                            String body = response.getString("body");
//                            double price = response.getDouble("price");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("Product", product_url);
            }
        });
        AppController.getInstance().addToRequestQueue(stringRequest);
    }
}
