package com.example.jpa.controller;

import com.example.jpa.daomain.User;
import com.example.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户相关请求处理控制器
 *
 * @author zhuyong
 * @version V1.0.0
 * @date 2018/10/9 14:51
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 根据ID获取用户
     *
     * @param   id      用户ID
     * @return  {User}  用户实体
     */
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id")Long id){
        return this.userRepository.findOne(id);
    }

    /**
     * 根据地址获取用户
     *
     * @param   address     用户ID
     * @return  {List}      用户实体集合
     */
    @GetMapping("/getUserByAddress")
    public List<User> getUserByAddress(@RequestParam("address")String address){
        return this.userRepository.findByAddress(address);
    }

    /**
     * 根据地址排序查询所有用户
     *
     * @return  {List}      用户实体集合
     */
    @GetMapping("/findAllUsersByAddress")
    public List<User> findAllUsersByAddress(){
        return this.userRepository.findAllUsersByAddress();
    }

    /**
     * 根据名称和地址查询用户
     *
     * @return  {List}      用户实体集合
     */
    @GetMapping("/findByNameAndAddress")
    public List<User> findByNameAndAddress(@RequestParam("name")String name,
                                           @RequestParam("address")String address){
        return this.userRepository.findByNameAndAddress(name, address);
    }

    /**
     * 根据名称模糊查询
     *
     * @param   name        用户名称
     * @return  {List}      用户实体集合
     */
    @GetMapping("/findUserByName")
    public List<User> findUserByName(@RequestParam("name")String name){
        return this.userRepository.findUserByName(name);
    }

    /**
     * 获取所有用户
     *
     * @return {List} 用户集合
     */
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    /**
     * 获取所有用户，利用自定义查询
     *
     * @return {List} 用户集合
     */
    @GetMapping("/getAllUsersSort")
    public List<User> getAllUsersSort(){
        //单个字段排序
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<User> users = this.userRepository.findAllUsersSort(sort);

        //单个字段排序，第二种构造方法
        Sort sort2 = new Sort(new Sort.Order(Sort.Direction.ASC, "name"));
        List<User> users2 = this.userRepository.findAllUsersSort(sort2);

        //多个字段排序，相同排序规则
        List<String> sortList = new ArrayList<>(2);
        sortList.add("id");
        sortList.add("name");
        Sort sort3 = new Sort(Sort.Direction.DESC, sortList);
        List<User> users3 = this.userRepository.findAllUsersSort(sort3);


        //多个字段排序，不同排序规则
        List<Sort.Order> orders = new ArrayList<>(2);
        orders.add(new Sort.Order(Sort.Direction.ASC, "id"));
        orders.add(new Sort.Order(Sort.Direction.DESC, "name"));
        List<User> users4 = this.userRepository.findAllUsersSort(new Sort(orders));

        return users4;
    }

    /**
     * 保存用户
     *
     * @return
     */
    @GetMapping("/addUser")
    public String addUser(){
        User user = new User();
        user.setName("风清扬");
        user.setAddress("昆仑");

        this.userRepository.save(user);
        return "success";
    }

    /**
     * 设置用户年龄
     *
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/setUserAgeByName/{name}/{age}")
    public String setUserAgeByName(@PathVariable("name")String name, @PathVariable("age")Integer age){
        int num = this.userRepository.setUserAgeByName(age, name);
        return "更行了：" + num + "行数据";
    }


    /**
     * 分页查询
     *
     * @param name
     * @return
     */
//    @GetMapping("/findByNameWithPage")
//    public String findByNameWithPage(@RequestParam("name")String name){
//        //构造分页对象
//        //参数含义：第一个_查询第几页，第二个_每页条数，第三个_排序规则， 第四个_排序字段
//        Pageable page = new PageRequest(0, 10, Sort.Direction.DESC, "id");
//        //执行分页查询
//        Page<User> users = this.userRepository.findByNameWithPage(name, page);
//
//        return "查询结果总行数：" + users.getTotalElements() + "， 总页数：" + users.getTotalPages();
//    }
}
