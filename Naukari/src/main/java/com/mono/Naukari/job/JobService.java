package com.mono.Naukari.job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs ();

    Job getJob(Integer id);

    void createJob(Job job);

    void deleteJob(Integer id);

    void updateJob(Integer id,Job job);



}
