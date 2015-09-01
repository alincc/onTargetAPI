package com.ontarget.api.service.impl;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.ontarget.api.service.BashScriptService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Created by sanjeevghimire on 8/27/15.
 */
@Service
public class BashScriptServiceImpl implements BashScriptService {

    private static Logger logger = Logger.getLogger(BashScriptServiceImpl.class);

    private static final String FILE="file:";

    @Value("${asset.server}")
    private  String hostName;

    @Value("${asset.server.username}")
    private  String hostUsername;

    @Value("${asset.server.password}")
    private  String hostPassword;

    @Value("${asset.server.port}")
    private  int hostPort;

    @Value("${asset.server.bash.script}")
    private static String bashScriptName;


    @Override
    public  boolean createProjectAssetFolders(String projectAssetEncryptedFolderName) {
        logger.debug("Running create project asset folder bash script for project folder: " + projectAssetEncryptedFolderName);

        try {
            // Run the process
            String cmd = new StringBuilder(String.valueOf(BashScriptServiceImpl.class.getResource("/bash_script/create_project_asset_folder.sh")).substring(FILE.length()))
                    .append(" ")
                    .append(projectAssetEncryptedFolderName)
                    .toString();

            Process p = Runtime.getRuntime().exec(cmd);
            // Get the input stream
                InputStream is = p.getInputStream();

            // Read script execution results
            int i = 0;
            StringBuffer sb = new StringBuffer();
            while ((i = is.read()) != -1)
                sb.append((char) i);

            System.out.println(sb.toString());

        } catch (IOException e) {
            logger.error("error while running createProjectAssetFolders unix script", e);
            return false;
        }
        logger.debug("Successfully created project asset folders: "+ projectAssetEncryptedFolderName);
        return true;

    }


    /**
     * Run bash script to create asset folder
     * @param projectAssetEncryptedFolderName
     * @return
     */
    @Override
    public  boolean  runBashScriptInRemoteServer(String projectAssetEncryptedFolderName){
        logger.debug("Running create project asset folder bash script for project folder: " + projectAssetEncryptedFolderName);
        try
        {
            JSch jsch = new JSch();
            Session session = jsch.getSession(hostUsername, hostName, hostPort);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(hostPassword);
            session.connect();

            ChannelExec channelExec = (ChannelExec)session.openChannel("exec");

            InputStream in = channelExec.getInputStream();

            // Run the process
            String cmd = new StringBuilder("sh "+String.valueOf("/apps/ontarget/bash_scripts/create_project_asset_folder.sh"))
                    .append(" ")
                    .append(projectAssetEncryptedFolderName)
                    .toString();

            //cmd="pwd";

            channelExec.setCommand(cmd);
            channelExec.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder sb=new StringBuilder();
            while ((line = reader.readLine()) != null)
            {
                sb.append(line);
            }

            int exitStatus = channelExec.getExitStatus();
            channelExec.disconnect();
            session.disconnect();

            if(exitStatus < 0){
                logger.debug("Done but exit status is not set.");
            }
            else if(exitStatus > 0){
                logger.debug("Done but with Errors");
            }
            else{
                logger.debug("Successfully created file system for asset");
            }

        }
        catch(Exception e)
        {
            logger.error("error while running createProjectAssetFolders unix script", e);
            return false;
        }

        return true;
    }

}
