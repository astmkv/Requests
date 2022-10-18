package com.example.db.models;

import com.example.db.ReqTableEntity;
import jakarta.persistence.*;



import java.util.List;

import static org.hibernate.sql.ast.Clause.WHERE;

public class DBReqOperation implements ReqOperation{

    @Override
    public void createReq(ReqTableEntity req) {
        // 1. создаем фабрику
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        // 2. manager
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // 3. объект транзакции
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            // выполнение самой операции создания записи в БД
            transaction.begin();
            entityManager.persist(req);   // создание новой записи на основе объекта
            transaction.commit();
        } finally {
            // все закрыть и откатить транзакцию, если нужно
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public ReqTableEntity getReqById(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        // переменная для хранения объекта-результата поиска
        ReqTableEntity result = null;
        try {
            transaction.begin();
            // сама операция
            result = entityManager.find(ReqTableEntity.class, id);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return result;  // вернуть результат
    }

    @Override
    public List<ReqTableEntity> getAllOrders() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        // список результатов
        List<ReqTableEntity> reqs = null;

        try {
            transaction.begin();
            // сама операция
            reqs = entityManager.createQuery("SELECT e FROM ReqTableEntity e").getResultList();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return reqs;
    }

    // не понимаю, как правильно дописать этот метод
    @Override
    public void updateReq(ReqTableEntity req) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//            // 1. получаю обновляемый объект по Id
//            ReqTableEntity updated = entityManager.find(ReqTableEntity.class, req.getIdReq());
//            // 2. обновляю поля обновляемого объекта
//            updated.updateFields(req);
//            transaction.commit();
//        } finally {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            entityManager.close();
//            entityManagerFactory.close();
//        }
    }

    @Override
    public void deleteReqById(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            // сама операция
            // 1. получить удаляемый объект
            ReqTableEntity deleted = entityManager.find(ReqTableEntity.class, id);
            // 2. удалить
            entityManager.remove(deleted);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public List<ReqTableEntity> getStartsWith(String s){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        List<ReqTableEntity> reqTableEntities;

        try{
            transaction.begin();
            reqTableEntities = entityManager.createQuery(
                    "SELECT e " +
                            "FROM ReqTableEntity e " +
                            "WHERE e.name like :name",
                    ReqTableEntity.class
            )
                    .setParameter("name",s+"%")
                    .getResultList();
            transaction.commit();}
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
            return reqTableEntities;
        }

    @Override
    public List<ReqTableEntity> getReqByPhoneStartsWith(String s){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        List<com.example.db.ReqTableEntity> reqTableEntities;

        try{
            transaction.begin();
            reqTableEntities = entityManager.createQuery(
                            "SELECT e " +
                                    "FROM ReqTableEntity e " +
                                    "WHERE e.phNumber like :ph_number",
                            com.example.db.ReqTableEntity.class
                    )
                    .setParameter("ph_number",s+"%")
                    .getResultList();
            transaction.commit();}
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return reqTableEntities;
    }
    }
