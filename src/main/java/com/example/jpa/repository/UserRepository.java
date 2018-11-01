package com.example.jpa.repository;

import com.example.jpa.daomain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * 用户持久层操作，这里直接继承JPA接口JpaRepository
 * 我们还可以定义实体类SimpleJpaRepository等，我们的实体就有了基本的增删改查功能，无需自行编写SQL
 *
 * @author zhuyong
 * @version V1.0.0
 * @date 2018/10/9 14:50
 */
public interface UserRepository extends JpaRepository<User, Long>{
    /**
     * 根据名称和地址查询用户
     *
     * @param   name      名称
     * @param   address   地址
     * @return  {List}    用户集合
     */
    List<User> findByNameAndAddress(String name, String address);

    /**
     * 根据地址查询用户，这里只需要定义方法，不需要自己实现SQL，实际解析时会根据方法名称生成SQL语句
     * 例如这里就是（类似）：select * from User where address = ?
     *
     * @param address
     * @return
     */
    List<User> findByAddress(String address);

    /**
     * 根据地址排序查询所有用户
     * 通过自定义SQL实现
     *
     * @return
     */
    @Query("select name,address from User order by address asc")
    List<User> findAllUsersByAddress();

    /**
     * 查询所有用户，传入自定义排序对象，可改写SQL加上指定的排序内容进行排序
     *
     * @return
     */
    @Query("select name,address from User")
    List<User> findAllUsersSort(Sort sort);

    /**
     * 根据名称模糊查询
     * 通过自定义SQL实现，传参
     *
     * @param    name    用户名称
     * @return  {List}   用户实体集合
     */
    @Query("select name, age, address from User where name like %?1")
    List<User> findUserByName(String name);

    /**
     * 更新用户年龄
     *
     * @param age
     * @param name
     * @return
     */
    @Modifying
    @Transactional
    @Query("update User set age = ?1 where name = ?2")
    int setUserAgeByName(Integer age, String name);

    /**
     * 根据名称分页查询用户
     *
     * @param   name    用户名称
     * @param   page    分页信息
     * @return  {Page} 用户集合，分页
     */
//    @QueryHints(value = {@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_COMMENT, value = "分页查询")})
//    @Query("select name, address from User where name=:name")
//    Page<User> findByNameWithPage(@Param("name") String name, Pageable page);
}
