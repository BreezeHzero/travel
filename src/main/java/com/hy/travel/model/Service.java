package com.hy.travel.model;

/**
 * Title:com.hy.travel.model
 * Description: 描述【
 * <p>   咨询内容
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/4/12 16:35
 */
public class Service {
    private int serid;
    private String question;
    private String answer;

    public Service() {
    }

    public Service(int serid, String question, String answer) {
        this.serid = serid;
        this.question = question;
        this.answer = answer;
    }

    public int getSerid() {
        return serid;
    }

    public void setSerid(int serid) {
        this.serid = serid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
