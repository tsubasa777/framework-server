package net.lunar.zeus.uid;

/**
 * 发号器
 * @author Michael
 * @version 1.0.0
 */
public interface UidGenerator {
	
	long nextId();
	
	String nextIdStr();
}
