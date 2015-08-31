package com.ontarget.api.service;

/**
 * Created by sanjeevghimire on 8/28/15.
 */
public interface BashScriptService {
    public boolean createProjectAssetFolders(String projectAssetEncryptedFolderName) throws Exception;

    public boolean  runBashScriptInRemoteServer(String projectAssetEncryptedFolderName) throws Exception;
}
