package com.example.answeringservice.repository;

import com.example.answeringservice.domain.MessageDetailDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MessageRepository {
    MessageDetailDto findAnswerByUniqueMessage(String uniqueMessage);

//    @Results(value = {
//            <result property="uniqueMessage" column="unique_message"/>
//            <result property="groupUsers" column="group_users"/>
//            <result property="templateId" column="template_id"/>
//            <result property="file" column="file"/>
//            <result property="typeFile" column="type_file"/>
//            <result property="data" column="data"/>
//            @Result(property = "errors", column ="errors"),
//    @Result(property="uniqueMessage", column="unique_message"),
//    @Result(property="groupUsers", column="group_users"),
//    @Result(property="templateId", column="template_id"),
//    @Result(property="file", column="file"),
//    @Result(property="typeFile", column="type_file"),
//    @Result(property="data", column="data"),
//    @Result(property = "errors", column ="errors"),
//    @Result(property = "messageText", column = "message_text"),
//    @Result(property = "errors", column = "errors"),
//    @Result(property = "date", column = "date"),
//    @Result(property = "status", column = "status"),
//    @Result(property = "dateStatus", column = "date_status"),
//})
}
