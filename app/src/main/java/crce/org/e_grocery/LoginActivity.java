package crce.org.e_grocery;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity
{
    LoginDataBaseAdapter loginDataBaseAdapter=new LoginDataBaseAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void onButtonClick(View V)
    {
        if(V.getId()==R.id.LogIn) {
            EditText a=(EditText)findViewById(R.id.editTextUserNameToLogin);
            String str=a.getText().toString();
            String pass=((EditText)findViewById(R.id.editTextPasswordToLogin)).getText().toString();
            String aq=loginDataBaseAdapter.searchPass(str);
            if(pass.equals(aq)) {
                if(str.equals("root"))  //Password:1111
                    startActivity(new Intent(LoginActivity.this, RetailerActivity.class).putExtra("UserName", str));
                else
                    startActivity(new Intent(LoginActivity.this, CustomerActivity.class).putExtra("UserName", str));
            }
            else
                Toast.makeText(LoginActivity.this,"Username & password don't match",Toast.LENGTH_LONG).show();
        }
        if(V.getId()==R.id.SignIn)
            startActivity(new Intent(LoginActivity.this, SignUp.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
