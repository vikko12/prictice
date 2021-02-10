package com.vikko.demo.code.year2020.october;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import lombok.Data;

/**
 * @author: vikko
 * @Date: 2020/9/29 14:42
 * @Description:
 */
public class ComplatableFutureTest {

	public static void main(String[] args) {
		completedFutureExample();
//		runAsyncExample();
//		thenApplyExample();
//		thenApplyAsyncExample();
//		thenApplyAsyncWithExecutorExample();
//		thenAcceptExample();
//		thenAcceptAsyncExample();
//		completeExceptionallyExample();
//		cancelExample();
//		applyToEitherExample();
//		acceptEitherExample();
//		runAfterBothExample();
//		thenAcceptBothExample();
//		thenCombineExample();
//		thenCombineAsyncExample();
//		thenComposeExample();
//		anyOfExample();
//		allOfExample();
//		allOfAsyncExample();
	}

	static void completedFutureExample() {
		CompletableFuture cf = CompletableFuture.completedFuture("message");
		System.out.println(cf.isDone());
		System.out.println("message" + cf.getNow(null));
	}

	static void runAsyncExample() {
		CompletableFuture cf = CompletableFuture.runAsync(() -> {
			System.out.println("current = "+Thread.currentThread().isDaemon());
			sleep(2000L);
			System.out.println("睡眠结束");
		});
		System.out.println(cf.isDone());
		sleep(3000L);
		System.out.println(cf.isDone());
	}

	static void thenApplyExample() {
		CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(s -> {
			System.out.println(Thread.currentThread().isDaemon());
			sleep(1000L);
			return s.toUpperCase();
		});
		System.out.println("MESSAGE __ " +  cf.getNow(null));
	}

