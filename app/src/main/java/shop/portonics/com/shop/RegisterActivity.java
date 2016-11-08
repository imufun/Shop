package shop.portonics.com.shop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import static shop.portonics.com.shop.R.id.IdName;


public class RegisterActivity extends AppCompatActivity {

    EditText mName, mAddress, mcity, mCountry, mEmail, mPass, mZip, mPhone;
    String Name, Address, city, Country, Email, Pass, Zip, Phone;
    Button button;
    RequestQueue requestQueue;
    private static String URL_REGISTER = "http://localhost:8080/apidone/DbAdapter.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        button = (Button) findViewById(R.id.btnInsert);


        requestQueue = Volley.newRequestQueue(this);
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

        BackgroundTask backgroundTask  =new BackgroundTask(this);
        backgroundTask.execute(method,Name,Address,city,Country,Email,Pass,Zip,Phone);
    }
}
