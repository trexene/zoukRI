package com.trexworkshop.www;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisTextField;
import com.trexworkshop.www.asset.Assets;
import com.trexworkshop.www.models.Courses;
import com.trexworkshop.www.models.userZouk;
import com.trexworkshop.www.screens.LoginScreen;
import lombok.Getter;
import lombok.Setter;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ZoukRI extends Game {
	SpriteBatch batch;
	Texture img;

    @Getter
    private static ZoukRI instance;

    @Getter
    private ScheduledExecutorService scheduler = null;
    @Getter
    private ZoukRIPlatformDelegate delegate;

    @Getter @Setter
    private userZouk myUser = new userZouk();

    @Getter @Setter
    private ArrayList<Courses> fullCourses = new ArrayList<>();

    @Getter @Setter
    private LoginScreen loginScreen = null;

    @Override
	public void create () {
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
        Assets.getManager();
        if(VisUI.isLoaded())
            VisUI.dispose();

        VisUI.load();
        scheduler = Executors.newSingleThreadScheduledExecutor();
//        scheduler.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//               // ping();
//            }
//        }, 1000, 3000, TimeUnit.MILLISECONDS);
        setScreen(new LoginScreen());
	}

//	@Override
//	public void render () {
////		Gdx.gl.glClearColor(1, 0, 0, 1);
////		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
////		batch.begin();
////		batch.draw(img, 0, 0);
////		batch.end();
//	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
        super.dispose();
        VisUI.dispose();
        Assets.disposeManager();
	}

    public ZoukRI(ZoukRIPlatformDelegate delegate){
        instance = this;
        this.delegate = delegate;
    }


    @Override
    public void setScreen(Screen screen) {
        if (getScreen() != null) {
            getScreen().dispose();
        }
        super.setScreen(screen);
    }

}
