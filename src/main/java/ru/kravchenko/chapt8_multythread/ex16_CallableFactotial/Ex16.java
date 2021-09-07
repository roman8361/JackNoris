package ru.kravchenko.chapt8_multythread.ex16_CallableFactotial;

import java.util.concurrent.*;

/**
 * Callable так же как и Runnable представляет собой определённое задание, которое выполняется потоком.
 * Callable можно использовать только с ExecutorService
 * В отличии от Runnable Callable
 * - имеет return type не void
 * - может выбрасывать Exception
 */

public class Ex16 {

    static long factorialResult;

    public static void main(String[] args){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(6L);
        Future<Long> future = executorService.submit(factorial); // submit передаёт наше задание в thread pool для
        // выполнения его одним из потоков и возвращает Futer в котором хранится результат выполнения нашего задания

        try {
            System.out.println(future.isDone()); // показывать таск закончен или нет
            System.out.println("Where our value?");
            factorialResult = future.get(); // метод get позволяет получить результат из объекта Future
            System.out.println(future.isDone()); // показывать таск закончен или нет
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        } finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult);
    }

}

class Factorial implements Callable<Long> {

    Long f;

    public Factorial(Long f) {
        this.f = f;
    }

    @Override
    public Long call() throws RuntimeException {
        if (f <= 0) {
            throw new RuntimeException("You enter not valid number");
        }
        long result = 1L;
        for (long i = 1; i <= f; i++) {
            result *= i;
        }
        return result;
    }

}
