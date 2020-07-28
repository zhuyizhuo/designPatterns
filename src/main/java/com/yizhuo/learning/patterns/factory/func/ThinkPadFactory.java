package com.yizhuo.learning.patterns.factory.func;

import com.yizhuo.learning.patterns.factory.Computer;
import com.yizhuo.learning.patterns.factory.ThinkPad;

/**
 * @author zhuo
 */
public class ThinkPadFactory implements Factory{

	public Computer getComputer() {
		return new ThinkPad();
	}
	
}
