package com.example.db.models;

import com.example.db.ReqTableEntity;

import java.util.List;

public interface ReqOperation {

    void createReq(ReqTableEntity req);         // создание

    ReqTableEntity getReqById(Long id);         // получить по id

    List<ReqTableEntity> getAllOrders();        // получить все заказы

    void updateReq(ReqTableEntity req);         // обновить

    void deleteReqById(Long id);                // удалить

    List<ReqTableEntity> getStartsWith(String s);

    List<ReqTableEntity> getReqByPhoneStartsWith(String s);
}
