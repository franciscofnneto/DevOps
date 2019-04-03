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
git url: 'https://github.com/franciscofnneto/DevOps.git'
}
stage('Test') {
echo 'Testing..'
def builInfo = rtMaven.run pom: 'pom.xml', goals: 'install'
}
stage('Deploy') {
echo 'Deploying....'
}
}