package org.andys.model;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.text.SimpleDateFormat;
import java.util.function.Consumer;

import org.andys.domain.Record;

public class MyAction implements Consumer<Record> {

	private final PipedOutputStream out;
	private final PipedInputStream in;
	private final SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 

	public MyAction() throws IOException {
			this.out  = new PipedOutputStream();
			this.in = new PipedInputStream(out);
			out.write("Date,Temperature\n".getBytes());
	}

	@Override
	public void accept(Record record) {
		try {
			out.write(dt.format(record.getDate()).getBytes());
			out.write(',');
			out.write(Long.toString(record.getValue()).getBytes());
			out.write('\n');

			System.out.write(dt.format(record.getDate()).getBytes());
			System.out.write(',');
			System.out.write(Long.toString(record.getValue()).getBytes());
			System.out.write('\n');
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void close() throws IOException {
		System.out.println("done");
		out.close();
	}

	public PipedInputStream getIn() {
		return in;
	}

}
