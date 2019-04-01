def username = 'Jenkins'
node {
stage('Build') {
echo 'Building..'
echo "Hello Mr. ${username}"
echo "Running ${env.JOB_NAME} (${env.BUILD_ID}) at ${env.JENKINS_URL}"
deleteDir()
checkout scm
sh 'cat The_Weather_Channel/Jenkinsfile_Francisco_Ferreira.md'
}
stage('Test') {
echo 'Testing..'
}
stage('Deploy') {
echo 'Deploying....'
}
}