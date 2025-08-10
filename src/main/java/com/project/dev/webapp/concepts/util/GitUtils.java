package com.project.dev.webapp.concepts.util;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GitUtils {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public File cloneRepo(String gitUrl, String branch) {

		// this will only create the File object pointing to this path
		// It will not create or check any thing. But later when we try to do any
		// operation it will give exception.
		File file = new File("D:\\Git\\product\\first.pdf");

		file.mkdirs(); // to create the directory

		try {
			boolean createNewFile = file.createNewFile(); // IOException, to create the file in that directory
			if (createNewFile)
				logger.info("CREATED");
		} catch (IOException e) {
			logger.error("Exception occurred while creating the file..!!");
		}

		CloneCommand cloneCommand = Git.cloneRepository();
		cloneCommand.setURI(gitUrl);
		CredentialsProvider usernamePasswordProvider = new UsernamePasswordCredentialsProvider("username", "password");
		CredentialsProvider patTokenProvider = new UsernamePasswordCredentialsProvider("dummy_username", "PAT_Token");
		cloneCommand.setCredentialsProvider(patTokenProvider);
		cloneCommand.setDirectory(file);
		cloneCommand.setBranch(branch);

		logger.info("usernamePasswordProvider: {}", usernamePasswordProvider);

		try {
			cloneCommand.call(); // InvalidRemoteException, TransportException, GitAPIException
		} catch (GitAPIException e) {
			logger.error("Exception occurred while cloning the repo..!!");
		}

		return file;
	}

}
