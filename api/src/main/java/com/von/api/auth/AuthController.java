package com.von.api.auth;

/*
AuthUserService를 구현
AuthUserServiceImpl꺼를 가지고 와야 함.

 */

import com.von.api.user.User;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AuthController {

    AuthService auth;
    private Map<String, User> userMap;

    public AuthController() {
        this.auth = AuthServiceImpl.getInstance();

    }

    public String join(Scanner sc) {
        System.out.println("ID, " +
                "비밀번호, " +
                "비밀번호 확인, " +
                "이름, " +
                "주민번호 " +
                "전화번호, " +
                "주소, " +
                "직업을 입력해주세요");
        return auth.join(User.builder()
                .username(sc.next())
                .password(sc.next())
                .check(sc.next())
                .name(sc.next())
                .addressId(sc.nextLong())
                .job(sc.next())
                .build());
    }

    public String login(Scanner sc) {
        System.out.println("로그인 시도");
        return auth.login(User.builder()
                .username(sc.next())
                .password(sc.next())
                .build());

//        return com.von.api.auth.login();
    }

    public String addUser() {
        return auth.addUsers();

    }

    public User findUserById(Scanner scanner) {
        System.out.println("검색할 ID 입력 : ");

        return auth.findUserById(scanner.next());
    }

    public String updatePassword(Scanner scanner) {
        System.out.println("수정할 ID 입력 : ");
        System.out.println("수정할 비번 입력 : ");
        return auth.updatePassword(User.builder()
                .username(scanner.next())
                .password(scanner.next())
                .build());
    }

    public String deleteUser(Scanner scanner) {
        System.out.println("삭제할 ID 입력 : ");
        return auth.deleteUser(scanner.next());
    }

    public Map<String, ?> getUserMap() {
        System.out.println("전체 목록 출력");
        return auth.getUserMap();
    }


    public List<?> findUsersByName(Scanner scanner) {
        System.out.println("이름으로 검색");
        return auth.findUsersByName(scanner.next());
    }

    public List<?> findUsersByJob(Scanner scanner) {
        System.out.println("직업으로 검색");
        return auth.findUsersByJob(scanner.next());
    }

    public String countUsers() {
        System.out.println("회원수");
        return auth.countUsers();
    }

}


