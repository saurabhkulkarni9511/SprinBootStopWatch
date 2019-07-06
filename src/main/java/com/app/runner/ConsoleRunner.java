package com.app.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class ConsoleRunner implements CommandLineRunner{

	private static Logger log=LogManager.getLogger(ConsoleRunner.class);
	@Override
	public void run(String... args) throws Exception {
		StopWatch s=new StopWatch("My Service Test");
		log.info("Block 1 Started");
		s.start();
		for(int i=0;i<9999999;i++) {
			double d=Math.random();
			d=Math.sin(d);
			d=Math.abs(d);
		}
		s.stop();

		s.start("Block 2 Started");
		for(int i=0;i<9999999;i++) {
			double d=Math.random();
			d=Math.sin(d);
			d=Math.abs(d);
		}
		s.stop();

		long ms=s.getTotalTimeMillis();
		double d=s.getTotalTimeSeconds();

		log.info("Block End"+ms);
		log.info("Block End"+d);
		log.info(s.prettyPrint());
	}
}
