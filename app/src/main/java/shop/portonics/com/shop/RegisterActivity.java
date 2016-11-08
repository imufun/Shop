package shop.portonics.com.shop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {

    EditText mName, mAddress, mcity, mCountry, mEmail, mPass, mZip, mPhone;
    Button button;
    RequestQueue requestQueue;
    private static String URL_REGISTER = "http://localhost:8080/apidone/DbAdapter.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        AppAPIs appAPIs = new AppAPIs();


        mName = (EditText) findViewById(R.id.IdName);
        mAddress = (EditText) findViewById(R.id.IdAddress);
        mcity = (EditText) findViewById(R.id.IdCity);
        mCountry = (EditText) findViewById(R.id.IdCountry);
        mEmail = (EditText) findViewById(R.id.IdEmail);
        mPass = (EditText) findViewById(R.id.IdPass);
        mZip = (EditText) findViewById(R.id.IdZip);
        mPhone = (EditText) findViewById(R.id.IdPhone);
        
        button = (Button) findViewById(R.id.btnInsert);


        requestQueue = Volley.newRequestQueue(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGISTER,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                System.out.println(response.toString());
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("name", mName.getText().toString());
                        parameters.put("address", mAddress.getText().toString());
                        parameters.put("city", mcity.getText().toString());
                        parameters.put("Country", mCountry.getText().toString());
                        parameters.put("email", mEmail.getText().toString());
                        parameters.put("password", mPass.getText().toString());
                        parameters.put("zip", mZip.getText().toString());
                        parameters.put("phone", mPhone.getText().toString());
                        return parameters;

                    }
                };
                // Add the request to the RequestQueue.
                requestQueue.add(stringRequest);
            }
        });

    }
}
