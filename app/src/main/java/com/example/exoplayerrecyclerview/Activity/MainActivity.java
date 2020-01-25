package com.example.exoplayerrecyclerview.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.exoplayerrecyclerview.Adapter.MediaRecyclerAdapter;
import com.example.exoplayerrecyclerview.Model.MediaObject;
import com.example.exoplayerrecyclerview.R;
import com.example.exoplayerrecyclerview.Utils.ExoPlayerRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ExoPlayerRecyclerView mRecyclerView;
    private ArrayList<MediaObject> mediaObjectList = new ArrayList<>();
    private MediaRecyclerAdapter mAdapter;
    private boolean firstTime = true;

    private String firstVideo = "http://blueappsoftware.in/layout_design_android_blog.mp4";
    private String secondVideo = "https://www.radiantmediaplayer.com/media/bbb-360p.mp4";
    private String thirdVideo = "https://d17h27t6h515a5.cloudfront.net/topher/2017/April/58ffdcc8_5-mix-wet-and-cry-batter-together-brownies/5-mix-wet-and-cry-batter-together-brownies.mp4";
    private String fourthVideo = "https://html5demos.com/assets/dizzy.mp4";
    private String fifthVideo = "https://www.demonuts.com/Demonuts/smallvideo.mp4";
    private String sixthVideo = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        // Prepare demo content
        prepareVideoList();

        //set data object
        mRecyclerView.setMediaObjects(mediaObjectList);
        mAdapter = new MediaRecyclerAdapter(mediaObjectList, initGlide());

        //Set Adapter
        mRecyclerView.setAdapter(mAdapter);
        if (firstTime) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    mRecyclerView.playVideo(false);
                }
            });
            firstTime = false;
        }
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.exoPlayerRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private RequestManager initGlide() {
        RequestOptions options = new RequestOptions();
        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }

    @Override
    protected void onDestroy() {
        if (mRecyclerView != null) {
            mRecyclerView.releasePlayer();
        }
        super.onDestroy();
    }

    private void prepareVideoList() {
        MediaObject mediaObject = new MediaObject();
        mediaObject.setId(1);
        mediaObject.setUserHandle("@h.pandya");
        mediaObject.setTitle(
                "Do you think the concept of marriage will no longer exist in the future?");
        mediaObject.setCoverUrl(
                "https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-1.png");
        mediaObject.setUrl(firstVideo);

        MediaObject mediaObject2 = new MediaObject();
        mediaObject2.setId(2);
        mediaObject2.setUserHandle("@hardik.patel");
        mediaObject2.setTitle(
                "If my future husband doesn't cook food as good as my mother should I scold him?");
        mediaObject2.setCoverUrl(
                "https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-2.png");
        mediaObject2.setUrl(secondVideo);

        MediaObject mediaObject3 = new MediaObject();
        mediaObject3.setId(3);
        mediaObject3.setUserHandle("@arun.gandhi");
        mediaObject3.setTitle("Hello everyone. This is great video for exo player application.");
        mediaObject3.setCoverUrl(
                "https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-3.png");
        mediaObject3.setUrl(thirdVideo);

        MediaObject mediaObject4 = new MediaObject();
        mediaObject4.setId(4);
        mediaObject4.setUserHandle("@sachin.patel");
        mediaObject4.setTitle("When did kama founders find sex offensive to Indian traditions");
        mediaObject4.setCoverUrl(
                "https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-4.png");
        mediaObject4.setUrl(fourthVideo);

        MediaObject mediaObject5 = new MediaObject();
        mediaObject5.setId(5);
        mediaObject5.setUserHandle("@sachin.patel");
        mediaObject5.setTitle("This is tet title ");
        mediaObject5.setCoverUrl(
                "https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-4.png");
        mediaObject5.setUrl(fifthVideo);

        MediaObject mediaObject6 = new MediaObject();
        mediaObject6.setId(6);
        mediaObject6.setUserHandle("@sachin.patel");
        mediaObject6.setTitle("This is tet title ");
        mediaObject6.setCoverUrl(
                "https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-4.png");
        mediaObject6.setUrl(sixthVideo);

        mediaObjectList.add(mediaObject);
        mediaObjectList.add(mediaObject2);
        mediaObjectList.add(mediaObject3);
        mediaObjectList.add(mediaObject4);
        mediaObjectList.add(mediaObject5);
        mediaObjectList.add(mediaObject6);
    }
}
