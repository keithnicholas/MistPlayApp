package interview.mistplay.mistplayapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.mancj.materialsearchbar.MaterialSearchBar;



public class MainActivity extends AppCompatActivity {
    Database database;
    private MaterialSearchBar searchBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchBar = (MaterialSearchBar) findViewById(R.id.searchbar);
        searchBar.disableSearch();


        searchBar.addTextChangeListener(new TextWatcher() {

            // the user's changes are saved here
            public void onTextChanged(CharSequence c, int start, int before, int count) {

            }

            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                // this space intentionally left blank
            }
            //During text changed, update query and list subsequently
            public void afterTextChanged(Editable c) {
                try {
                    database=new Database();
                    TextView textView = (TextView) findViewById(R.id.editText);
                    //textView.setText(c.toString());

                    Game[] game ;
                    game = database.search(c.toString());

                    String name="";
                    /*
                    Test if query runs (TEMPLATE)
                     */
                    for(Game g: game){
                        name += g.getTitle()+" ";
                    }
                    textView.setText(name);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }
}
