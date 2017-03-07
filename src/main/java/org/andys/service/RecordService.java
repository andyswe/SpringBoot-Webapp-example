package org.andys.service;

import java.util.Date;

import org.andys.domain.Record;
import org.andys.model.MyData;
import org.andys.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;;


    public Record save(Record record){
        return recordRepository.save(record);
    }

	public MyData getByInterval(Date start, Date end) {
		Iterable<Record> result = recordRepository.findByInterval(start, end);
		return new MyData(result);
	}
}
