package com.it;

import lombok.Data;

/**
 * @author ZL
 * @menu todo
 * @date 2021/4/25 上午1:58
 */
@Data
public class User {

    private String name;
    private String gender;
    //private School school;

    @Data
    public static class School {
        private String name;
        private String address;
    }
}
