package crce.org.e_grocery;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Jugal on 1/13/2017.
 */

public class RetailerActivity extends Activity{

    public static final String ID="12";
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retailer);
        String username=getIntent().getStringExtra("UserName");
        TextView tv=(TextView)findViewById(R.id.textView4);
        tv1=(TextView)findViewById(R.id.textView8);
        tv.setText(username);
        Context context=getApplicationContext();
        ASyncResponse a=new ASyncResponse() {
            @Override
            public void processFinish(String output) {
                Log.e("param", output);
                Toast.makeText(RetailerActivity.this,output, Toast.LENGTH_LONG).show();
                tv1.setText(output);
            }
        };
        Connection c=new Connection("http://192.168.43.251/index.php",context);
        c.onPost(ID,a);
    }
}
