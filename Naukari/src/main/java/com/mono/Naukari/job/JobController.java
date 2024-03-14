package com.mono.Naukari.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
JobService jobService;

    @GetMapping("/jobs-all")
public List<Job> findAllJobs(){

    return jobService.getAllJobs();
}

@PostMapping("/jobs-create")
    public String createJob(@RequestBody Job job){
jobService.createJob(job);
        return "Job Created !!";
}

@GetMapping("/jobs/{id}")
    Job getJob(@PathVariable Integer id){
       return jobService.getJob(id);
    }


@DeleteMapping("/jobs/delete/{id}")
    void deleteJob(@PathVariable Integer id){
         jobService.deleteJob(id);
}

@PutMapping("/jobs/{id}/job")
    void updateJob(@PathVariable Integer id,@RequestBody Job job){
        jobService.updateJob(id,job);
}
}
