package com.vikko.demo.code.year2021.month2;

/**
 * @author: vikko
 * @Date: 2021/2/2 22:23
 * @Description:
 */
@FunctionalInterface
public interface TripleConsumer<U, T, K> {

	void accept(U u, T t, K k);

}
