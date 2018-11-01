package com.example.jpa;

import com.example.jpa.daomain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author zhuyong
 * @version V1.0.0
 * @date 2018/11/1 10:43
 */
public class UserExtendDao {
    @PersistenceContext
    EntityManager em;

    /**
     * 获取用户信息
     *
     * @param age
     * @param name
     * @param high
     * @return
     */
    public List<User> getUserInfo(final Integer age, final String name, final Integer high){
        //定义查询对象
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);

        //定义查询连接符：from
        Root<User> root = query.from(User.class);

        //定义查询连接符：where
        //---年龄
        Predicate predicate = null;
        if (age != 0) {
            Predicate p2 = criteriaBuilder.equal(root.get("age"), age);
            if (null != predicate) {
                predicate=criteriaBuilder.and(predicate, p2);
            } else {
                predicate = p2;
            }
        }
        //---名称
        if (false == name.isEmpty()) {
            Predicate p2 = criteriaBuilder.equal(root.get("name"), name);
            if (null != predicate) {
                predicate=criteriaBuilder.and(predicate, p2);
            } else {
                predicate = p2;
            }
        }
        
        query.where(predicate);
        return em.createQuery(query).getResultList();
    }
}
