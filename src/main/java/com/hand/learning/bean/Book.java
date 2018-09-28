package com.hand.learning.bean;


import lombok.*;

/**
 * @author ZhengShuang
 * @date 2018/9/28 10:56
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    /**
     * id
     */
    private Integer id;

    /**
     * 书名
     */
    private String name;

    /**
     * 销售编号
     */
    private Integer saleNumber;


}
