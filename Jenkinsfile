node {
	    // reference to maven
	    // ** NOTE: This 'maven-3.8.2' Maven tool must be configured in the Jenkins Global Configuration.   
	    def mvnHome = tool 'maven-3.8.2'
	

	    // holds reference to docker image
	    def dockerImage
	    // ip address of the docker private repository(nexus)
	 
	    def dockerImageTag = "docker-test${env.BUILD_NUMBER}"
	    
	    stage('Clone Repo') { // for display purposes
	      // Get some code from a GitHub repository
	      git 'https://github.com/felipemeriga/DevOps-Example.git'
	      // Get the Maven tool.
	      // ** NOTE: This 'maven-3.8.2' Maven tool must be configured
	      // **       in the global configuration.           
	      mvnHome = tool 'maven-3.8.2'
	    }    
	  
	    stage('Build Project') {
	      // build project via maven
	      sh "'${mvnHome}/bin/mvn' clean install"
	    }
			
	    stage('Build Docker Image') {
	      // build docker image
	      dockerImage = docker.build("docker-test:${env.BUILD_NUMBER}")
	    }
	   
	    stage('Deploy Docker Image'){
	      
	      // deploy docker image to nexus
			
	      echo "Docker Image Tag Name: ${dockerImageTag}"
		  
		  sh "docker stop docker-test"
		  
		  sh "docker rm docker-test"
		  
		  sh "docker run --restart=always -v $(which docker):/usr/bin/docker--name docker-test -d -p 9011:9011 docker-test:${env.BUILD_NUMBER}"
		  
		  // docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
	      //    dockerImage.push("${env.BUILD_NUMBER}")
	      //      dockerImage.push("latest")
	      //  }
	      
	    }
	}
