package com.example.gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    String[] names ={"Crazy","Katana","Kunai","Dragon","Neo-Samurai","Moby-Dick"};
    int[] namesList ={R.drawable.one, R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five, R.drawable.six};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.gridview);
        CustomAdapter customAdapter = new CustomAdapter();

        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), GridActivity.class);
                intent.putExtra("name",names[position]);
                intent.putExtra("image",namesList[position]);
                startActivity(intent);
            }
        });
    }


    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return namesList.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
         View view = getLayoutInflater().inflate(R.layout.row_data, null);
            TextView namee = view.findViewById(R.id.fruits);
            CircleImageView image = view.findViewById(R.id.images);

            namee.setText(names[position]);
            image.setImageResource(namesList[position]);
            return  view;

        }
    }
}
