package liang.chapter9;

public class TestCircleRectangle_Polymorphism
{
	public static void main(String[] args)
	{
		//GeometricObject geometricObject = new GeometricObject(); // Circle(1);
		GeometricObject circle = new Circle(1);
		//
		// System.out.println(geometricObject.getArea());
		// System.out.println("The area is " + circle.getArea());
		// // System.out.println("The diameter is " + c.getDiameter());
		// // System.out.println("The radius is " + c.getRadius());
		//
		// System.exit(0);
		GeometricObject shape = new Rectangle("white", 2, 4);
		//shape = new Circle(1);
		// System.out.println("\nA rectangle " + rectangle.toString());
		// System.out.println("The area is " + rectangle.getArea());
		// System.out.println("The perimeter is " + rectangle.getPerimeter());

		// added by Caspar for more realistic Polymorphism demo
		GeometricObject go[] = new GeometricObject[]
		{ shape, new Octagon(), circle };
		// show ClassCastException
		// go[1]=(Rectangle)go[0];
		// System.out.println("And now an iteration through the superclass type");
		for (int i = 0; i < go.length; i++)
		{
			// implicitly call toString() method
			System.out.println(go[i].toString());
			// abstract class example in chapter 10 shows how to avoid
			// instanceof check
			if (go[i] instanceof Circle)
				System.out.println(((Circle) go[i]).getRadius());
		}

		// circle.getRadius();
		// ((Rectangle)shape).getPerimeter(); // ClassCastException
	}
}
