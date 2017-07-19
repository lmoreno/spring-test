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
		assertTrue(primeService.isPrime(2));
		assertTrue(primeService.isPrime(5));
		assertTrue(primeService.isPrime(7));
	}
	
	@Test
	public void testFirstNonPrimeNumbers() {
		assertFalse(primeService.isPrime(1));
		assertFalse(primeService.isPrime(4));
		assertFalse(primeService.isPrime(6));
		assertFalse(primeService.isPrime(8));
		assertFalse(primeService.isPrime(10));
	}
	
	@Test(expected=Exception.class)
	public void testExceptionIsThrownForNegativeNumbers(){
		primeService.isPrime(-1);
		primeService.isPrime(Integer.MIN_VALUE);
	}
	
	@Test(timeout=100)
	public void testBigPrimeNumberCalculationIsOptimized() {
		assertTrue(primeService.isPrime(Integer.MAX_VALUE));
	}

}
