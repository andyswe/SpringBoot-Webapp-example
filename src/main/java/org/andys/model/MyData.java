package org.andys.model;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.andys.domain.Record;

public class MyData implements Iterator<Record> {

	private final Iterator<Record> result;

	public MyData(Iterable<Record> result) {
		this.result = result.iterator();
	}

	@Override
	public boolean hasNext() {
		return result.hasNext();
	}

	@Override
	public Record next() {
		return result.next();
	}

	public void forEachRemaining(MyAction action) throws IOException {
		Iterator.super.forEachRemaining(action);
		action.close();
	}

}
