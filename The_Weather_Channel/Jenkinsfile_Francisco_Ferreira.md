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

	stage('Artifactory configuration') {
        Tool name from Jenkins configuration
        rtMaven.tool = "maven"
        //Set Artifactory repositories for dependencies resolution and artifacts deployment.
        rtMaven.deployer releaseRepo:'libs-release-local', snapshotRepo:'libs-snapshot-local', server: server
        rtMaven.resolver releaseRepo:'libs-release', snapshotRepo:'libs-snapshot', server: server
    }

    stage('Maven build') {
        buildInfo = rtMaven.run pom: 'The_Weather_Channel/pom.xml', goals: 'clean install'
    }
	
	stage('Test') {
		echo 'Testing..'
		steps{
			env.GIT_COMMIT = sh(script: "git rev-parse HEAD", returnStdout: true).trim()
			echo env.GIT_COMMIT
			git url 'https://github.com/franciscofnneto/DevOps.git'
			withEnv(["PATH+MAVEN=${tool 'M3'}/bin"]) {
      			sh 'mvn -B verify'
      			}
			sh 'ant -f The_Weather_Channel/pom.xml -v'
			junit 'reports/result.xml'
			}
		}
	
	stage('Deploy') {
		echo 'Deploying....'
	}
}
