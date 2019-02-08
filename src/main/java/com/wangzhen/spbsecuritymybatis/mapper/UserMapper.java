package com.wangzhen.spbsecuritymybatis.mapper;

import com.wangzhen.spbsecuritymybatis.pojo.FKRole;
import com.wangzhen.spbsecuritymybatis.pojo.FKUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description
 * @Author momo
 * @Date 2019/2/8 上午11:37
 **/
public interface UserMapper {

    // 根据loginName查询用户信息，同时关联查询出用户的权限
    @Select("select * from tb_user where login_name = #{loginName}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="login_name",property="loginName"),
            @Result(column="password",property="password"),
            @Result(column="username",property="username"),
            @Result(column="id",property="roles",
                    many=@Many(select="findRoleByUser",
                            fetchType= FetchType.EAGER))
    })
    FKUser findByLoginName(String loginName);

    // 根据用户id关联查询用户的所有权限
    @Select(" SELECT id,authority FROM tb_role r,tb_user_role ur "
            + " WHERE r.id = ur.role_id AND user_id = #{id}")
    List<FKRole> findRoleByUser(Long id);

}
