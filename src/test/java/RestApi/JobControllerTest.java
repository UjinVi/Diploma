package RestApi;

import Rest.entities.Job;
import Rest.JobController;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class JobControllerTest {
    private JobController jobController;

    @BeforeClass
    public void setUp() {
        jobController = new JobController();
    }

    @Test
    public void CreateJobTest() throws IOException {
        Job job = createRandomJob();
        jobController.postJobCreate(job);
    }

    @Test
    public void DeleteJobTest() throws IOException {
        String jobId = "22";
        jobController.postJobDeleteByJobId(jobId);;
    }

    @Test
    public void GetJobTest() throws IOException {
        String jobId = "1";
        jobController.getJobById(jobId);
        jobController.getUserJobs();
        jobController.getAllJobs();
    }

    private Job createRandomJob() {
        Job job = new Job();
        job.setId(1);
        job.setTitle("Random title");
        job.setDescription("Random description");
        job.setPrice(10);
        job.setUser("randomuser123");
        job.setNoOfComments(1);
        return job;
    }
}

