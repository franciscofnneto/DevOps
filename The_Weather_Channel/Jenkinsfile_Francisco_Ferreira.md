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

	
def server = Artifactory.server "Master"
server.credentialsId = 'Artifactory'
def rtMaven = Artifactory.newMavenBuild()
rtMaven.tool = "Maven-3.6.0"
def buildInfo

stage('Maven Build') {
    steps {
        script {
            buildInfo = rtMaven.run pom: 'appname/pom.xml', goals: '-U clean install -P dev -Dmaster.name=${Cluster} -Dcore.version=${CORE_VERSION}'
            buildInfo.retention maxBuilds: 10, maxDays: 5, deleteBuildArtifacts: true
        }
    }
}
	
stage('Deploy') {
		echo 'Deploying....'
	}
}
