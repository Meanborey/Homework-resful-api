package com.istad.data_analytics_restful_api.repository;

import com.istad.data_analytics_restful_api.model.Account;
import com.istad.data_analytics_restful_api.model.User;
import com.istad.data_analytics_restful_api.model.UserAccount;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRepository {
//insert
    @Select("select * from user_tb")
    @Result(column = "id",property = "userId")
    List<User> allUsers();
    List<User> findUserByUsername(String username);
    @Insert("insert into user_tb (username, gender, address)\n"+
            "values(#{user.username},#{user.gender},#{user.address})")
    int createNewUser(@Param("user") User user);
    @Update("UPDATE user_tb SET username=#{user.username}, gender=#{user.gender}, address=#{user.address} where id =#{user.id};")
    @Result(column = "id" , property = "userId")
    int updateUser(@Param("user") User user, int id);

//select
    @Select("select * from user_tb where id = #{id}")
    @Result(column = "id" , property = "userId")
    User findUserByID(int id);
    @Delete("DELETE FROM user_tb WHERE id =#{id}")
    @Result(column = "id" , property = "userId")
    int removeUser(int id);
    @Results({
            @Result(
                    property = "account",column = "id", many = @Many(select = "findAccountByUserId")
            )
    })
    @Select("select * from user_tb")
    List<UserAccount> getAllUserAccount();
    @Result(column = "account_type", property = "accountType", one = @One(select = "com.istad.data_analytics_restful_api.repository.AccountRepository.getAccountTypeByID"))
    @Select("select * from user_account_tb\n" +
            "    inner join account_tb\n" +
            "        a on a.id = user_account_tb.account_id\n" +
            "where user_id=#{id};")
    List<Account>findAccountByUserId(int id);


}
