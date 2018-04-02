package com.lambda.demol.myapplication;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        InvitationCodeView invitationCodeView = (InvitationCodeView) findViewById(R.id.id_inviationcodeview);
//        try {
//            InputStream is = getAssets().open("timg.jpg");
//            invitationCodeView.setQrBitmap(is);
//            is.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        ICLinearLayout id_icll = (ICLinearLayout) findViewById(R.id.id_icll);
        ImageView id_image = (ImageView) findViewById(R.id.id_image);
        try {
            // get input stream
            InputStream ims = getAssets().open("timg.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            id_image.setImageDrawable(d);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
