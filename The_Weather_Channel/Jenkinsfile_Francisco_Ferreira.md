def username = 'Jenkins'
node {
stage('Build') {
echo 'Building..'
echo "Hello Mr. ${username}"
deleteDir()
checkout scm
sh 'cat Jenkinsfile_Francisco_Ferreira.md'
}
stage('Test') {
echo 'Testing..'
}
stage('Deploy') {
echo 'Deploying....'
}
}