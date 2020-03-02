package com.apress.springrecipes.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SequenceService {
	@Autowired	//Connected To sequenceDao bean
	private final SequenceDao sequenceDao;
	
	@Autowired	//After Spring 4.3 class that has Unique Constructor is auto-connected
	public SequenceService(SequenceDao sequenceDao) {
		this.sequenceDao = sequenceDao;
	}
	
	public String generate(String sequenceId) {
		Sequence sequence = sequenceDao.getSequence(sequenceId);
		int value = sequenceDao.getNextValue(sequenceId);
		return sequence.getPrefix() + value + sequence.getSuffix();
	}
}
