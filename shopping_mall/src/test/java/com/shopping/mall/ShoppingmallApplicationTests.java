package com.shopping.mall;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingmallApplicationTests {

	public static void main(String[] args) {
		Integer i = 10000;
		Long s = 10000L;
		System.out.println(Objects.equals(i,s));
	}

}
