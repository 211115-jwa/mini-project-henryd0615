package com.revature.app;

import io.javalin.Javalin;

public class Driver {
	static int currentIndex;
	
	public static void main(String[] args) {
		currentIndex=0;
		
	
		Javalin app = Javalin.create();
		
		app.start();
		
		app.post("/collections", ctx -> {
			Collection collection = new Collection();
			collection.collection[currentIndex] = ctx.formParam("items");
			currentIndex++;
			
			String responseText = "";
			
			for (int index = 0; index < currentIndex; index++) {
				if (collection.collection[index] != null) {
					responseText += "Item Added: " + collection.collection[index] + "<br>";
				}
			}
			
			ctx.html(responseText);
		});
	}
}
