def username = 'Francisco'
env.CC = 'clang'
node {
	stage('Build') {
		env.DEBUG_FLAGS = '-g'
		echo 'Building..'
		echo "Olá Francisco ${username}"
		echo "Running ${env.JOB_NAME} (${env.BUILD_ID}) at ${env.JENKINS_URL}"
		deleteDir()
		checkout scm
		sh 'cat The_Weather_Channel/Jenkinsfile_Francisco_Ferreira.md'
		sh 'printenv'
	}

	
stage('Test') {
echo 'Testing ...'
  tool: Maven-3.6.0,
    pom: 'The_Weather_Channel/pom.xml',
    goals: 'clean install'
    }
	
stage('Deploy') {
		echo 'Deploying....'
	}
}
