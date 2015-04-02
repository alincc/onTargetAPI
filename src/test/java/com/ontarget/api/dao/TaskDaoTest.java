//package com.ontarget.api.dao;
//
//import com.ontarget.api.BaseTest;
//import com.ontarget.bean.Address;
//import com.ontarget.bean.Project;
//import com.ontarget.bean.Task;
//import com.ontarget.constant.OnTargetConstant;
//import com.ontarget.util.Security;
//import junit.framework.Assert;
//import org.apache.log4j.Logger;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//
//import static junit.framework.Assert.fail;
//
///**
// * Created by Owner on 11/6/14.
// */
//public class TaskDaoTest extends BaseTest {
//
//    private Logger logger = Logger.getLogger(TaskDaoTest.class);
//
//    @Autowired
//    private TaskDAO taskDAO;
//
//    @Autowired
//    private ProjectDAO projectDAO;
//
//    @Autowired
//    private AddressDAO addressDAO;
//
//    @Test
//    public void testAddTask() {
//        try {
//            Project project = new Project();
//            project.setCompanyId(1);
//            project.setProjectName("test project");
//            project.setProjectDescription("test project");
//            project.setProjectParentId(0);
//            project.setProjectTypeId(1);
//            project.setStatus("PENDING");
//
//            Address address = new Address();
//            address.setAddress1("4750 59th street");
//            address.setAddress2("Apt #9C");
//            address.setCity("Woodside");
//            address.setState("NY");
//            address.setZip("11377");
//            address.setCountry("USA");
//            address.setAddressType(OnTargetConstant.AddressType.PROJECT_ADDR);
//            project.setProjectAddress(address);
//
//
//            int addressId = addressDAO.addAddress(address);
//            org.junit.Assert.assertTrue(addressId > 0);
//
//            address.setAddressId(addressId);
//
//            int projectId = projectDAO.addProject(project,1);
//            org.junit.Assert.assertTrue(projectId > 0);
//
//
//            Task task = new Task();
//            task.setTitle("title");
//            task.setDescription("description");
//            task.setSeverity("minor");
//            task.setStatus("PENDING");
//            task.setStartDate(new Date());
//            task.setEndDate(new Date());
//
//            project.setProjectId(projectId);
//
//            task.setProject(project);
//
//            Task pTask = new Task();
//            pTask.setProjectTaskId(0);
//            task.setParentTask(pTask);
//
//
//            int taskId = taskDAO.addTask(task, 1);
//            Assert.assertTrue(taskId > 0);
//        } catch (Exception e) {
//            logger.error("Fail to add task", e);
//            fail();
//        }
//
//    }
//
//    @Test
//    public void testTemp(){
//        String pass = "1234";
//        String salt = "16468408816162761056360314163240453909611518639368113122311522613954727264320999800960119461651792926693894616283890051322500209473979134653470895270221910736053124525230359038613417509020465117643578975099969164265858301330201493161869022298101183775297053607871038563272630740066062165808655461416231531384";
//        String hash = Security.encodePassword(pass, salt);
//        System.out.println(hash);
//    }
//
//    @Test
//    public void getTaskTest(){
//        try {
//            Task task = taskDAO.getTaskDetail(1);
//            System.out.printf("Task: "+ task);
//            Assert.assertTrue(task.getTitle() !=null);
//        } catch (Exception e) {
//            logger.error("Fail to get task", e);
//            fail();
//        }
//    }
//
//}
