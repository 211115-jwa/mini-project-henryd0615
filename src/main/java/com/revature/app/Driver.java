package com.revature.app;

import java.util.ArrayList;
import java.util.List;

import io.javalin.Javalin;

public class Driver {
	static int currentIndex;

	public static void main(String[] args) {
		List<Collection> arraylst = new ArrayList<Collection>();

		// currentIndex=0;

		Javalin app = Javalin.create();

		app.start();

		app.post("/collections", ctx -> {
			Collection collection = new Collection();

			collection.collection = ctx.formParam("items");

			arraylst.add(collection);
			currentIndex++;

			String responseText = "";

			for (Collection eachCollection : arraylst) {
				if (eachCollection != null) {
					responseText += "Item Added: " + eachCollection.collection + "<br>";
				}
			}

			ctx.html(responseText);
		});
	}
}
