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
		//sh ‘echo “res" > result'
		//stash includes: ‘**/result', name: 'app'
		sh 'cat The_Weather_Channel/Jenkinsfile_Francisco_Ferreira.md'
		sh 'printenv'
		git url 'https://github.com/franciscofnneto/DevOps.git'
		withEnv(["PATH+MAVEN=${tool 'M3'}/bin"]) {
      		sh 'mvn -B verify'
      		}
	}
		
		stage ('Test02'){
			node() {
				echo 'Testing..'
				deleteDir()
				unstash 'app'
				//sh 'cat result’
				//archiveArtifacts artifacts: ‘**/result’, fingerprint: true
				}
			}
	
	stage('Test01') {	
		node() {
			echo 'Testing..'
			if (env.BRANCH_NAME == 'master') {
				echo 'Branch DevOps'
				archiveArtifacts artifacts: ‘**/result’, fingerprint: true
			} else {
				echo 'Branch Incorreta'
			}
		}
		echo 'Testing..'
		steps{
			env.GIT_COMMIT = sh(script: "git rev-parse HEAD", returnStdout: true).trim()
			echo env.GIT_COMMIT
			git url 'https://github.com/franciscofnneto/DevOps.git'
			withEnv(["PATH+MAVEN=${tool 'M3'}/bin"]) {
      			sh 'mvn -B verify'
      			}
			sh 'ant -f The_Weather_Channel/pom.xml -v'
			}
		}
	
	stage('Deploy') {
		echo 'Deploying....'
		junit 'reports/result.xml'
	}
}
