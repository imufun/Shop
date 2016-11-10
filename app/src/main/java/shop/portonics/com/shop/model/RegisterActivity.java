package shop.portonics.com.shop;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import java.util.HashMap;
import java.util.Map;

import static shop.portonics.com.shop.R.id.IdName;
import static shop.portonics.com.shop.R.id.btnInsert;


public class RegisterActivity extends AppCompatActivity {

    public EditText mName, mAddress, mcity, mCountry, mEmail, mPass, mZip, mPhone;
    public String Name, Address, city, Country, Email, Pass, Zip, Phone;
    Button button;
    RequestQueue requestQueue;
    private static String URL_REGISTER = "http://169.254.194.175:8080/apidone/UserRegistration.php";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_register);
        AppAPIs appAPIs = new AppAPIs();


        mName = (EditText) findViewById(IdName);
        mAddress = (EditText) findViewById(R.id.IdAddress);
        mcity = (EditText) findViewById(R.id.IdCity);
        mCountry = (EditText) findViewById(R.id.IdCountry);
        mEmail = (EditText) findViewById(R.id.IdEmail);
        mPass = (EditText) findViewById(R.id.IdPass);
        mZip = (EditText) findViewById(R.id.IdZip);
        mPhone = (EditText) findViewById(R.id.IdPhone);

        button = (Button) findViewById(btnInsert);


        requestQueue = Volley.newRequestQueue(this);

        builder = new AlertDialog.Builder(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name = mName.getText().toString();
                Address = mAddress.getText().toString();
                city = mcity.getText().toString();
                Country = mCountry.getText().toString();
                Email = mEmail.getText().toString();
                Pass = mPass.getText().toString();
                Zip = mZip.getText().toString();
                Phone = mPhone.getText().toString();


                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGISTER,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                // builder.setTitle("SERVER RESPONSE");
                                builder.setMessage("Response :" + response);
                                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        mName.setText("");
                                        mAddress.setText("");
                                        mcity.setText("");
                                        mCountry.setText("");
                                        mEmail.setText("");
                                        mPass.setText("");
                                        mZip.setText("");
                                        mPhone.setText("");

                                    }
                                });
                                AlertDialog alertCreate = builder.create();
                                alertCreate.show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterActivity.this, "Error Network Connection", Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                        // builder.setMessage("No Network Connection!");
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("name", Name);
                        params.put("address", Address);
                        params.put("city", city);
                        params.put("country", Country);
                        params.put("email", Email);
                        params.put("password", Pass);
                        params.put("zip", Zip);
                        params.put("phone", Phone);

                        Log.d("url", URL_REGISTER);
                        return params;
                    }
                };

                AppController.getInstance().addToRequestQueue(stringRequest);

            }
        });


    }


    public void RegUser(View view) {
        Name = mName.getText().toString();
        Address = mAddress.getText().toString();
        city = mcity.getText().toString();
        Country = mCountry.getText().toString();
        Email = mEmail.getText().toString();
        Pass = mPass.getText().toString();
        Zip = mZip.getText().toString();
        Phone = mPhone.getText().toString();

        String method = "register";

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, Name, Address, city, Country, Email, Pass, Zip, Phone);
    }
}
