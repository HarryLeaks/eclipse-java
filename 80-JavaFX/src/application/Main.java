package application;

/*	
import javafx.scene.paint.PhongMaterial;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;

public class Main {
	//Pre-defined shapes
	final Box myBox = new Box(10, 10, 10);
	final PhongMaterial redMaterial = new PhongMaterial();
	
	final Cylinder myCylinder = new Cylinder(4, 10);
	final PhongMaterial blueMaterial = new PhongMaterial();
	
	final Sphere mySphere = new Sphere(4);
	final PhongMaterial greyMaterial = new PhongMaterial();
	
	public Main() {
	redMaterial.setSpecularColor(Color.ORANGE);
	redMaterial.setDiffuseColor(Color.RED);
	myBox.setMaterial(redMaterial);
	
	blueMaterial.setSpecularColor(Color.BLUE);
	blueMaterial.setDiffuseColor(Color.LIGHTBLUE);
	myCylinder.setMaterial(blueMaterial);
	
	greyMaterial.setSpecularColor(Color.DARKGREY);
	greyMaterial.setDiffuseColor(Color.GREY);
	mySphere.setMaterial(greyMaterial);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
*/

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.util.Random;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class Main extends Application {

    private Point3D dir = new Point3D(1, 0, 0);
    private Point3D next = new Point3D(0, 0, 0);

    private Group root = new Group();
    private Group snake = new Group();

    private Cube food = new Cube(Color.YELLOW);

    private Random random = new Random();

    private double t = 0;
    private AnimationTimer timer;

    private Scene createScene() {
        Cube cube = new Cube(Color.BLUE);
        snake.getChildren().add(cube);

        moveFood();

        root.getChildren().addAll(snake, food);

        Scene scene = new Scene(root, 1280, 720, true);

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll(new Translate(0, -20, -20), new Rotate(-45, Rotate.X_AXIS));

        scene.setCamera(camera);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                t += 0.016;

                if (t > 0.1) {
                    onUpdate();
                    t = 0;
                }
            }
        };

        timer.start();

        return scene;
    }

    private void moveFood() {
        food.setTranslateX(random.nextInt(10) - 5);
        food.setTranslateY(random.nextInt(10) - 5);
        food.setTranslateZ(random.nextInt(10) - 5);
    }

    private void grow() {
        moveFood();
        Cube cube = new Cube(Color.BLUE);
        cube.set(next.add(dir));

        snake.getChildren().add(cube);
    }

    private void onUpdate() {
        next = next.add(dir);
        Cube c = (Cube) snake.getChildren().remove(0);
        c.set(next);
        snake.getChildren().add(c);

        boolean collision = snake.getChildren()
                .stream()
                .map(n -> (Cube) n)
                .anyMatch(cube -> cube.isColliding(food));

        if (collision) {
            grow();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = createScene();

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {

                case W:
                    dir = new Point3D(0, 0, 1);
                    break;

                case S:
                    dir = new Point3D(0, 0, -1);
                    break;

                case A:
                    dir = new Point3D(-1, 0, 0);
                    break;

                case D:
                    dir = new Point3D(1, 0, 0);
                    break;

                case UP:
                    dir = new Point3D(0, -1, 0);
                    break;

                case DOWN:
                    dir = new Point3D(0, 1, 0);
                    break;
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    private static class Cube extends Box {

        public Cube(Color color) {
            super(1, 1, 1);
            setMaterial(new PhongMaterial(color));
        }

        public void set(Point3D p) {
            setTranslateX(p.getX());
            setTranslateY(p.getY());
            setTranslateZ(p.getZ());
        }

        public boolean isColliding(Cube c) {
            return getTranslateX() == c.getTranslateX()
                    && getTranslateY() == c.getTranslateY()
                    && getTranslateZ() == c.getTranslateZ();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}