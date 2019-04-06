def username = 'Jenkins'
env.CC = 'clang'
node {
	stage('Build') {
		env.DEBUG_FLAGS = '-g'
		echo 'Building..'
		echo "Hello Mr. ${username}"
		echo "Running ${env.JOB_NAME} (${env.BUILD_ID}) at ${env.JENKINS_URL}"
		deleteDir()
		checkout scm
		sh 'cat The_Weather_Channel/Jenkinsfile_Francisco_Ferreira.md'
		sh 'printenv'
		git url 'https://github.com/franciscofnneto/DevOps.git'
		withEnv(["PATH+MAVEN=${tool 'M3'}/bin"]) {
      		sh 'mvn -B verify'
      		}
	}

	
stage('Test') {
	rtMaven.tool = "maven"
		}
	
stage('Deploy') {
		echo 'Deploying....'
	}
}
