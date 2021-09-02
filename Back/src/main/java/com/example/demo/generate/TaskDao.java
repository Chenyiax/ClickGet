package com.example.demo.generate;

import com.example.demo.generate.Task;

import java.util.List;

public interface TaskDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Task record);

    int insertSelective(Task record);

    Task temp(String record);

    Task selectByPrimaryKey(Integer id);

    List<Task> selectAll();

    List<Task> selectMytask(String record);

    List<Task> get(String record);

    List<Task> searchTask(String record);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    int updateByTitle(Task record);
}