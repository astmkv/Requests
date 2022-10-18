package com.example.db.models;

import com.example.db.ReqTableEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DBReqOperationTest {

    @Test
    void createReq() {
        ReqTableEntity reqTableEntity = new ReqTableEntity();
        reqTableEntity.setAdress("s6vwb6");
        reqTableEntity.setEmail("aaa@mail.ru");
        reqTableEntity.setName("test");
        DBReqOperation dbReqOp = new DBReqOperation();
        dbReqOp.createReq(reqTableEntity);
        reqTableEntity.setAdress("q6bw7nmw8");
        reqTableEntity.setEmail("bbb@mail.ru");
        reqTableEntity.setName("test2");
        dbReqOp.createReq(reqTableEntity);
    }

    @Test
    void getReqById() {
        DBReqOperation dbReqOp = new DBReqOperation();
        dbReqOp.getReqById(2L);
    }

    @Test
    void getAllOrders() {
        DBReqOperation dbReqOp = new DBReqOperation();
        dbReqOp.getAllOrders();
    }

    // не понимаю, как протестировать два метода ниже
    @Test
    void updateReq() {

    }

    @Test
    void deleteReqById() {

    }

    @Test
    void getStartsWith() {
        List<ReqTableEntity> reqs = new DBReqOperation().getStartsWith("te");
        for (ReqTableEntity req : reqs) {
            System.out.println(req);
        }
    }

    @Test
    void getReqByPhoneStartsWith() {
        List<ReqTableEntity> reqs = new DBReqOperation().getReqByPhoneStartsWith("+7-");
        for (ReqTableEntity req : reqs) {
            System.out.println(req);
        }
    }
}