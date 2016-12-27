package com.example.leijianmin.myapplication;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class TestActivity extends AppCompatActivity {

    SimpleDraweeView mImageView;
    ImageView mImageView2;
    Handler mUIHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this.getApplicationContext());
        setContentView(R.layout.activity_second);
        mImageView = (SimpleDraweeView) findViewById(R.id.image_view);
        mImageView2 = (ImageView) findViewById(R.id.image_view2);

        mUIHandler = new Handler();

//        getWindow().setBackgroundDrawableResource(R.drawable.bg_login);
//        mImageView2.setImageResource(R.drawable.bg_live_video_loading);
    }

    public void execute(View view) {
//        mImageView2.setImageDrawable(getDrawable(R.drawable.bg_login));

//        mImageView.setImageResource(R.drawable.bg_login);

//        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
//            @Override
//            public void onFailure(String id, Throwable throwable) {
//                super.onFailure(id, throwable);
//                throwable.printStackTrace();
//            }
//
//            @Override
//            public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable final Animatable animatable) {
//                if(animatable != null) {
//                    animatable.start();
//                    mUIHandler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            if(animatable.isRunning()) {
//                                animatable.stop();
//                            }
//                        }
//                    }, 1150);//gif播放1次时间为1200ms，提前一点停止动画，避免结束是显示开头的帧
//                }
//            }
//        };
//        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithResourceId(R.raw.level_up_congra).build();
//
//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setUri(imageRequest.getSourceUri())
//                .setControllerListener(controllerListener)
//                .setAutoPlayAnimations(true)
//                .build();
//        mImageView.setController(controller);
    }
}
