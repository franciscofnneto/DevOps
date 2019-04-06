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
echo 'Testing ..'
        def server = Artifactory.server 'artifactory'
        def rtMaven = Artifactory.newMavenBuild()
        rtMaven.resolver server: server, releaseRepo: 'libs-release', snapshotRepo: 'libs-snapshot'
        rtMaven.deployer server: server, releaseRepo: 'libs-release-local', snapshotRepo: 'libs-release-local-SNAPSHOT'
        rtMaven.tool = 'Maven-3.6.0'
        def buildInfo = rtMaven.run pom: 'pom.xml', goals: 'clean package -Dskip.unit.tests=true -Dskip.integration.tests=true'
        server.publishBuildInfo buildInfo
    }
	
stage('Deploy') {
		echo 'Deploying....'
	}
}
