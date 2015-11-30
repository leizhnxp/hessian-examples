package me.leizhnxp.examples.hessian.consumer.service;

final public class Result<T> {
	private int code;
	private T desc;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public T getDesc() {
		return desc;
	}
	public void setDesc(T desc) {
		this.desc = desc;
	}
	
}
