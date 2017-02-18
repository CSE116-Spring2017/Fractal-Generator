package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.JuliaSet;

public class JuliaSetTest {

	@Test
	public void neverExceedEscapeDistance() {
		JuliaSet js = new JuliaSet();
		assertEquals(255,js.escapeTime(1.0492187499999897, -0.234375));
	}
	
	@Test
	public void ExceedEscapeDistance(){
		JuliaSet js = new JuliaSet();
		assertEquals(1,js.escapeTime(1.6933593749999853, 0.9765625));
	}

}
