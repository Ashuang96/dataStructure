package com.hand.learning.data;

import com.hand.learning.bean.Book;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java8新特性
 * @author ZhengShuang
 * @date 2018/9/28 10:19
 */

public class Lambda {
    public static void main(String[] a){

        String[] strings = {"ad", "ab", "ac", "ae"};
        List<String> stringList = Arrays.asList(strings);
        stringList.stream().forEach(System.out::println);

        /**
         * lambda表达式
         */
        Two t = (int c, int d) -> c + d;
        int x = testLambda(2, 3, t);
        System.out.println(t.getMessage()+"----------------"+t.getNumber(15));

        Book[] books = {
                new Book(1, "Laorenyuhai", 131),
                new Book(5, "haide gushi", 133),
                new Book(3, "xiyouji", 132)
            };
        List<Book> bookList = Arrays.asList(books);
        System.out.println(bookList);

        // 集合操作，排序
        List<Book> bookList1 = bookList.stream().sorted(Comparator.comparing(Book::getId)).collect(Collectors.toList());
        System.out.println(bookList1);
        bookList1.stream().forEach(book -> {
            System.out.println(book.getId());
        });
        // 获取集合中某个对象的某个属性的集合，map方法，如id集合
        List<Integer> idList = bookList1.stream().map(book -> book.getId()).collect(Collectors.toList());
        System.out.println(idList);
        // filter方法：选择需要的数据
        List<String> nameList = bookList.stream()
                .sorted(Comparator.comparing(Book::getSaleNumber))
                .filter(book -> !("xiyouji").equals(book.getName()) && book.getId() == 1).map(book -> book.getName())
                .collect(Collectors.toList());
        System.out.println(nameList);
    }

    public static int testLambda(int a, int b, Two two) {
        return two.change(a, b);
    }

    /**
     * 函数式接口
     */
    interface Two {

        /**
         * 唯一抽象方法
         * @param a
         * @param b
         * @return
         */
        int change(int a, int b);

        default String getMessage() {
            return "hello";
        }

        default int getNumber(int number) {
            return number;
        }
    }
}
