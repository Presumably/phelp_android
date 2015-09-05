package ussdmaster.divum.phelp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ussdmaster.divum.phelp.ussd.UssdUtils;


public class MainActivity extends AppCompatActivity {


    private static final String actionCall = "Intent.ACTION_CALL";
    private static String ussd;

    Button mButton;
    Button mMobileButton;
    EditText mEdit;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        setupUssdButton();
        setupMobileProviderButton();
    }

    private void getMobileProvider() {
        TelephonyManager manager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        String carrierName = manager.getNetworkOperatorName();
        Log.i("mobileProvider", carrierName);
    }

    private void setupMobileProviderButton() {
        mMobileButton = (Button) findViewById(R.id.mobileButton);
        mMobileButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        getMobileProvider();
                    }
                }
        );
    }

    private void setupUssdButton() {

        mButton = (Button) findViewById(R.id.button);
        mEdit = (EditText) findViewById(R.id.editText);
        mButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Log.i("ussdExecute", mEdit.getText().toString());
                        executeUSSD(mEdit.getText().toString());
                    }
                }
        );
    }

    private void executeUSSD(String ussdCode) {
        try {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(UssdUtils.ussdToCallableUri(ussdCode));
            startActivity(callIntent);
        } catch (Exception e) {
            Log.e("ussdExecute", e.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
