package com.mono.Naukari.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements  JobService{

    @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJob(Integer id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void createJob(Job job) {
jobRepository.save(job);
    }

    @Override
    public void deleteJob(Integer id) {

jobRepository.deleteById(id);
    }

    @Override
    public void updateJob(Integer id, Job job) {
Optional<Job> jobs=jobRepository.findById(id);
if(jobs.isEmpty()){
    System.out.println("No Job Found");
}
else{
    Job j=jobs.get();
    j.setDescription(job.getDescription());
    j.setLocation(job.getLocation());
    j.setTitle(job.getTitle());
    j.setMaxSalary(job.getMaxSalary());
    j.setMinSalary(job.getMinSalary());
    jobRepository.save(j);
}
    }
}
