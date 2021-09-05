package com.vikko.demo.algorithm.year2021.month9;

import lombok.*;

/**
 * @author vikko
 * @date 2021/9/5 14:37
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        User user = User.builder()
                .id(1)
                .name("origin")
                .build();
        User user2 = User.builder()
                .id(2)
                .name("next2")
                .build();
        User user3 = User.builder()
                .id(3)
                .name("next3")
                .build();
        user.setNext(user2);
        user2.setNext(user3);

        User dummy = user;

        user = user.getNext();


        System.out.println(user );
        System.out.println(dummy);
        System.out.println(1);
    }

}


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class User{
    private int id;
    private String name;
    private User next;
}

