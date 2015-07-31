package com.johannfjs.exampleviewpager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.IconPagerAdapter;
import com.viewpagerindicator.TitlePageIndicator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


public class MainActivity extends Activity {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.ivImagen);

        //Set the pager with an adapter
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new ImagePagerAdapter());

        //Bind the title indicator to the adapter
        CirclePageIndicator titleIndicator = (CirclePageIndicator) findViewById(R.id.titles);
        titleIndicator.setViewPager(pager);

        byte[] bytes = Base64.decode(getResources().getString(R.string.image), Base64.DEFAULT);

        Bitmap decodedByte = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        //image.setImageBitmap(decodedByte);

        ByteArrayOutputStream by = new ByteArrayOutputStream();
        decodedByte.compress(Bitmap.CompressFormat.JPEG, 100, by);
        String path = MediaStore.Images.Media.insertImage(
                getApplicationContext().getContentResolver(),
                decodedByte, "Title", null);
        imageLoader.displayImage(path, image);
        try {
            bytes = null;
            by = null;
        } catch (Exception e) {

        }
    }

    private class ImagePagerAdapter extends PagerAdapter {
        private final int[] mImages = new int[]{
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image};

        @Override
        public void destroyItem(final ViewGroup container, final int position, final Object object) {
            ((ViewPager) container).removeView((ImageView) object);
        }

        @Override
        public int getCount() {
            return this.mImages.length;
        }

        @Override
        public Object instantiateItem(final ViewGroup container,
                                      final int position) {
            final Context context = MainActivity.this;
            final ImageView imageView = new ImageView(context);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageLoader.displayImage("drawable://" + mImages[position],
                    imageView);
            ((ViewPager) container).addView(imageView, 0);
            return imageView;
        }

        @Override
        public boolean isViewFromObject(final View view, final Object object) {
            return view == ((ImageView) object);
        }
    }
}
