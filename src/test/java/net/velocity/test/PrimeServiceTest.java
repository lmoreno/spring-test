package net.velocity.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.velocity.test.services.PrimeService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PrimeServiceTest {
	
	@Autowired
	PrimeService primeService;

	@Test
	public void testFirstPrimeNumbers() {
		assertTrue(primeService.isPrime(1));
		assertTrue(primeService.isPrime(2));
		assertTrue(primeService.isPrime(5));
		assertTrue(primeService.isPrime(7));
	}
	
	@Test
	public void testFirstNotPrimeNumbers() {
		assertFalse(primeService.isPrime(4));
		assertFalse(primeService.isPrime(6));
		assertFalse(primeService.isPrime(8));
		assertFalse(primeService.isPrime(10));
	}
	
	@Test(timeout=1000)
	public void testBigNonPrimeNumber() {
		assertFalse(primeService.isPrime(2147483647));
	}

}
