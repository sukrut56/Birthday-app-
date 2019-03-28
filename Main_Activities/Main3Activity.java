package ssdevelopers.birthday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class Main3Activity extends AppCompatActivity {
    MediaPlayer player;
    Button butten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void onMusicStart(View view) {
        if (player==null){
            player = MediaPlayer.create(this, R.raw.f22);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();

                }
            });
        }
        player.start();
    }

    public void onMusicPause(View view) {
        if(player !=  null){
            player.pause();
        }
    }

    public void onMusicStop(View view) {
        stopPlayer();
    }
    private void stopPlayer(){
        if (player!= null){
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
