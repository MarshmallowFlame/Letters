package frigebigrow.com.soundtrackofwhitechapel;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.spotify.sdk.android.player.Config;
import com.spotify.sdk.android.player.ConnectionStateCallback;
import com.spotify.sdk.android.player.Player;
import com.spotify.sdk.android.player.PlayerNotificationCallback;
import com.spotify.sdk.android.player.PlayerState;
import com.spotify.sdk.android.player.Spotify;


public class Preparing extends Activity implements
        PlayerNotificationCallback, ConnectionStateCallback {
    private String TOKEN;
    private Player mPlayer;
    private static final String CLIENT_ID = "e01aef4038d642338868f756cb4cbeea";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparing);
        Intent intent = getIntent();
        String TOKEN = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Config playerConfig = new Config(this, TOKEN, CLIENT_ID);
        mPlayer = Spotify.getPlayer(playerConfig, this, new Player.InitializationObserver() {
            @Override
            public void onInitialized(Player player) {
                mPlayer.addConnectionStateCallback(Preparing.this);
                mPlayer.addPlayerNotificationCallback(Preparing.this);
            }





            @Override
            public void onError(Throwable throwable) {
                Log.e("MainActivity", "Could not initialize player: " + throwable.getMessage());
            }
        });
        mPlayer.play("spotify:user:m%C3%A5rdis:playlist:5GR8dKIGu9G9s6FNIgqmur");
    }


    @Override
    public void onLoggedIn() {

    }

    @Override
    public void onLoggedOut() {

    }

    @Override
    public void onLoginFailed(Throwable throwable) {

    }

    @Override
    public void onTemporaryError() {

    }

    @Override
    public void onConnectionMessage(String s) {

    }

    @Override
    public void onPlaybackEvent(EventType eventType, PlayerState playerState) {

    }

    @Override
    public void onPlaybackError(ErrorType errorType, String s) {

    }
    public void ButtonOnClick(View v) {
        switch (v.getId()) {


            case R.id.Hunt:
                mPlayer.play("spotify:user:m%C3%A5rdis:playlist:3R7qcq3q19I5z1JUQMlshu");
                break;
            case R.id.Home:
                mPlayer.play("spotify:user:m%C3%A5rdis:playlist:1Mser0aKobEMyWW30tdZxJ");
                break;
            case R.id.pause:
                mPlayer.pause();
                break;

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Spotify.destroyPlayer(this);
    }
}
