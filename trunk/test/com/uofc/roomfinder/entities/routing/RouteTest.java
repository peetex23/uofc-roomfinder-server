package com.uofc.roomfinder.entities.routing;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RouteTest {

	private final static String JSON_STRING = "{ " + "\"features\"  : [" + "{" + "  \"geometry\" : {\"x\" : 700326.68338, \"y\" : 5662241.3256},"
			+ "  \"attributes\" : {\"name\" : \"Start\", \"routeName\" : \"unnamed\"}" + "}," + "{"
			+ "  \"geometry\" : {\"x\" : 701586.12106, \"y\" : 5662819.3331}," + "  \"attributes\" : {\"name\" : \"Destination\", \"routeName\" : \"unnamed\"}" + "}"
			+ "]" + "}";

	private final static double START_X = 700326.68338;
	private final static double START_Y = 5662241.3256;
	private final static double END_X = 701586.12106;
	private final static double END_Y = 5662819.3331;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getRouteStopsJSONtest() {
		Route testRoute = new Route(new RoutePoint(START_X, START_Y), new RoutePoint(END_X, END_Y));
		Assert.assertEquals(JSON_STRING.replace(" ", ""), testRoute.getStopsAsJsonString().replace("\n", "").replace(" ", ""));
	}
	
	@Test
	public void routeTest() {
		Route testRoute = new Route(new RoutePoint(START_X, START_Y), new RoutePoint(END_X, END_Y));
		Assert.assertTrue(testRoute.getPath().size() > 0);
		Assert.assertTrue(testRoute.getRouteFeatures().size() > 0);
		Assert.assertTrue(testRoute.getRouteName() != null);
		Assert.assertTrue(testRoute.getLength() != 0);		
	}
	
	@Test
	public void routePathTest() {
		Route testRoute = new Route(new RoutePoint(START_X, START_Y), new RoutePoint(END_X, END_Y));
		Assert.assertTrue(testRoute.getPath().get(2).getX() != 0);
		Assert.assertTrue(testRoute.getPath().get(2).getY() != 0);		
	}
	
	@Test
	public void routeFeatureTest() {
		Route testRoute = new Route(new RoutePoint(START_X, START_Y), new RoutePoint(END_X, END_Y));
		Assert.assertTrue(testRoute.getRouteFeatures().get(2).text != null);
		Assert.assertFalse(testRoute.getRouteFeatures().get(2).text.equals(""));
		Assert.assertTrue(testRoute.getRouteFeatures().get(2).getLength() != 0);		
	}

}
