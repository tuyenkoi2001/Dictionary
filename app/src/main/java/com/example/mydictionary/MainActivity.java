package com.example.mydictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydictionary.Adapter.MeaningAdapter;
import com.example.mydictionary.Adapter.PhoneticAdapter;
import com.example.mydictionary.Models.APIrespond;

public class MainActivity extends AppCompatActivity {

    SearchView search_view;
    TextView txtword;
    RecyclerView rc_phonetics,rc_meaning;
    ProgressDialog progressBar;
    PhoneticAdapter phoneticAdapter;
    MeaningAdapter meaningAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addControl(){
        search_view = findViewById(R.id.search_view);
        txtword = findViewById(R.id.txtword);
        rc_meaning = findViewById(R.id.rc_meaning);
        rc_phonetics = findViewById(R.id.rc_phonetics);
        progressBar = new ProgressDialog(this);
    }
    private void addEvent(){
        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressBar.setTitle("Fetching data for :"+query);
                progressBar.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.GetWordMeaning(listener,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(APIrespond apiRespond, String message) {
            progressBar.dismiss();
            if(apiRespond == null){
                Toast.makeText(MainActivity.this, "No data found!", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apiRespond);
        }

        @Override
        public void onError(String message) {
            progressBar.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(APIrespond apiRespond) {
        txtword.setText(apiRespond.getWord());
        rc_phonetics.setHasFixedSize(true);
        rc_phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticAdapter = new PhoneticAdapter(this,apiRespond.getPhonetics());
        rc_phonetics.setAdapter(phoneticAdapter);

        rc_meaning.setHasFixedSize(true);
        rc_meaning.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdapter = new MeaningAdapter(this,apiRespond.getMeanings());
        rc_meaning.setAdapter(meaningAdapter);
    }
}