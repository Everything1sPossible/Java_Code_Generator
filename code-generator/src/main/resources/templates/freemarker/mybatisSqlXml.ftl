<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "mybatis-3-mapper.dtd" >
<mapper namespace="${namespace}">

    <select id="${selectId}">
        ${selectSql}
    </select>

    <insert id="${insertId}">
        ${insertSql}
    </insert>

    <delete id="${deleteId}">
        ${deleteSql}
    </delete>

    <update id="${updateId}">
        ${updateSql}
    </update>

</mapper>