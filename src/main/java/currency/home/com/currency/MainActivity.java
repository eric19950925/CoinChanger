package currency.home.com.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edntd;
    private TextView tvus;
    private TextView tvjp;
    private TextView tvntd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
    }

    private void findview() {
        //存取輸入方塊
        edntd = findViewById(R.id.editText);
        tvus = findViewById(R.id.text_us);
        tvjp = findViewById(R.id.text_jp);
        tvntd = findViewById(R.id.text_ntd);
    }

    public void go(View view){

        String ntd = edntd.getText().toString();
        if(ntd.equals("")){
            new AlertDialog.Builder(this)
                    .setTitle(R.string.Error)
                    .setMessage(R.string.Please)
                    .show();
            return;
        }
        float NTD = Float.parseFloat(ntd);
        float US = NTD/30.9f;
        float JP = NTD/0.2720f;
        tvntd.setText(""+NTD);
        tvjp.setText(""+JP);
        tvus.setText(""+US);
        new AlertDialog.Builder(this)
                .setTitle(R.string.Currency)
                .setMessage(getString(R.string.NTD)+" : "+NTD+"\n\t = "+getString(R.string.JPY)+" : "+JP+"\n\t = "+getString(R.string.USD)+" : "+US)
                .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edntd.setText("");
                    }
                })
                .show();
    }
}
