package com.project.dev.webapp.concepts.endpoints;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dev.webapp.concepts.threads.Counter;
import com.project.dev.webapp.concepts.threads.MonitorLockExample;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "thread")
@Tag(name = "Thread Controller")
public class ThreadController {

	@Operation(summary = "It will demo that how the Monitor lock works which is applied on Object level and not on thread level", 
			description = "This is the description of Monitor Lock",
			tags = {"Thread Controller"},
			responses = {
					@ApiResponse(responseCode = "200", description = "Ok"),
					@ApiResponse(responseCode = "400", description = "Bad Request")
			})
	@GetMapping(value = "monitor-lock")
	public ResponseEntity<String> analyzeThread() {

		MonitorLockExample obj = new MonitorLockExample();
		MonitorLockExample obj1 = new MonitorLockExample();

		Thread t1 = new Thread(() -> obj.task1());
		Thread t2 = new Thread(() -> obj.task2());
		Thread t3 = new Thread(() -> obj.task3());

		Thread t4 = new Thread(() -> obj1.task2());

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		return new ResponseEntity<>("Monitor Lock using synchronized is working", HttpStatus.OK);
	}

	@GetMapping(value = "counter")
	public ResponseEntity<String> counterSynchronized() {

		Counter counter = new Counter();
		Runnable runnable = () -> {
			for (int i = 0; i < 100000; i++) {
				counter.increment();
			}
		};

		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);

		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>("Count after all threads completed their running = " + counter.getCount(),
				HttpStatus.OK);
	}

}
