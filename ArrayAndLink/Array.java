package com.zzq.java.test;

public class Array {
	
	//设置最开始数组，初始化
	private Integer [] arr ;
	
	//设置脚标
	private int floot = 0;
	
	//构造方法
	public Array() {
		arr = new Integer[10];
	}
	
	//构造方法,指定初始化长度
	public Array(int len) {
		if(len>0){
			arr = new Integer[len];
		}else{
			arr = new Integer[10];
		}
	}
	
	//add添加数据进去,并且动态扩容
	public boolean add(int num) {
		if(arr.length<=floot){
			Integer [] newArr = new Integer[(int)(arr.length*1.5)];
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			arr = newArr;
		}
		arr[floot++] = num; 
		return true;
	}
	
	//返回数组
	public Integer[] getArr() {
		//去除null值
		this.deleteNull();
		return this.arr;
	}
	
	//数组排序
	public Integer[] sort(boolean b) {
		//去除null值
		this.deleteNull();
		for (int i = 0; i < this.arr.length; i++) {
			for (int j = i+1; j < this.arr.length; j++) {
				if(b?this.arr[i]>this.arr[j]:this.arr[i]<this.arr[j]){
					int temp = this.arr[i];
					this.arr[i] = this.arr[j];
					this.arr[j] = temp;
				}
			}
		}
		return this.arr;
	}

	//删除null控制
	public void deleteNull() {
		for (int i = 0; i < this.arr.length; i++) {
			if(arr[i]==null){
				this.remove(i);
				i--;
			}
		}
	}

	//删除数据
	public Integer[] remove(int index) {
		if(index > this.arr.length-1){
			return this.arr;
		}
		Integer arr1 [] = new Integer[this.arr.length-1];
		int arr1Index = 0;
		for (int i = 0; i < this.arr.length; i++) {
			if(index!=i){
				arr1[arr1Index++] = this.arr[i];
			}
		}
		this.arr = arr1;
		return this.arr;
	}
	
	//数组反转
	public Integer[] reverse() {
		this.deleteNull();
		int center = (this.arr.length)/2;
		int head = 0;
		int tail = this.arr.length - 1;
		for (int i = 0; i < center; i++) {
			int temp = this.arr[head];
			this.arr[head] = this.arr[tail];
			this.arr[tail] = temp;
			head++;
			tail--;
		}
		return this.arr;
	}
	
	//根据索引修改数据
	public void set(int index,int val) {
		this.arr[index] = val;
	}
	
	//根据索引获取数据
	public Integer get(int index) {
		return this.arr[index];
	}
	
}
