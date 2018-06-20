package net.lunar.hypnos.uidGen;

import org.beetl.sql.core.IDAutoGen;

import net.lunar.zeus.uid.UidGenerator;

/**
 * 
 * 
 * @author Michael
 * @version 1.0.0
 */
public class HypnosUidGenerator implements IDAutoGen<Long> {
	
	private UidGenerator uidGenerator;

	@Override
	public Long nextID(String params) {
		return uidGenerator.nextId();
	}

	public void setUidGenerator(UidGenerator uidGenerator) {
		this.uidGenerator = uidGenerator;
	}

}
