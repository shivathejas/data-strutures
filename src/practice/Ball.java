package practice;

public class Ball {

	Ball(){
		System.out.println("hello");
	}
}
class GolfBall extends Ball{
	GolfBall(){
		System.out.println("golfball");
	}
}
 class BasketBall extends Ball{
	public BasketBall() {
		// TODO Auto-generated constructor stub
	System.out.println("basketball");
	}
	public static void main(String[] args) {
		Ball basketBall= new BasketBall();
		GolfBall golfBall = (GolfBall) basketBall;
	}
}