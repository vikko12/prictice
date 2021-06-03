package com.vikko.demo.code.Toolkit;

import static java.util.stream.Collectors.toList;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: vikko
 * @Date: 2021/6/2 17:12
 * @Description:
 */
@Slf4j
public class SupplyAsync {

  /**
   * 异步映射
   */
  public <R, T> List<R> asyncMap(Executor executor, List<T> l, Function<T, R> f) {
    if (l == null) {
      return null;
    }

    if (l.size() == 0) {
      return Lists.newArrayList();
    }

    List<CompletableFuture<Optional<R>>> collect = l.stream()
        .map(id -> CompletableFuture.supplyAsync(() -> Optional.of(f.apply(id)), executor)
            .exceptionally(e -> Optional.empty())).collect(toList());

    return collect.stream().map(CompletableFuture::join)
        .filter(Optional::isPresent).map(Optional::get).collect(toList());
  }


  /**
   * List 分页异步批处理 带返回结果
   *
   * @param executor 线程池
   * @param l 数据源
   * @param pageSize 分页大小 默认 30
   * @param f Function
   * @param <R> 返回类型
   * @param <T> 参数类型
   * @return List<R>
   * @author Edward
   */
  public <R, T> List<R> asyncPageList(Executor executor, List<T> l, Integer pageSize,
      Function<List<T>, List<R>> f) {
    PageableList<T> pageableList = PageableList.build(l, pageSize);
    List<CompletableFuture<Optional<List<R>>>> collect = Lists.newArrayList();
    while (pageableList.isHasNext()) {
      List<T> sub = pageableList.pageNext();
      collect.add(CompletableFuture.supplyAsync(() -> Optional.of(f.apply(sub)), executor)
          .exceptionally(e -> {
            log.error(e.getMessage(), e);
            return Optional.empty();
          }));
    }
    return collect.stream().map(CompletableFuture::join).filter(Optional::isPresent)
        .map(Optional::get).flatMap(
            Collection::stream).collect(Collectors.toList());
  }

  /**
   * Set 分页异步批处理 带返回结果
   *
   * @param executor 线程池
   * @param l 数据源
   * @param pageSize 分页大小 默认 30
   * @param f Function
   * @param <R> 返回类型
   * @param <T> 参数类型
   * @return Set<R>
   * @author Edward
   */
  public <R, T> Set<R> asyncPageSet(Executor executor, Set<T> l, Integer pageSize,
      Function<Set<T>, Set<R>> f) {
    PageableList<T> pageableList = PageableList.build(l, pageSize);
    Set<CompletableFuture<Optional<Set<R>>>> collect = Sets.newHashSet();
    while (pageableList.isHasNext()) {
      Set<T> sub = Sets.newHashSet(pageableList.pageNext());
      collect.add(CompletableFuture.supplyAsync(() -> Optional.of(f.apply(sub)), executor)
          .exceptionally(e -> {
            log.error(e.getMessage(), e);
            return Optional.empty();
          }));
    }
    return collect.stream().map(CompletableFuture::join).filter(Optional::isPresent)
        .map(Optional::get).flatMap(
            Collection::stream).collect(Collectors.toSet());
  }



  public <T> void asyncPageList(Executor executor, List<T> l, Integer pageSize,
      Consumer<List<T>> consumer) {
    PageableList<T> pageableList = PageableList.build(l, pageSize);
    while (pageableList.isHasNext()) {
      List<T> sub = pageableList.pageNext();
      CompletableFuture.runAsync(() -> consumer.accept(sub), executor).exceptionally(e -> {
        log.error(e.getMessage(), e);
        return null;
      });
    }
  }


  /*public static void main(String... args) {
    List<Integer> test = Lists.newArrayList();

    for (int i = 0; i < 10000; i++) {
      test.add(2);
    }
    long start = System.currentTimeMillis();
//    test.forEach(i-> System.out.println(i*5));
    new SupplyAsync().asyncPageList(Executors.newFixedThreadPool(20),
        test,
        100,
        test2 -> test2.stream().map(v -> v ^ 5).collect(toList()))
        .forEach(System.out::println);
    long end = System.currentTimeMillis();
    System.out.println("===========" + (end - start) + "==========");
  }*/

}
