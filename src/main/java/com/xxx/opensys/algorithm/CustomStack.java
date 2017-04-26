package com.xxx.opensys.algorithm;

import java.util.Stack;

public class CustomStack extends Stack<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8698054298099190447L;
	
	Stack<Integer> maxStack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	
	public Integer getMax(){
		return maxStack.peek();
	}
	
	public Integer getMin(){
		return minStack.peek();
	}

	@Override
	public Integer push(Integer item) {
		if(this.empty()){
			maxStack.push(item);
			minStack.push(item);
		}else{
			Integer max = maxStack.peek();
			if(item < max){
				maxStack.push(max);
//				minStack.push(tmp);
			}else{
				maxStack.push(item);
//				minStack.push(item);
			}
			Integer min = minStack.peek();
			if(item > min){
				minStack.push(min);
			}else{
				minStack.push(item);
			}
		}
		return super.push(item);
	}

	@Override
	public synchronized Integer pop() {
		minStack.pop();
		maxStack.pop();
		return super.pop();
	}
	
	public static void main(String[] args) {
		CustomStack customStack = new CustomStack();
		customStack.push(4);
		customStack.push(2);
		customStack.push(3);
		customStack.push(6);
		customStack.push(7);
		Integer[] array = customStack.toArray(new Integer[customStack.size()]);
		System.out.println();
		
		
		System.out.println("max= " + customStack.getMax());
		System.out.println("min= " + customStack.getMin());
	}
	

}
