package sadi.topic7.mvc.model;

import java.util.HashMap;

// one technique of implementing a system wide registry
// to simplify referencing in MVC
public class Registry extends HashMap<String, Object>
{
	// private constructor means only this one instance "singleton" is created
	private static Registry singletonInstance = new Registry();

	// define string constants for the keys
	private static final String MODEL = "Model";

	// private constructor means only one instance can be created (i.e.
	// singleton)
	private Registry()
	{
		// add contents to the registry
		Model model = ModelImpl.getSingletonInstance();
		put(MODEL, model);
	}

	public static Model getModel()
	{
		return (Model) singletonInstance.get(MODEL);
	}
}
