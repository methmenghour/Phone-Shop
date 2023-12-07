package com.menghour.java.school.phoneshopnight.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.menghour.java.school.phoneshopnight.utils.GeneralUtils;

public class GeneralUtilsTest {
	@Test
	public void testToIntegerList() {
		//Give
		//["Dara","Thida","Seyha"]
		List<String> names=List.of("Dara","Thida","Seyha");
		//When
		List<Integer> list=GeneralUtils.toIntegerList(names);
		//Then
		assertEquals(3,list.size());
		assertEquals(4,list.get(0));
		assertEquals(5,list.get(1));
		assertEquals(5,list.get(2));
	
	}
	@Test
	public void testGetEventNumber() {
		//Give
		List<Integer> list=List.of(2,6,34,11,9,25,8);	
		//When
		List<Integer> eventNumbers=GeneralUtils.getEventNumber(list);
		//Then
		assertEquals(4,eventNumbers.size());
		assertEquals(2,eventNumbers.get(0));
	}
}
