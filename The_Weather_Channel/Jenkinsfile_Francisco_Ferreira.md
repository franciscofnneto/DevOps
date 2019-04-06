def username = 'Francisco'
env.CC = 'clang'
node {
    stage('Build') {
        env.DEBUG_FLAGS = '-g'
        echo 'Building..'
        echo "Olá ${username}"
        echo "Running ${env.JOB_NAME} (${env.BUILD_ID}) at ${env.JENKINS_URL}"
        deleteDir()
        checkout scm
        sh 'cat The_Weather_Channel/Jenkinsfile_Francisco_Ferreira.md'
        sh 'printenv'
        }
   stage ('Clone') {
        git url 'https://github.com/franciscofnneto/DevOps.git'
    }

stage('Artifactory configuration') {
        rtMaven = Artifactory.newMavenBuild()
        rtMaven.tool = "Maven-3.6.0"
        rtMaven.deployer releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local', server: server
        rtMaven.resolver releaseRepo: 'libs-release', snapshotRepo: 'libs-snapshot', server: server
        rtMaven.deployer.deployArtifacts = false
        buildInfo = Artifactory.newBuildInfo()
    }
    stage ('Test') {
        rtMaven.run pom: 'The_Weather_Channel/pom.xml', goals: 'clean test'
    }
    stage ('Install') {
        rtMaven.run pom: 'The_Weather_Channel/pom.xml', goals: 'install', buildInfo: buildInfo
    }
    stage ('Deploy') {
        rtMaven.deployer.deployArtifacts buildInfo
    }
   stage('Maven build') {
        def buildInfo
        buildInfo = rtMaven.run pom: 'The_Weather_Channel/pom.xml', goals: 'clean install'
    }
}
