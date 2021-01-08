package com.leighton.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.leighton.game.MyInputProcessor;

import java.awt.Dialog;

public class Game extends ApplicationAdapter implements GestureDetector.GestureListener {
	//initalize
	public Body body;
	private OrthographicCamera cam;
	private ShapeRenderer sr;
	private ShapeRenderer shape;
	private ShapeRenderer rectang;
	private Vector3 pos;
	private SpriteBatch batch;
	Texture tex;
	Texture tex2;
	Sprite sprite;
	Sprite sprite2;


	private World world;
	private Circle Cirpostion;
	private int spriteRotationSpeed=1;
	private Vector3 touchPoint;
	private boolean touchin =false;
	private MyInputProcessor controller;
	private float StartX;
	private float StartY;
	Vector2 touchVector;
	private ContactListener circle;
	GestureDetector gestureDetector;
	BitmapFont font;
	Circle circlee;
	Ball ball;

	public  void create(){
		//Constructor, object
		shape = new ShapeRenderer();
		sr = new ShapeRenderer();
		rectang =new ShapeRenderer();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.getData().setScale(3);
		pos = new Vector3(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
		tex = new Texture(Gdx.files.internal("Cirrotatoe.png"));
		tex2 = new Texture(Gdx.files.internal("strtbox.png"));
		sprite = new Sprite(tex,323,323);
		sprite2 = new Sprite(tex2,358,344);

		gestureDetector = new GestureDetector(this);
		Gdx.input.setInputProcessor(gestureDetector);
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2, Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		sprite2.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2, Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);

		sprite.rotate(90);
		touchPoint=new Vector3();


		Cirpostion = new Circle(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2,Gdx.graphics.getHeight()/2 - sprite.getHeight()/2, 6 );
		Cirpostion.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2, Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);

		touchVector = new Vector2(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2,Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
	}

	public void render(){
		//Game logic
		cam.update();

		if(Gdx.input.isTouched()) {
			pos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			cam.unproject(pos);
		}

	double x = (Gdx.graphics.getWidth()/2 - 64/2)+35;

		//draw my images
		Gdx.gl.glClearColor(1,10,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		rectang.begin(ShapeRenderer.ShapeType.Filled);
		rectang.setColor(Color.GOLD);
		rectang.rect((Gdx.graphics.getWidth()/2 - 64/2)+45,(Gdx.graphics.getHeight()/2 - 64/2)-95,90, -10);
		rectang.end();

		batch.begin(); //where I store all my sprites
		sprite.draw(batch);
		//sprite2.draw(batch);
		batch.end();

		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.setColor(Color.GREEN);
		shape.circle((Gdx.graphics.getWidth()/2 - 64/2)+35,(Gdx.graphics.getHeight()/2 - 64/2)+30,120);
		shape.end();

		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.PINK);
		sr.circle(pos.x, pos.y, 20);
		sr.end();



		double dx = pos.x - x;
		double dy = pos.y - (Gdx.graphics.getHeight()/2 - 64/2)+30;
	double distance = Math.sqrt(dx * dx + dy * dy);

		if ((distance < 140) && Gdx.input.isTouched()) {
			touchin = true;
		}
		else
		{
			touchin = false;
		}

		double dxsprite = pos.x - Gdx.graphics.getWidth()/2 - sprite.getWidth()/2;
		double dysprite = pos.y - Gdx.graphics.getHeight()/2 - sprite.getHeight()/2;
		double distancesprite = Math.sqrt(dxsprite * dxsprite + dysprite * dysprite);

		if ( ((distancesprite < 64 + 2) && Gdx.input.isTouched()) || (... == true)   ) {
			touchin = false;
		}


			if(touchin == true)
			{
				rotateSprite();
			}
			else if(touchin == false)
			{

			}

		int b = - vec(AB).vec(BC) / BC²    // dot product
		c = (AB² - (R-r)²) / BC²
		d = b*b - c
		k = b - sqrt(d)
		if (k < 0)
			k = b + sqrt(d)
		if (k < 0)
		// no solution! we must be slightly out of the large circle

	}

	public boolean isBallCollidingWithCircle(Ball ball, Circle circle) {
		// Compute the distance between the circle and ball centers
		double dx = (double) (ball.pos.x - circle.pos.x);
		double dy = (double) (ball.pos.y - circle.pos.y);
		double distance = Math.hypot(dx, dy);

		if (distance < circle.innerRadius - ball.radius ||
				distance > circle.innerRadius + circle.thickness + ball.radius) {
			// No collision possible.
			return false;
		}

		float angle = Math.atan2(dy, dx);
		int colorsCount = circle.colors.length
		// Not entirely sure about this line, basically find the circle color from the angle.
		Color collisionColor = circle.colors[((angle + circle.rotation) / (2 * Math.PI) * colorsCount  + colorsCount) % colorsCount];
		if (collisionColor.equals(ball.color)) {
			// Same color, no collision.
			return false;
		}

		// Not the same color, collision.
		return true;
	}



	private void rotateSprite(){

		float rotation=sprite.getRotation();
		rotation+=spriteRotationSpeed;
		if(rotation>360)
			rotation-=360;
		sprite.setRotation(rotation);
	}

	private void rotateSprite3(){

		//float rotation= sprite2.getRotation();
	//	rotation+=spriteRotationSpeed;
	//	if(rotation>360)
	//		rotation-=360;
	//	sprite.setRotation(rotation);
	}

	public void dispose(){
      //get rid of assets, sounds
		sr.dispose();
		batch.dispose();
		tex.dispose();
		font.dispose();
	}



	public void hit(){
		System.out.println("I've been hit");
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}

	@Override
	public void pinchStop() {

	}
}
