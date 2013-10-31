/**
Program: gallery
@version: 0.0.1
Last update: 31/10/13
*/

package com.example.gallery;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {	
    Integer[] imageIDs = {
    		R.drawable.picture_1,
            R.drawable.picture_2,
            R.drawable.picture_3,
            R.drawable.picture_4,
            R.drawable.picture_5                 
    };
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        
        gallery.setAdapter(new ImageAdapter(this));        
        gallery.setOnItemClickListener(new OnItemClickListener() 
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            {                
                Toast.makeText(getBaseContext(), 
                        "pic" + (position + 1) + " selected", 
                        Toast.LENGTH_SHORT).show();
                
                //---display the images selected---
                ImageView imageView = (ImageView) findViewById(R.id.image1);                
                imageView.setImageResource(imageIDs[position]);
            }
        });
    }
    
    public class ImageAdapter extends BaseAdapter 
    {
        private Context context;
        private int itemBackground;
 
        public ImageAdapter(Context c) 
        {
            context = c;
            TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
            itemBackground = a.getResourceId(
                R.styleable.Gallery1_android_galleryItemBackground, 0);
            a.recycle();                    
        }
 

        public int getCount() {
            return imageIDs.length;
        } 
        

        public Object getItem(int position) {
            return position;
        }            
          
        public long getItemId(int position) {
            return position;
        }
  
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageIDs[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new Gallery.LayoutParams(300, 250));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }    
}