	static void thenApplyAsyncExample() {
		CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
			System.out.println(Thread.currentThread().isDaemon());
			sleep(2000L);
			return s.toUpperCase();
		});
		System.out.println(cf.getNow(null));
		System.out.println("MESSAGE __ " +  cf.join());
	}
	static ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
		int count = 1;
		@Override
		public Thread newThread(Runnable runnable) {
			return new Thread(runnable, "custom-executor-" + count++);
		}
	});
	static void thenApplyAsyncWithExecutorExample() {
		CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
			System.out.println(Thread.currentThread().getName().startsWith("custom-executor-"));
			System.out.println(Thread.currentThread().isDaemon());
			sleep(2000L);
			return s.toUpperCase();
		}, executor);
		System.out.println(cf.getNow(null));
		System.out.println("MESSAGE" + cf.join());
	}

	static void thenAcceptExample() {
		StringBuilder result = new StringBuilder();
		CompletableFuture.completedFuture("thenAccept message")
				.thenAccept(s -> result.append(s));
		System.out.println("Result was empty =" + result.length());
	}

	static void thenAcceptAsyncExample() {
		StringBuilder result = new StringBuilder();
		CompletableFuture cf = CompletableFuture.completedFuture("thenAcceptAsync message")
				.thenAcceptAsync(s -> result.append(s));
		cf.join();
		System.out.println("Result was empty =" + result.length());
	}

	//
	static void completeExceptionallyExample() {
		CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase);
		CompletableFuture exceptionHandler = cf.handle((s, th) -> { return (th != null) ? "message upon cancel" : ""; });
		cf.completeExceptionally(new RuntimeException("completed exceptionally"));
		System.out.println("Was not completed exceptionally" + cf.isCompletedExceptionally());
		try {
			cf.join();
			System.out.println("Should have thrown an exception");
		} catch(CompletionException ex) { // just for testing
			System.out.println("completed exceptionally" + ex.getCause().getMessage());
		}
		System.out.println("message upon cancel" + exceptionHandler.join());
	}

	//
	static void cancelExample() {
		CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase);
		CompletableFuture cf2 = cf.exceptionally(throwable -> "canceled message");
		System.out.println("Was not canceled" + cf.cancel(true));
		System.out.println("Was not completed exceptionally" + cf.isCompletedExceptionally());
		System.out.println("canceled message" + cf2.join());
	}

	static void applyToEitherExample() {
		String original = "Message";
		CompletableFuture cf1 = CompletableFuture.completedFuture(original)
				.thenApplyAsync(s -> delayedUpperCase(s));
		CompletableFuture cf2 = cf1.applyToEither(
				CompletableFuture.completedFuture(original).thenApplyAsync(s -> delayedLowerCase(s)),
				s -> s + " from applyToEither");
		System.out.println(cf2.join());
	}

	static void acceptEitherExample() {
		String original = "Message";
		StringBuilder result = new StringBuilder();
		CompletableFuture cf = CompletableFuture.completedFuture(original)
				.thenApplyAsync(s -> delayedUpperCase(s))
				.acceptEither(CompletableFuture.completedFuture(original).thenApplyAsync(s -> delayedLowerCase(s)),
						s -> result.append(s).append("acceptEither"));
		cf.join();
		System.out.println("Result was empty" + result.toString().endsWith("acceptEither"));
	}

	static void runAfterBothExample() {
		String original = "Message";
		StringBuilder result = new StringBuilder();
		CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).runAfterBoth(
				CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
				() -> result.append("done"));
		System.out.println("Result was empty = " + result.length() );
	}

	static void thenAcceptBothExample() {
		String original = "Message";
		StringBuilder result = new StringBuilder();
		CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).thenAcceptBoth(
				CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
				(s1, s2) -> result.append(s1 + s2));
		System.out.println("MESSAGEmessage" + result.toString());
	}

	static void thenCombineExample() {
		String original = "Message";
		CompletableFuture cf = CompletableFuture.completedFuture(original).thenApply(s -> delayedUpperCase(s))
				.thenCombine(CompletableFuture.completedFuture(original).thenApply(s -> delayedLowerCase(s)),
						(s1, s2) -> s1 + s2);
		System.out.println("MESSAGEmessage" +  cf.getNow(null));
	}

	static void thenCombineAsyncExample() {
		String original = "Message";
		CompletableFuture cf = CompletableFuture.completedFuture(original)
				.thenApplyAsync(s -> delayedUpperCase(s))
				.thenCombine(CompletableFuture.completedFuture(original).thenApplyAsync(s -> delayedLowerCase(s)),
						(s1, s2) -> s1 + s2);
		System.out.println("MESSAGEmessage __ " + cf.join());
	}

	static void thenComposeExample() {
		String original = "Message";
		CompletableFuture cf = CompletableFuture.completedFuture(original).thenApply(s -> delayedUpperCase(s))
				.thenCompose(upper -> CompletableFuture.completedFuture(original).thenApply(s -> delayedLowerCase(s))
						.thenApply(s -> upper + s));
		System.out.println("MESSAGEmessage  " +  cf.join());
	}

	static void anyOfExample() {
		StringBuilder result = new StringBuilder();
		List<String> messages = Arrays.asList("a", "b", "c");
		List<CompletableFuture> futures = messages.stream()
				.map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> delayedUpperCase(s)))
				.collect(Collectors.toList());
		CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((res, th) -> {
			if(th == null) {
				System.out.println((String) res);
				result.append(res);
			}
		});
		System.out.println("Result was empty" + result.length());
	}

	static void allOfExample() {
		StringBuilder result = new StringBuilder();
		List<String> messages = Arrays.asList("a", "b", "c");
		List<CompletableFuture> futures = messages.stream()
				.map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> delayedUpperCase(s)))
				.collect(Collectors.toList());
		CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
				.whenComplete((v, th) -> {
					futures.forEach(cf -> System.out.println(cf.getNow(null)));
					result.append("done");
				});
		System.out.println("Result was empty" + result.length());
	}

	static void allOfAsyncExample() {
		StringBuilder result = new StringBuilder();
		List<String> messages = Arrays.asList("a", "b", "c");
		List<CompletableFuture> futures = messages.stream()
				.map(msg -> CompletableFuture.completedFuture(msg).thenApplyAsync(s -> delayedUpperCase(s)))
				.collect(Collectors.toList());
		CompletableFuture allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
				.whenComplete((v, th) -> {
					futures.forEach(cf -> System.out.println((cf.getNow(null))));
					result.append("done");
				});
		allOf.join();
		System.out.println("Result was empty" + result.length());
	}

	private static String delayedLowerCase(String s){
		sleep(1000L);
		return s.toLowerCase();
	}

	private static String delayedUpperCase(String s){
		sleep(1000L);
		return s.toUpperCase();
	}

//	public void testCars() {
//		List<Car> cars = cars();
//		cars().thenCompose(cars -> {
//			List<CompletionStage> updatedCars = cars.stream()
//					.map(car -> rating(car.manufacturerId).thenApply(r -> {
//						car.setRating(r);
//						return car;
//					})).collect(Collectors.toList());
//			CompletableFuture done = CompletableFuture
//					.allOf(updatedCars.toArray(new CompletableFuture[updatedCars.size()]));
//			return done.thenApply(v -> updatedCars.stream().map(CompletionStage::toCompletableFuture)
//					.map(CompletableFuture::join).collect(Collectors.toList()));
//		}).whenComplete((cars, th) -> {
//			if (th == null) {
//				cars.forEach(System.out::println);
//			} else {
//				throw new RuntimeException(th);
//			}
//		}).toCompletableFuture().join();
//	}
	private List<Car> cars(){
		ArrayList<Car> cars = new ArrayList<>();
		return cars;
	}




	private static void sleep(Long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Data
	class Car{
		private String name;
		private String color;
	}

}
