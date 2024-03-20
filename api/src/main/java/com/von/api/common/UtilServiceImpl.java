package com.von.api.common;

public class UtilServiceImpl implements UtilService {
    //private 접근 권한을 갖는 정적 필드 추가
    private static UtilService instance = new UtilServiceImpl();

    //생성자 선언
    private UtilServiceImpl() {
    }

    public static UtilService getInstance() {
        return instance;
    }



    @Override
    public int createRandomInteger(int start, int gapbetweenStartAndEnd) {
        return start + (int) (Math.random() * gapbetweenStartAndEnd);
    }

    @Override
    public double createRandomDouble(int start, int gapbetweenStartAndEnd) {
        double randomValue = start + Math.random() * gapbetweenStartAndEnd;
        return Double.parseDouble(String.format("%.1f", randomValue));
    }

    @Override
    public String createRandomName() {
        String[] names = {"이정재", "김다미", "송강호", "윤여정", "황정민", "정우성", "이병헌", "현 빈", "유해진", "손석구", "김태리", "손예진", "하지원", "김하늘", "송중기", "하정우", "장동건", "원 빈", "박해일", "소지섭", "김혜수"};
        return names[createRandomInteger(0, 20)];
    }

    @Override
    public String createRandomUsername(){
//        String[] username = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
//        return username[createRandomInteger(0,26)];
        String username = "";
        for(; username.length() < 5; username += String.valueOf((char)('a' + this.createRandomInteger(0, 26))));
        return username;
    }

    @Override
    public String createRandomJob() {
        String[] names = {"경찰", "소방관", "세일즈맨", "교수", "회계사",
                "공무원", "의사"};
        return names[createRandomInteger(0,6)];
    }

    @Override
    public String createRandomPw() {
        String userpw = "";
        for(; userpw.length() < 3; userpw += String.valueOf((char)('a' + this.createRandomInteger(0, 26))));
        return userpw;

    }

    @Override
    public String createRandomTitle() {
        String[] title = {"커피",
                "책",
                "비가오는 날",
                "고양이",
                "친구",
                "조깅",
                "점심",
                "오후에 한 일",
                "아름다운 노을",
                "잠에들기 전"};

        return title[createRandomInteger(0, 10)];

    }

    @Override
    public String createRandomContent() {

        String[] content = {"아침에 일어나 커피를 마셨다.",
                "책상 위에 새로운 책이 놓여 있었다.",
                "비가 오는 날은 창밖을 바라보며 생각에 잠긴다.",
                "고양이가 나른하게 햇볕을 즐기고 있었다.",
                "친구와 오랜만에 전화로 대화를 나눴다.",
                "집 앞 공원에서 조깅을 했다.",
                "점심으로는 맛있는 파스타를 먹었다.",
                "오후에는 동네 서점에 들러 책을 구경했다.",
                "저녁 노을이 참 아름다웠다.",
                "잠자리에 들기 전, 내일을 위해 계획을 세웠다."};
        return content[createRandomInteger(0, 10)];



    }

    @Override
    public String createRandomCompany() {
        String[] compaies = {"구글","엔비디아","메타","삼성","LG","애플"};
        return null;
    }



}