package com.vetweb.cli;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple EspecieCli.
 */
public class EspecieCliTest	{
	
	@Test
	public void test() {
		EspecieCli cli = new EspecieCli();
		assertTrue(!cli.getEspecies().isEmpty());
	}
	
}
