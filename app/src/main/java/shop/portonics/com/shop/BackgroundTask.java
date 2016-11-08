package shop.portonics.com.shop;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by imran on 11/8/2016.
 */

public class BackgroundTask extends AsyncTask<String, Void, Void> {

    Context context;

    public BackgroundTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... params) {
        String url = "http://192.168.56.1:8080/apidone/DbAdapter.php";
        String method = params[0];
        if (method.equals("register")) {

        }

        return null;
    }


    @Override
    protected void onProgressUpdate(Void... params) {
        super.onProgressUpdate();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}

