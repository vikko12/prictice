package com.vikko.demo.code.Toolkit;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: vikko
 * @Date: 2021/6/2 17:12
 * @Description:
 */
public class PageableList<T> {

  private Lock lock = new ReentrantLock();

  private List<T> totalData;

  private int pageSize;

  private int currentPage;

  private int totalPage;

  private int from;

  private int to;

  @Getter
  private boolean hasNext;


  public static <T> PageableList<T> build(List<T> source, Integer pageSize) {
    return new PageableList<>(source, pageSize);
  }

  public static <T> PageableList<T> build(Collection<T> source, Integer pageSize) {
    return new PageableList<>(new ArrayList<>(source), pageSize);
  }

  private PageableList(@NonNull List<T> list, @NonNull Integer pageSize) {
    this.pageSize = pageSize == null ? 30 : pageSize;
    this.totalData = list;
    this.totalPage = list.size() / this.pageSize + (list.size() % this.pageSize > 0 ? 1 : 0);
    this.currentPage = 0;
    this.from = 0;
    this.to = 0;
    hasNext = list.size() != 0;
  }

  public List<T> pageNext() {
    List<T> subList = Lists.newArrayList();
    from = currentPage * pageSize;
    if (from >= totalData.size()) {
      from = totalData.size();
      this.hasNext = false;
    }
    to = (currentPage + 1) * pageSize;
    if (to >= totalData.size()) {
      to = totalData.size();
      this.hasNext = false;
    }
    currentPage++;
    subList.addAll(totalData.subList(from, to));
    return subList;
  }


  public int totalPage() {
    return this.totalPage;
  }

  public void clean() {
    totalData.clear();
  }

  public <R> List<R> run(Function<List<T>, R> invoker) {
    List<R> rs = Lists.newArrayList();
    while (isHasNext()) {
      try {
        rs.add(invoker.apply(pageNext()));
      } catch (Exception e) {
        this.hasNext = false;
        throw e;
      }
    }
    return rs;
  }

  /*public static void main(String... args) {

    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
      list.add(i);
    }
    PageableList.build(list, 10).run(
        subIds->{
          subIds.forEach(System.out::println);
          return null;
        }

    );
    *//*ExecutorService executorService = Executors.newFixedThreadPool(10);
    PageableList<Integer> lsd = PageableList.build(list, 10);
    while (lsd.isHasNext()) {
      List<Integer> integers = lsd.pageNext();
      executorService.execute(() -> {
        integers.forEach(System.out::println);
      });
    }*//*
  }*/

}
